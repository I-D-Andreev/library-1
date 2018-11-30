/**
 * Library.
 * A class to manage the whole library system.
 * @author Ivan Andreev
 */
public class Library {
    UserManager userManager;
    ResourceManager resourceManager;

    public Library() {
        userManager = new UserManager();
        resourceManager = new ResourceManager();
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }
}