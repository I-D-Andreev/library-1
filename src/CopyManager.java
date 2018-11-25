import java.util.ArrayList;

public class CopyManager {

    ArrayList<User> requestQueue = new ArrayList<>();
    ArrayList<Copy> listOfAllCopies = new ArrayList<>();
    Resource copyManagerOf;

    public CopyManager(Resource copyManagerOf) {
        this.copyManagerOf = copyManagerOf;
    }

    public boolean isQueueEmpty() {
        return requestQueue.size() == 0;
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

    public int getNumOfAvailailableCopies() {
        return this.getListOfAvailableCopies().size();
    }

    public void addCopy(Copy copy) {
        this.listOfAllCopies.add(copy);
        this.newAvailableCopyEvent();
    }

    //Adds copy with its parameters, instead of copy object.
    public void addCopy(int loanDuration) {
        this.listOfAllCopies.add(new Copy(loanDuration, this.copyManagerOf));
        this.newAvailableCopyEvent();
    }

    public void removeCopy(Copy copy) {
        if(!copy.isAvailable()) {
            return; // error?
        }
        this.listOfAllCopies.remove(copy);
    }

    public void removeCopyById(Copy copy) {
        if(!copy.isAvailable()){
            return; // error?
        }

        for (int i = 0; i <= this.listOfAllCopies.size(); i++) {
            if (this.listOfAllCopies.get(i).getUniqueCopyID().equals(copy.getUniqueCopyID())) {
                this.listOfAllCopies.remove(i);
            }
        }
    }

    public boolean loanCopy(NormalUser toUser) {
        if (this.getNumOfAvailailableCopies() == 0) {
            return false;
        }
        // We look if there is a reserved copy for the User.
        for(Copy copy: listOfAllCopies){
            if(copy.getReservedFor().equals(toUser)){
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
