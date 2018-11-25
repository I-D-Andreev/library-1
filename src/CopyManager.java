import java.util.ArrayList;

public class CopyManager {

    ArrayList<User> requestQueue = new ArrayList<>();
    ArrayList<Copy> listOfAllCopies = new ArrayList<>();

    //asldkaslkdaslkdaslkdalskdlkdalk
    //todo initialiser
    CopyManager() {

    }

    public boolean isQueueEmpty() {
        return false;
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

    /*
    //todo need date
    public void setDueDateOfOldestBorrowedCopy(){
        Date x; //Used as counter
        for (int i; i<=this.listOfAllCopies.size();i++)
        if (this.listOfAllCopies.get(i).getBorrowedOn())
    }
*/
    public boolean isUserInQueue(User user) {
        boolean x = false;
        for (int i = 0; i <= this.requestQueue.size(); i++) {
            if (this.requestQueue.get(i).getId() == user.getId()) {
                x = true;
            } else
                x = false;
        }
        return x;
    }

    public ArrayList<Copy> getListOfAllCopies() {
        return this.listOfAllCopies;
    }

    public int getNumOfAvailailableCopies() {
        int x = 0;
        for (int i = 0; i <= this.listOfAllCopies.size(); i++) {
            x = i;
        }
        return x;
    }

    public void addCopy(Copy copy) {
        this.listOfAllCopies.add(copy);
    }

    // dont get what this method is supposed to do
    /*
    public void addCopy(int loanDuration, Resource copyOf){
        this.listOfAllCopies.add());
    }
    */
    public void removeCopy(Copy copy) {
        for (int i = 0; i <= this.listOfAllCopies.size(); i++) {
            if (this.listOfAllCopies.get(i).equals(copy)) {
                this.listOfAllCopies.remove(i);
            }
        }
    }

    public void removeCopyById(Copy copy) {
        for (int i = 0; i <= this.listOfAllCopies.size(); i++) {
            if (this.listOfAllCopies.get(i).getUniqueCopyID().equals(copy.getUniqueCopyID())) {
                this.listOfAllCopies.remove(i);
            }
        }
    }

    public void reserveCopy(User user) {
        for (int i = 0; i <= this.listOfAllCopies.size(); i++) {
            if (this.listOfAllCopies.get(i).isAvailable() == true) {
                this.listOfAllCopies.get(i).setReservedFor(user);
                break;
            } else
                addUserToTheQueue(user);
        }
    }

    //is this right?
    public boolean loanCopy(User user) {
        boolean x = false;
        for (int i = 0; i <= this.listOfAllCopies.size(); i++) {
            if (this.listOfAllCopies.get(i).getReservedFor() == user) {
                x = true;
            } else
                x = false;
        }
        return x;
    }
}
