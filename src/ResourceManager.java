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

    public void editResource(Resource resource, Resource newResource) {
        // needs to go through attributes 1 by 1
        // and change whatever is different
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

    public boolean loanCopy(Resource resource, User toUser) {
        if (!toUser.hasAdminAccess()) {
            return resource.getCopyManager().loanCopy((NormalUser) toUser);
        }
        return false;
    }

    public void reserveCopy(Resource resource, User forUser) {
        if (!loanCopy(resource, forUser)) {
            resource.getCopyManager().addUserToTheQueue(forUser);
        }
    }

    public void returnCopy(Copy copy) {
        copy.returnCopy();
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
        Book b = new Book("123", "Harry Potter", 2010, "", "J.K.R.", "dn");

        this.addResource(b);
        this.addResource(new Laptop("123132", "Lenovo", 2015, "", "LN", "S3", "W"));
        this.addResource(new DVD("1312", "DVD1", 2015, "", "P", 201));

        this.addCopyOfResource(2, b);
        this.addCopyOfResource(3, b);
        this.addCopyOfResource(4, b);

    }
}
