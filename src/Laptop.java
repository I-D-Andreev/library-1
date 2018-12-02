/**
 * The Class Laptop.
 *
 * @author Steven Lekwowicz
 */
public class Laptop extends Resource {

    /**
     * The manufacturer of the laptop.
     */
    private String manufacturer;

    /**
     * The model of the laptop.
     */
    private String model;

    /**
     * The laptop's currently installed OS.
     */
    private String installedOS;

    /**
     * The late return fine per day for the laptop.
     */
    private final double lateReturnFinePerDay;

    /**
     * The maximum amount someone can be fined for late return of a laptop.
     */
    private final double maxFineAmount;

    /**
     * Creates a new laptop.
     *
     * @param uniqueID     The unique ID of the laptop
     * @param title        The title of the laptop
     * @param year         The year the laptop was made
     * @param thumbnail    The thumbnail of the laptop
     * @param manufacturer The laptop's manufacturer
     * @param model        The model number of the laptop
     * @param installedOS  The OS installed on the laptop
     */
    public Laptop(String uniqueID, String title, int year, String thumbnail, String manufacturer, String model, String installedOS) {
        super(uniqueID, title, year, thumbnail);
        this.manufacturer = manufacturer;
        this.model = model;
        this.installedOS = installedOS;
        this.lateReturnFinePerDay = 10.0;
        this.maxFineAmount = 100.0;
    }

    /**
     * Sets the laptop's new manufacturer.
     *
     * @param manufacturer The new manufacturer.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Gets the laptop's manufacturer.
     *
     * @return manufacturer The laptop's manufacturer.
     */
    public String getManufacturer() {
        return this.manufacturer;
    }

    /**
     * Sets the laptop's model.
     *
     * @param model The laptop's new model.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the laptop's model.
     *
     * @return model The laptop's model.
     */
    public String getModel() {
        return this.model;
    }

    /**
     * Sets the laptop's installed OS.
     *
     * @param installedOS The new OS installed on the laptop.
     */
    public void setInstalledOS(String installedOS) {
        this.installedOS = installedOS;
    }

    /**
     * Gets the laptop's installed OS.
     *
     * @return installedOS The OS installed on the laptop.
     */
    public String getInstalledOS() {
        return this.installedOS;
    }

    /**
     * Gets the fine per day for a late return.
     *
     * @return lateReturnFinePerDay The fine per day for a late return.
     */
    public double getLateReturnFinePerDay() {
        return this.lateReturnFinePerDay;
    }

    /**
     * Gets the maximum fine amount.
     *
     * @return maxFineAmount The maximum amount someone can be fined.
     */
    public double getMaxFineAmount() {
        return this.maxFineAmount;
    }

    public String getType() {
        return "Laptop";
    }

}
