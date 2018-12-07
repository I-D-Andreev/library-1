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

    public ResourceManager() {
        resources = new ArrayList<>();
        this.selfPopulate();

        // assign next ID static variable to the user class
        Resource.setNextID(new SaveStaticVariables().getResourceNextID());

        // assign the next ID static variable to the copy class
        Copy.setNextId(new SaveStaticVariables().getCopyNextID());

    }

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


    public void addResource(Resource resource) {
        this.resources.add(resource);
    }


    public void addCopyOfResource(int loanDuration, Resource resource) {
        resource.getCopyManager().addCopy(loanDuration);
    }

    public void addCopyOfResource(Copy copy, Resource resource) {
        resource.getCopyManager().addCopy(copy);
    }

    public void removeResource(Resource resource) {
        this.resources.remove(resource);
    }

    public void removeResource(String resourceId) {
        if (this.getResourceById(resourceId) != null) {
            this.removeResource(this.getResourceById(resourceId));
        }
    }

    private void editResource(Resource resource, String title, int year, String imagePath ) {
        resource.setTitle(title);
        resource.setYear(year);
        resource.setThumbnailImagePath(imagePath);
    }

    public void editLaptop(Laptop laptop, String title, int year, String imagePath,
                           String manufacturer, String model, String installedOS){
        editResource(laptop, title, year, imagePath);
        laptop.setManufacturer(manufacturer);
        laptop.setModel(model);
        laptop.setInstalledOS(installedOS);
    }

    public void editBook(Book book, String title, int year, String imagePath,
                         String author, String publisher, String genre, String ISBN, String language){
        editResource(book, title, year, imagePath);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setGenre(genre);
        book.setISBN(ISBN);
        book.setLanguage(language);
    }

    public void editDVD(DVD dvd, String title, int year, String imagePath,
                        String director, int runtime, String language, ArrayList<String> listOfSubtitleLanguages){
        editResource(dvd, title, year, imagePath);
        dvd.setDirector(director);
        dvd.setRuntime(runtime);
        dvd.setLanguage(language);
        dvd.setListOfSubtitleLanguages(listOfSubtitleLanguages);
    }

    public Resource getResourceById(String resourceId) {
        Resource resource = null;
        for (Resource resourceInList : resources) {
            if (resourceInList.getUniqueID().equals(resourceId)) {
                resource = resourceInList;
            }
        }
        return resource;
    }

    public ArrayList<Resource> getAllResources() {
        return resources;

    }

    public ArrayList<Resource> getRequestedResourcesBy(User user) {
        ArrayList<Resource> requestedResource = new ArrayList<>();
        for (Resource resource : resources) {
            if (resource.getCopyManager().requestQueueContains(user)) {
                requestedResource.add(resource);
            }
        }
        return requestedResource;
    }

    public void removeCopy(Copy copy) {
        for (Resource resource : resources) {
            resource.getCopyManager().removeCopy(copy);
        }
    }

    public void removeCopy(String copyId) {
        for (Resource resource : resources) {
            resource.getCopyManager().removeCopyById(copyId);
        }
    }

    public Copy getCopyById(String copyId) {
        Copy returnCopy = null;

        for (Resource resource : resources) {
            if (resource.getCopyManager().findCopyById(copyId) != null) {
                returnCopy = resource.getCopyManager().findCopyById(copyId);
            }
        }

        return returnCopy;
    }

    public Copy loanCopy(Resource resource, User toUser) {
        if (!toUser.hasAdminAccess()) {
            return resource.getCopyManager().loanCopy((NormalUser) toUser);
        }
        return null;
    }

    public void reserveCopy(Resource resource, User forUser) {
        if (loanCopy(resource, forUser) == null) {
            resource.getCopyManager().addUserToTheQueue(forUser);
        }
    }

    public double returnCopy(Copy copy) {
        return copy.returnCopy();
    }


    public ArrayList<Copy> getAllCopies() {
        ArrayList<Copy> listOfAllCopies = new ArrayList<>();
        for (Resource resource : resources) {
            listOfAllCopies.addAll(resource.getCopyManager().getListOfAllCopies());
        }

        return listOfAllCopies;
    }

    public ArrayList<Copy> getReservedCopiesFor(User user) {
        ArrayList<Copy> reservedCopies = new ArrayList<>();
        for (Copy copy : this.getAllCopies()) {
            if (copy.getReservedFor().getId().equals(user.getId())) {
                reservedCopies.add(copy);
            }
        }

        return reservedCopies;
    }

    public ArrayList<Copy> getOverdueCopies() {
        ArrayList<Copy> overdueCopies = new ArrayList<>();
        Date today = new Date();

        for (Copy copy : this.getAllCopies()) {
            // If a copy's due date is "smaller" than the current date. I.E. We are past
            // the due date.
            if (copy.getDueDate() != null && copy.getDueDate().compareTo(today) == -1) {
                overdueCopies.add(copy);
            }
        }

        return overdueCopies;
    }

    public ArrayList<Copy> getBorrowedCopiesBy(User user) {
        if (!user.hasAdminAccess()) {
            return ((NormalUser) user).getBorrowedCopies();
        }
        return null;
    }

    // test data
    // to be removed just before end

    // test data
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

    }
}
