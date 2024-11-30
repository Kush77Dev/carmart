package jwtrest;

import CDI.LoginMB;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import jakarta.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.Password;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStoreHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import static jwtrest.Constant.AUTHORIZATION_HEADER;
import static jwtrest.Constant.BEARER;

@RequestScoped
@Named
public class JWTAuthenticationMechanism implements HttpAuthenticationMechanism, Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(JWTAuthenticationMechanism.class.getName());

    @Inject
    private IdentityStoreHandler identityStoreHandler;

    @Inject
    private LoginMB loginBean;

    @Inject
    private TokenProvider tokenProvider;

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext context) {

        try {
            // Check session attributes for logged-in user and group
            Object loggedGroup = request.getSession().getAttribute("logged-group");
            String requestURI = request.getRequestURI();

            if (loggedGroup == null && (requestURI.contains("/admin_side/") || requestURI.contains("/user_side/"))) {
                request.getServletContext().getRequestDispatcher("/login.jsf?faces-redirect=true").forward(request, response);
            } else if (requestURI.contains("/admin_side/") && !loggedGroup.equals("admin")) {
                request.getServletContext().getRequestDispatcher("/unauthorized.jsf?faces-redirect=true").forward(request, response);
            } else if (requestURI.contains("/user_side/") && !(loggedGroup.equals("paid-user") || loggedGroup.equals("free-user"))) {
                request.getServletContext().getRequestDispatcher("/unauthorized.jsf?faces-redirect=true").forward(request, response);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error during request validation", e);
        }

        String token = extractToken(context);

        if (token == null && loginBean.getEmail() != null) {
            Credential credential = new UsernamePasswordCredential(loginBean.getEmail(), new Password(loginBean.getPassword()));
            CredentialValidationResult result = identityStoreHandler.validate(credential);

            if (result.getStatus() == CredentialValidationResult.Status.VALID) {
                AuthenticationStatus status = createToken(result, context);
                loginBean.setStatus(status);
                loginBean.setRoles(result.getCallerGroups());
                return status;
            } else {
                loginBean.setMessage("Login Error: Either login or password is wrong. Try again.");
                loginBean.setStatus(AuthenticationStatus.SEND_FAILURE);
            }
        } else if (token != null) {
            return validateToken(token, context);
        } else if (context.isProtected()) {
            return context.responseUnauthorized();
        }

        return context.doNothing();
    }

    private AuthenticationStatus validateToken(String token, HttpMessageContext context) {
        try {
            if (tokenProvider.validateToken(token)) {
                JWTCredential credential = tokenProvider.getCredential(token);
                context.getRequest().getSession().setAttribute("token", token);
                LOGGER.info("JWT Token validated successfully");
                return context.notifyContainerAboutLogin(credential.getPrincipal(), credential.getAuthorities());
            }
            return context.responseUnauthorized();
        } catch (ExpiredJwtException e) {
            LOGGER.log(Level.INFO, "JWT token expired", e);
            return context.responseUnauthorized();
        }
    }

    private AuthenticationStatus createToken(CredentialValidationResult result, HttpMessageContext context) {
        boolean rememberMe = isRememberMe(context);
        String jwt = tokenProvider.createToken(result.getCallerPrincipal().getName(), result.getCallerGroups(), rememberMe);
        context.getResponse().addHeader(AUTHORIZATION_HEADER, BEARER + jwt);
        context.getRequest().getSession().setAttribute("token", jwt);
        LOGGER.info("JWT Token created successfully");
        return context.notifyContainerAboutLogin(result.getCallerPrincipal(), result.getCallerGroups());
    }

    private String extractToken(HttpMessageContext context) {
        String authorizationHeader = context.getRequest().getHeader(AUTHORIZATION_HEADER);
        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER)) {
            String token = authorizationHeader.substring(BEARER.length());
            context.getRequest().getSession().setAttribute("token", token);
            LOGGER.info("JWT Token extracted successfully");
            return token;
        }
        return null;
    }

    public Boolean isRememberMe(HttpMessageContext context) {
        return Boolean.valueOf(context.getRequest().getParameter("rememberme"));
    }
}
