import java.util.ArrayList;

/**
 * Class to model the copy manager
 * @author Kleanthis Liontis, An
 */
public class CopyManager {

    /**
     * An ArrayList containing every User requesting a copy.
     */
    private ArrayList<User> requestQueue;

    /**
     * An ArrayList containing all the copies.
     */
    private ArrayList<Copy> listOfAllCopies;

    /**
     * The resource this is a copy manager of.
     */
    private Resource copyManagerOf;

    /**
     * The constructor of a copy manager.
     * @param copyManagerOf The resource this is a copy manager of.
     */
    public CopyManager(Resource copyManagerOf) {
        this.copyManagerOf = copyManagerOf;
        requestQueue = new ArrayList<>();
        listOfAllCopies = new ArrayList<>();
    }

    /**
     * Gets the resource this is a copy manager of.
     * @return copyManagerOf The resource this is a copy manager of.
     */
    public Resource getCopyManagerOf() {
        return copyManagerOf;
    }

    /**
     * Checks if the request queue is empty.
     * @return true if the request queue is empty,false otherwise.
     */
    public boolean isQueueEmpty() {
        return requestQueue.size() == 0;
    }

    /**
     * Checks if the request queue contains a specific user.
     * @param user The user the method checks for.
     * @return true if the user is in the queue, false otherwise.
     */
    public boolean requestQueueContains(User user) {
        return (requestQueue.indexOf(user) != -1);
    }

    /**
     * Gets the first user in the request queue.
     * @return User returns the first user in the request queue.
     */
    public User getFirstUserInQueue() {
        return this.requestQueue.get(0);
    }

    /**
     * Removes the first user in the request queue.
     */
    public void removeFirstUserInQueue() {
        this.requestQueue.remove(0);
    }

    /**
     * Adds a user to the request queue.
     * @param user The user to be added in the request queue.
     */
    public void addUserToTheQueue(User user) {
        this.requestQueue.add(user);
    }

    /**
     * Checks if a specific user is in the queue.
     * @param user The user to check if is in the queue.
     * @return true if the user is in the queue,false otherwise.
     */
    public boolean isUserInQueue(User user) {
        return requestQueue.indexOf(user) != -1;
    }

    /**
     * Gets the list of all copies available or not.
     * @return listOfAllCopies The list of all copies.
     */
    public ArrayList<Copy> getListOfAllCopies() {
        return this.listOfAllCopies;
    }

    /**
     * Gets the list of all the available copies.
     * @return availableCopies The list of available copies.
     */
    public ArrayList<Copy> getListOfAvailableCopies() {
        ArrayList<Copy> availableCopies = new ArrayList<>();

        for (int i = 0; i < listOfAllCopies.size(); i++) {
            if (listOfAllCopies.get(i).isAvailable()) {
                availableCopies.add(listOfAllCopies.get(i));
            }
        }
        return availableCopies;
    }

    /**
     * Gets the number of available copies.
     * @return int The number of available copies.
     */
    public int getNumOfAvailailableCopies() {
        return this.getListOfAvailableCopies().size();
    }

    /**
     * Adds a copy in the list of all copies.
     * @param copy the copy to be added in the list of all copies.
     */
    public void addCopy(Copy copy) {
        this.listOfAllCopies.add(copy);
        this.newAvailableCopyEvent();
    }

    /**
     * Adds a copy in the list of all copies.
     * @param loanDuration Adds copy with its parameters, instead of copy object.
     */
    public void addCopy(int loanDuration) {
        this.listOfAllCopies.add(new Copy(loanDuration, this));
        this.newAvailableCopyEvent();
    }

    /**
     * Removes a copy from the list of all copies.
     * @param copy The copy to be removed.
     */
    public void removeCopy(Copy copy) {
        if (!copy.isAvailable()) {
            return; // error?
        }
        this.listOfAllCopies.remove(copy);
    }

    /**
     * Gets a copy from the list of all copies.
     * @param copyId The id of the copy to be found.
     * @return copy The copy whose ID matches the ID given.
     */
    public Copy findCopyById(String copyId){
        Copy returnCopy=null;
        for(Copy copy: listOfAllCopies){
            if(copy.getUniqueCopyID().equals(copyId)){
                returnCopy = copy;
            }
        }
        return returnCopy;
    }

    /**
     * Removes a copy from the list of all copies.
     * @param copyId The ID of the copy to be removed.
     */
    public void removeCopyById(String copyId) {
        if (this.findCopyById(copyId) == null) {
            return; // error?
        }
        this.listOfAllCopies.remove(this.findCopyById(copyId));
    }

    /**
     * Loans a copy to a user.
     * @param toUser The user who will loan the copy.
     * @return true if the user has reserved a copy,false otherwise.
     */
    public boolean loanCopy(NormalUser toUser) {
        if (this.getNumOfAvailailableCopies() == 0) {
            return false;
        }
        // We look if there is a reserved copy for the User.
        for (Copy copy : listOfAllCopies) {
            if (copy.getReservedFor().equals(toUser)) {
                copy.loanCopyTo(toUser);
                return true;
            }
        }

        // We loan the first available copy.
        this.getListOfAvailableCopies().get(0).loanCopyTo(toUser);
        return true;
    }

    /**
     * Reserves a copy for a user
     * @param forUser The user who will reserve a copy.
     */
    public void reserveCopy(NormalUser forUser) {
        if (!loanCopy(forUser)) {
            this.requestQueue.add(forUser);
            this.setDueDateOfOldestBorrowedCopy();
        }
    }

    /**
     * Find the oldest borrowed copy with no due date
     * and set its due date.
     */
    private void setDueDateOfOldestBorrowedCopy() {
        // ** There is the possibility that all copies' due dates are already set.
        Copy oldestCopy = null;
        for (Copy copy : listOfAllCopies) {
            if (oldestCopy == null && copy.getDueDate() != null && copy.getBorrowedOn() != null) {
                oldestCopy = copy;
            } else if (oldestCopy != null && copy.getBorrowedOn() != null) {
                // if copy is older than the oldest copy
                if (copy.getBorrowedOn().compareTo(oldestCopy.getBorrowedOn()) == -1) {
                    oldestCopy = copy;
                }
            }
        }

        if (oldestCopy != null) {
            oldestCopy.setDueDate();
        }
    }


    /**
     * Called when a copy is returned.
     * decides what to do with said copy.
     */
    public void newAvailableCopyEvent() {
        ArrayList<Copy> availableCopies = this.getListOfAvailableCopies();
        int numberOfCopies = availableCopies.size();
        int numberOfUsers = requestQueue.size();

        // Reserve as many available copies as possible.
        for (int i = 0; i < Math.min(numberOfUsers, numberOfCopies); i++) {
            // Reserve a copy for the first user in the request queue.
            availableCopies.get(i).setReservedFor(requestQueue.get(0));
            this.removeFirstUserInQueue();
        }
    }
}
