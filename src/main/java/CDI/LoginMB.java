package CDI;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.security.enterprise.AuthenticationStatus;
import static jakarta.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.Password;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.SecurityContext;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import jwtrest.JWTAuthenticationMechanism;

/**
 * Managed bean for handling login functionality and user roles
 */
@Named(value = "loginMB")
@RequestScoped
public class LoginMB {

    private static final Logger LOGGER = Logger.getLogger(LoginMB.class.getName());

//    @Inject
//    private SecurityContext securityContext;

    @Inject
    private JWTAuthenticationMechanism authMechanism; // Inject your custom JWT auth mechanism

    private String email;
    private String password;
    private String message;
    private AuthenticationStatus status;
    private Set<String> roles;

    // Getters and setters for email, password, message, etc.
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    /**
     * This method handles the login logic by validating the user credentials.
     * 
     * @return the next page to redirect to after login or failure
     */
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            // Get the HTTP request and response
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            // Reset session logged-group to avoid invalid session data
            request.getSession().setAttribute("logged-group", "");

            // Create the credential using email and password entered by user
            Credential credential = new UsernamePasswordCredential(email, new Password(password));

            // Call your custom JWT authentication mechanism for validation
            AuthenticationStatus status = authMechanism.validateRequest(request, response, null);

            if (status.equals(SEND_CONTINUE)) {
                // If authentication requires redirect, complete the request without sending response.
                context.responseComplete();
                return null; // The flow will continue in the HTTP authentication mechanism
            }

            // Check if the user has valid roles
            if (roles != null && !roles.isEmpty()) {
                // Handle different roles accordingly
                if (roles.contains("user")) {
                    // If the user is admin, set session and redirect
                    request.getSession().setAttribute("logged-group", "user");
                    return "home.jsf?faces-redirect=true";
                } else if (roles.contains("user") || roles.contains("employee")) {
                    // Handle user and employee roles
                    String userRole = roles.contains("user") ? "user" : "employee";
                    request.getSession().setAttribute("logged-group", userRole);
                    request.getSession().setAttribute("user-email", email);
                    return "home.jsf?faces-redirect=true";
                }
            }

            // If roles don't match, show error message
            message = "You don't have the necessary role to access the requested resource.";
            return "error.jsf?faces-redirect=true";

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Login error", e);
            message = "Error: Invalid username or password. Please try again.";
            return "error.jsf?faces-redirect=true";
        }
    }

    /**
     * Logout the user by invalidating the session and redirecting to the login page.
     *
     * @return the login page
     */
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.jsf?faces-redirect=true";
    }

}
