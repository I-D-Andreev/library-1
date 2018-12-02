import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.*;
/**
 * The Class ResourceManager.
 *
 * @author Steven Lewkowicz, Christina Meggs, Ivan Andreev
 */

public class ResourceManager {

    private ArrayList<Resource> resources;

    public ResourceManager() {
        resources = new ArrayList<>();
        selfPopulate();
    }

    public void save() throws IOException {
        FileWriter fileWriter = new FileWriter("Resources.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (Resource r : resources) {

            printWriter.print(r.getUniqueID() + " " + r.getTitle() + " " + r.getYear() + " " + r.getThumbnailImagePath() + " ");

            if (r instanceof DVD) {
                printWriter.print("DVD" + " " + ((DVD) r).getDirector() + " " + ((DVD) r).getRuntime() + " " + ((DVD) r).getListOfSubtitleLanguages().size() + " ");
                for (String lang : ((DVD) r).getListOfSubtitleLanguages()) {
                    printWriter.print(lang + " ");
                }
            }
            else if (r instanceof Laptop) {
                printWriter.print("Laptop" + " " + ((Laptop) r).getManufacturer() + " " + ((Laptop) r).getModel() + " " + ((Laptop) r).getInstalledOS() + " ");
            }
            else if (r instanceof Book) {
                printWriter.print("Book" + " " + ((Book) r).getAuthor() + " " + ((Book) r).getPublisher() + " "
                        + ((Book) r).getGenre() + " " + ((Book) r).getISBN() + " " + ((Book) r).getLanguage() + " ");
            }

            for (Copy c : r.getCopyManager().getListOfAllCopies()) {
                //each copy has a copyManager, don't understand why this is there/how to write this to file
                printWriter.print(c.getUniqueCopyID() + " " + c.getBorrowedBy().getId() + " " + c.getReservedFor().getId() + " "
                        + c.getLoanDurationInDays() + " " + c.getBorrowedOn() + " " + c.getDueDate());
                //not sure how to write the history to a file
            }
            printWriter.print("\n");
        }
        printWriter.close();
    }

    private void selfPopulate() throws IllegalArgumentException {
        File file = new File("Resources.txt");
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println ("Cannot open Resources.txt");
            System.exit (0);
        }
        while (in.hasNextLine()) {
            String subLine = in.nextLine();
            Scanner line = new Scanner(subLine);
            String uniqueID = line.next();
            String title = line.next();
            int year = line.nextInt();
            String thumbnailImagePath = line.next();
            String type = line.next();

            if (type.equals("DVD")) {
                String director = line.next();
                int runtime = line.nextInt();
                int listLength = line.nextInt();
                ArrayList<String> listOfSubtitleLanguages = new ArrayList<>();
                for (int i = 0; i<listLength;i++) {
                    listOfSubtitleLanguages.add(line.next());
                }
                DVD r = new DVD(uniqueID, title, year, thumbnailImagePath, director, runtime);
                r.setListOfSubtitleLanguages(listOfSubtitleLanguages);
            } else if (type.equals("Laptop")) {
                String manufacturer = line.next();
                String model = line.next();
                String installedOS = line.next();
                Laptop r = new Laptop(uniqueID, title, year, thumbnailImagePath, manufacturer, model, installedOS);
            } else if (type.equals("Book")) {
                String author = line.next();
                String publisher = line.next();
                String genre = line.next();
                String ISBN = line.next();
                String language = line.next();
                Book r = new Book(uniqueID, title, year, thumbnailImagePath, author, publisher, genre, ISBN, language);
            }

            ArrayList<Copy> copyManager = new ArrayList<>();
            while (!line.next().equals("\n")) {
                String uniqueCopyId = line.next();
                String borrowedBy = line.next();
                String reservedFor = line.next();
                int loanDurationInDays = line.nextInt();
                Date borrowedOn = new Date(in.nextLong());
                Date dueDate = new Date(in.nextLong());

                //history be sorted
                //copy needs to be made
            }
        }
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
        if(!user.hasAdminAccess()){
            return ((NormalUser) user).getBorrowedCopies();
        }
        return null;
     }

}
