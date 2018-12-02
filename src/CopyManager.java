import java.util.ArrayList;

public class CopyManager {

    private ArrayList<User> requestQueue;
    private ArrayList<Copy> listOfAllCopies;
    private Resource copyManagerOf;

    public CopyManager(Resource copyManagerOf) {
        this.copyManagerOf = copyManagerOf;
        requestQueue = new ArrayList<>();
        listOfAllCopies = new ArrayList<>();
    }

    public Resource getCopyManagerOf() {
        return copyManagerOf;
    }

    public boolean isQueueEmpty() {
        return requestQueue.size() == 0;
    }

    public boolean requestQueueContains(User user) {
        return (requestQueue.indexOf(user) != -1);
    }

    public User getFirstUserInQueue() {
        return this.requestQueue.get(0);
    }

    public void removeFirstUserInQueue() {
        this.requestQueue.remove(0);
    }

    public void addUserToTheQueue(User user) {
        this.requestQueue.add(user);
    }

    public boolean isUserInQueue(User user) {
        return requestQueue.indexOf(user) != -1;
    }

    public ArrayList<Copy> getListOfAllCopies() {
        return this.listOfAllCopies;
    }

    public ArrayList<Copy> getListOfAvailableCopies() {
        ArrayList<Copy> availableCopies = new ArrayList<>();

        for (int i = 0; i < listOfAllCopies.size(); i++) {
            if (listOfAllCopies.get(i).isAvailable()) {
                availableCopies.add(listOfAllCopies.get(i));
            }
        }
        return availableCopies;
    }

    public int getNumOfAvailableCopies() {
        return this.getListOfAvailableCopies().size();
    }

    public void addCopy(Copy copy) {
        this.listOfAllCopies.add(copy);
        this.newAvailableCopyEvent();
    }

    //Adds copy with its parameters, instead of copy object.
    public void addCopy(int loanDuration) {
        this.listOfAllCopies.add(new Copy(loanDuration, this));
        this.newAvailableCopyEvent();
    }

    public void removeCopy(Copy copy) {
        if (!copy.isAvailable()) {
            return; // error?
        }
        this.listOfAllCopies.remove(copy);
    }

    public Copy findCopyById(String copyId){
        Copy returnCopy=null;
        for(Copy copy: listOfAllCopies){
            if(copy.getUniqueCopyID().equals(copyId)){
                returnCopy = copy;
            }
        }
        return returnCopy;
    }

    public void removeCopyById(String copyId) {
        if (this.findCopyById(copyId) == null) {
            return; // error?
        }
        this.listOfAllCopies.remove(this.findCopyById(copyId));
    }

    public boolean loanCopy(NormalUser toUser) {
        if (this.getNumOfAvailableCopies() == 0) {
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


    public void reserveCopy(NormalUser forUser) {
        if (!loanCopy(forUser)) {
            this.requestQueue.add(forUser);
            this.setDueDateOfOldestBorrowedCopy();
        }
    }

    // Find the oldest borrowed copy with no due date set
    // and set its due date.
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


    // Called when a copy is returned.
    // Decides what to do with said copy.
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
