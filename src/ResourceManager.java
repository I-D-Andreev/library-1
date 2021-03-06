import javafx.util.Pair;
import jdk.nashorn.internal.runtime.ECMAException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

/**
 * The Class ResourceManager.
 *
 * @author Steven Lewkowicz, Christina Meggs, Ivan Andreev
 */

public class ResourceManager implements Serializable {

    private ArrayList<Resource> resources;

    /**
     * Initializes the resource manager.
     */
    public ResourceManager() {
        resources = new ArrayList<>();
        this.selfPopulate();

        // assign next ID static variable to the user class
        Resource.setNextID(new SaveStaticVariables().getResourceNextID());

        // assign the next ID static variable to the copy class
        Copy.setNextId(new SaveStaticVariables().getCopyNextID());

    }

    /**
     * Saves the changes that happened in the resource manager.
     */
    public void save() {

        // Get a file to write in or create it if it doesn't exist.
        File file = this.fileToReadWrite();

        try {
            // file writer
            // every time overwrite the file instead of just appending it
            FileOutputStream fileOut = new FileOutputStream(file, false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            // save the object to the file
            out.writeObject(resources);

            // close the file writer
            out.close();
            fileOut.close();

        } catch (IOException e) {
            System.out.println("Problem creating a file writer.");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Couldn't write to file.");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Successfully written resource to file.");
    }

    /**
     * Fills the resource manager with data.
     */
    private void selfPopulate() {
        // Get a file to read from or create it if it doesn't exist.
        File file = this.fileToReadWrite();

        try {
            // file reader
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            // read the object in the file
            ArrayList<Resource> readResource = (ArrayList<Resource>) in.readObject();

            // close the reader
            in.close();
            fileIn.close();

            // assign the variable we just read
            this.resources = readResource;

        } catch (IOException e) {
            System.out.println("Couldn't access file to read from.");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Problem in writing to file.");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Successfully read resource from file.");

    }

    // Get a file to read/write or create it if it doesn't exist.
    private File fileToReadWrite() {
        File file = null;
        try {
            file = new File("src/resources/resources.ser");
            file.createNewFile();
        } catch (Exception e) {
            System.out.println("Problem accessing file.");
            e.printStackTrace();
            System.exit(0);
        }
        return file;
    }

    /**
     * Adds a resource to the resource manager.
     *
     * @param resource The resource to be added.
     */
    public void addResource(Resource resource) {
        this.resources.add(resource);
    }

    /**
     * Adds a copy of a resource in the copy manager of the resource using the loan duration and type of resource.
     *
     * @param loanDuration The loan duration of the copy.
     * @param resource     The resource the copy is a copy of.
     */
    public void addCopyOfResource(int loanDuration, Resource resource) {
        resource.getCopyManager().addCopy(loanDuration);
    }

    /**
     * Adds a copy of a resource in the copy manager of the resource using the copy and type of resource.
     *
     * @param copy     The copy to be added.
     * @param resource The resource this copy is a copy of.
     */
    public void addCopyOfResource(Copy copy, Resource resource) {
        resource.getCopyManager().addCopy(copy);
    }

    /**
     * Removes a resource from the resource manager.
     *
     * @param resource The resource to be removed.
     */
    public void removeResource(Resource resource) {
        this.resources.remove(resource);
    }

    /**
     * Removes a resource from the resource manager using its ID.
     *
     * @param resourceId The ID of the resource to be removed.
     */
    public void removeResource(String resourceId) {
        if (this.getResourceById(resourceId) != null) {
            this.removeResource(this.getResourceById(resourceId));
        }
    }

    /**
     * Edits a resource.
     *
     * @param resource  The resource to be edited.
     * @param title     The new title of the resource.
     * @param year      The new year of the resource.
     * @param imagePath The new image path of the resource.
     */
    private void editResource(Resource resource, String title, int year, String imagePath) {
        resource.setTitle(title);
        resource.setYear(year);
        resource.setThumbnailImagePath(imagePath);
    }

    /**
     * Method to edit a laptop resource.
     *
     * @param laptop       The laptop resource to be edited.
     * @param title        The new title of the resource.
     * @param year         The new year the laptop was manufactured.
     * @param imagePath    The new thumbnail image path of the resource.
     * @param manufacturer The new manufacturer of the laptop.
     * @param model        The new model of the laptop.
     * @param installedOS  The new OS on the laptop.
     */
    public void editLaptop(Laptop laptop, String title, int year, String imagePath,
                           String manufacturer, String model, String installedOS) {
        editResource(laptop, title, year, imagePath);
        laptop.setManufacturer(manufacturer);
        laptop.setModel(model);
        laptop.setInstalledOS(installedOS);
    }

    /**
     * Method to edit a book resource.
     *
     * @param book      The book resource to be edited.
     * @param title     The new title of the book.
     * @param year      The new year the book was published.
     * @param imagePath The new thumbnail image path of the book.
     * @param author    The new author of the book.
     * @param publisher The new publisher of the book.
     * @param genre     The new genre of the book.
     * @param ISBN      The new ISBN of the book.
     * @param language  The new language of the book.
     */
    public void editBook(Book book, String title, int year, String imagePath,
                         String author, String publisher, String genre, String ISBN, String language) {
        editResource(book, title, year, imagePath);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setGenre(genre);
        book.setISBN(ISBN);
        book.setLanguage(language);
    }

    /**
     * @param dvd                     The dvd resource to be edited.
     * @param title                   The new title of the dvd.
     * @param year                    The new year the dvd came out.
     * @param imagePath               The new thumbnail image path of the dvd.
     * @param director                The new director of the dvd.
     * @param runtime                 The new runtime of the dvd.
     * @param language                The new language of the dvd.
     * @param listOfSubtitleLanguages The new list of subtitles of the dvd.
     */
    public void editDVD(DVD dvd, String title, int year, String imagePath,
                        String director, int runtime, String language, ArrayList<String> listOfSubtitleLanguages) {
        editResource(dvd, title, year, imagePath);
        dvd.setDirector(director);
        dvd.setRuntime(runtime);
        dvd.setLanguage(language);
        dvd.setListOfSubtitleLanguages(listOfSubtitleLanguages);
    }

    /**
     * Gets a resource by that resource's ID.
     *
     * @param resourceId The ID of the resource.
     * @return The resource if found, null otherwise.
     */
    public Resource getResourceById(String resourceId) {
        Resource resource = null;
        for (Resource resourceInList : resources) {
            if (resourceInList.getUniqueID().equals(resourceId)) {
                resource = resourceInList;
            }
        }
        return resource;
    }

    /**
     * Gets all the resources.
     *
     * @return An ArrayList of all the resources.
     */
    public ArrayList<Resource> getAllResources() {
        return resources;

    }

    /**
     * Returns the resources requested by a user.
     *
     * @param user The user requesting resources.
     * @return The resources he is requesting.
     */
    public ArrayList<Resource> getRequestedResourcesBy(User user) {
        ArrayList<Resource> requestedResource = new ArrayList<>();
        for (Resource resource : resources) {
            if (resource.getCopyManager().requestQueueContains(user)) {
                requestedResource.add(resource);
            }
        }
        return requestedResource;
    }

    /**
     * Removes a copy from the resources.
     *
     * @param copy The copy to be removed.
     */
    public void removeCopy(Copy copy) {
        for (Resource resource : resources) {
            resource.getCopyManager().removeCopy(copy);
        }
    }

    /**
     * Removes a copy by using its copy ID.
     *
     * @param copyId The copy's ID to be removed.
     */
    public void removeCopy(String copyId) {
        for (Resource resource : resources) {
            resource.getCopyManager().removeCopyById(copyId);
        }
    }

    /**
     * Gets a copy by its ID.
     *
     * @param copyId The copy's to be returned ID.
     * @return The copy.
     */
    public Copy getCopyById(String copyId) {
        Copy returnCopy = null;

        for (Resource resource : resources) {
            if (resource.getCopyManager().findCopyById(copyId) != null) {
                returnCopy = resource.getCopyManager().findCopyById(copyId);
            }
        }

        return returnCopy;
    }

    /**
     * Loans a copy to a user using the resource he is requesting and the user we are loaning it to.
     *
     * @param resource The resource requested.
     * @param toUser   The user that the copy is loaned to.
     * @return The user that has loaned the copy if he isn't an admin, null otherwise.
     */
    public Copy loanCopy(Resource resource, User toUser) {
        if (!toUser.hasAdminAccess()) {
            return resource.getCopyManager().loanCopy((NormalUser) toUser);
        }
        return null;
    }

    /**
     * Reserves a copy for a user.
     *
     * @param resource The resource the copy should be.
     * @param forUser  The user requesting it.
     */
    public void reserveCopy(Resource resource, User forUser) {
        resource.getCopyManager().reserveCopy((NormalUser) forUser);
    }

    /**
     * Called when a copy is to be returned.
     *
     * @param copy The copy to be returned.
     * @return The copy asked to be returned.
     */
    public double returnCopy(Copy copy) {
        return copy.returnCopy();
    }

    /**
     * Gets all the copies
     *
     * @return An ArrayList of all the copies.
     */
    public ArrayList<Copy> getAllCopies() {
        ArrayList<Copy> listOfAllCopies = new ArrayList<>();
        for (Resource resource : resources) {
            listOfAllCopies.addAll(resource.getCopyManager().getListOfAllCopies());
        }

        return listOfAllCopies;
    }

    /**
     * Gets all the reserved copies for a particular user.
     *
     * @param user The user that has reserved sine copies.
     * @return An ArrayList of the copies reserved for the user.
     */
    public ArrayList<Copy> getReservedCopiesFor(User user) {
        ArrayList<Copy> reservedCopies = new ArrayList<>();
        for (Copy copy : this.getAllCopies()) {
            if (copy.getReservedFor() != null && copy.getReservedFor().getId().equals(user.getId())) {
                reservedCopies.add(copy);
            }
        }

        return reservedCopies;
    }

    /**
     * Gets all the overdue copies.
     *
     * @return An ArrayList of the overdue copies.
     */
    public ArrayList<Copy> getOverdueCopies() {
        ArrayList<Copy> overdueCopies = new ArrayList<>();

        for (Copy copy : this.getAllCopies()) {
            if (copy.isOverdue()) {
                overdueCopies.add(copy);
            }
        }
        return overdueCopies;
    }

    /**
     * Gets all the borrowed copies for a specific user.
     *
     * @param user The user that we are finding the copies for.
     * @return An ArrayList with all the copies the user has borrowed.
     */
    public ArrayList<Copy> getBorrowedCopiesBy(User user) {
        if (!user.hasAdminAccess()) {
            return ((NormalUser) user).getBorrowedCopies();
        }
        return null;
    }

    /**
     * Find the most popular resource.
     *
     * @return A pair containing the most popular resource and the number of times it was borrowed.
     */
    public Pair<Resource, Integer> mostPopularResource() {
        if (this.getAllResources().size() == 0) {
            return null;
        }

        Resource mostPopularResource = this.getAllResources().get(0);
        int numberOfTimeBorrowed = 0;

        // Go through the history of each copy in each resource
        // and count the number of times they were borrowed.
        // The resource, whose sum of copies' borrowings is the most, will be the most popular one.

        for (Resource resource : this.getAllResources()) {
            int currentResourceNumberOfTimesBorrowed = 0;

            for (Copy copy : resource.getCopyManager().getListOfAllCopies()) {
                for (HistoryEntry entry : copy.getLoanHistory().getHistory()) {
                    if (((HistoryEntryItemTransaction) entry).isBorrowed()) {
                        currentResourceNumberOfTimesBorrowed++;
                    }
                }
            }

            if (currentResourceNumberOfTimesBorrowed > numberOfTimeBorrowed) {
                mostPopularResource = resource;
                numberOfTimeBorrowed = currentResourceNumberOfTimesBorrowed;
            }
        }

        return new Pair<Resource, Integer>(mostPopularResource, numberOfTimeBorrowed);
    }

    // todo remove this test data
    // to be removed just before end
    // test data
    /**
     * Method that fills the resource manager with data.
     */
    public void selfPopulate1() {
        Book b = new Book("Harry Potter", 2010, "", "J.K.R.", "dn");
        Book b2 = new Book("Harry Potter2", 2010, "", "J.K.R.", "dn");
        Laptop l1 = new Laptop("Lenovo", 2015, "", "LN", "S3", "W");

        this.addResource(b);
        this.addResource(b2);

        this.addResource(l1);
        this.addResource(new DVD("DVD1", 2015, "", "P", 201));

        this.addCopyOfResource(2, l1);
        this.addCopyOfResource(3, l1);
        this.addCopyOfResource(4, l1);
        this.addCopyOfResource(1, b);

    }
}
