// Superclass of all controllers
public class Controller {
    private Library library;

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
        onStart();
    }

    /**
     * Immediately invoked on load of form and with initialized parameters.
     * Should be overridden in the case when needed.
     */
    public void onStart(){
        // Override this method in the controller subclasses.
        // Equivalent of javafx initialize(), but initialize doesn't seem to be working
        // as the value of library is always null.
    }
}
