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
		resources.add(resource);
	}
	
	public void addCopyOfResource(int loanDuration, Resource resource) {
		
	}
	
	public void removeResource(Resource resource) {
		resources.remove(resource);
	}
	
	public void removeResource(String resourceId) {
		int index = -1;
		for (int i = 0;i<resources.size();i++) {
			if (resources.get(i).getUniqueID().equals(resourceId)) {
				index = i;
			}
		}
		if(index != -1) {
			resources.remove(index);
		}
	}
	
	public void removeCopy(Copy copy) {

	}
	
	public void removeCopy(String copyId) {
		
	}
	
	public void editResource(Resource resource, Resource newResource) {
		
	}
	
	public Resource getResourceById(String resourceId) {
		return null;
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
	
	public ArrayList<Resource> getAllResources() {
		return null;
	
	}
	
	public ArrayList<Copy> getAllCopies() {
		return null;
	}
	
	public ArrayList<Copy> getBorriedCopiesBy(User user) {
		return null;
	}
	
	public ArrayList<Resource> getRequestedResourcesBy(User user) {
		return null;
	}
	
	public ArrayList<Copy> getReservedCopiesFor(User user) {
		return null;
	}
	
	public ArrayList<Copy> getOverdueCopies() {
		return null;
	}
	
	
}
