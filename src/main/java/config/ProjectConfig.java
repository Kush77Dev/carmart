package config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jdbc/carmartPool",
        callerQuery = "select password from user where email = ?",
        groupsQuery = "select g.groupName from groupmaster g " +
                      "join user u on u.groupMaster_id = g.groupMasterID " +
                      "where u.email = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30
)
@Named
@ApplicationScoped
public class ProjectConfig {

    public ProjectConfig() {
        System.out.println("Project Config Initialized");
    }
}