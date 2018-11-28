import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * The Class ResourceManager.
 *
 * @author Steven Lewkowicz, Christina Meggs
 */

public class ResourceManager {

    private ArrayList<Resource> resources = new ArrayList<>();

    public ResourceManager() {
        selfPopulate();
    }

    public void save() {

    }

    private void selfPopulate() {

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
