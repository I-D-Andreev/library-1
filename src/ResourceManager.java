import java.util.ArrayList;

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
        Resource r = null;
        for (Resource resource : resources) {
            if (resource.getUniqueID().equals(resourceId)) {
                r = resource;
            }
        }
        return r;
    }

    public ArrayList<Resource> getAllResources() {
        return resources;

    }

    public ArrayList<Resource> getRequestedResourcesBy(User user) {
        ArrayList<Resource> requestedResource = new ArrayList<>();
        for (Resource resource : resources) {
            if(resource.getCopyManager().requestQueueContains(user)){
                requestedResource.add(resource);
            }
        }
        return requestedResource;
    }

    /**
     * these not in copy manager instead of resource manager?
     public void removeCopy(Copy copy) {
     }

     public void removeCopy(String copyId) {
     }

     public Copy getCopyById(String copyId) {
     return null;
     }

     public void loanCopy(Resource reource, User toUser) {

     }

     public void reserveCopy(Resource resource, User forUser) {

     }

     public void returnCopy(Copy copy, User user) {

     }

     public ArrayList<Copy> getAllCopies() {
     return null;
     }

     public ArrayList<Copy> getReservedCopiesFor(User user) {
     return null;
     }

     public ArrayList<Copy> getOverdueCopies() {
     return null;
     }

     public ArrayList<Copy> getBorriedCopiesBy(User user) {
     return null;
     }
     **/

}
