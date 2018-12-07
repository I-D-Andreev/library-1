/**
 * Library.
 * A class to manage the whole library system.
 * @author Ivan Andreev
 */
public class Library {
    private UserManager userManager;
    private ResourceManager resourceManager;
    private User currentUserLoggedIn;

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

    public void save(){
        this.userManager.save();
        this.resourceManager.save();
        SaveStaticVariables saveStaticVariables = new SaveStaticVariables(User.getNextID(), Resource.getNextID(), Copy.getNextId());
        saveStaticVariables.save();
    }

    public User getCurrentUserLoggedIn() {
        return currentUserLoggedIn;
    }

    public void setCurrentUserLoggedIn(User currentUserLoggedIn) {
        this.currentUserLoggedIn = currentUserLoggedIn;
    }
}
