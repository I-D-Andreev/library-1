import java.io.*;

/**
 * The sole purpose of this class is to store static variables as non-static ones in order to be saved easily.
 * @author Ivan Andreev
 */
public class SaveStaticVariables implements Serializable {
    private int userNextID;
    private int resourceNextID;
    private int copyNextID;

    public SaveStaticVariables(int userNextID, int resourceNextID, int copyNextID){
        this.userNextID = userNextID;
        this.resourceNextID = resourceNextID;
        this.copyNextID = copyNextID;
    }

    public SaveStaticVariables(){
        this.selfPopulate1();
    }


    public int getUserNextID() {
        return userNextID;
    }

    public void setUserNextID(int userNextID) {
        this.userNextID = userNextID;
    }

    public int getResourceNextID() {
        return resourceNextID;
    }

    public void setResourceNextID(int resourceNextID) {
        this.resourceNextID = resourceNextID;
    }

    public int getCopyNextID() {
        return copyNextID;
    }

    public void setCopyNextID(int copyNextID) {
        this.copyNextID = copyNextID;
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
            out.writeObject(this);

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
        System.out.println("Successfully written values to file.");
    }

    private void selfPopulate() {
        // Get a file to read from or create it if it doesn't exist.
        File file = this.fileToReadWrite();

        try {
            // file reader
            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            // read the object in the file
            SaveStaticVariables saveStaticVariables = (SaveStaticVariables) in.readObject();

            // close the reader
            in.close();
            fileIn.close();

            // assign the variable we just read
            this.resourceNextID = saveStaticVariables.getResourceNextID();
            this.userNextID = saveStaticVariables.getUserNextID();
            this.copyNextID = saveStaticVariables.getCopyNextID();

        } catch (IOException e) {
            System.out.println("Couldn't access file to read from.");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Problem in writing to file.");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Successfully read values from file.");

    }

    // Get a file to read/write or create it if it doesn't exist.
    private File fileToReadWrite() {
        File file = null;
        try {
            file = new File("src/resources/values.ser");
            file.createNewFile();
        } catch (Exception e) {
            System.out.println("Problem accessing file.");
            e.printStackTrace();
            System.exit(0);
        }
        return file;
    }

    // for testing purposes
    public void selfPopulate1(){
        this.resourceNextID = 4;
        this.userNextID  = 3;
        this.copyNextID = 4;
    }
}
