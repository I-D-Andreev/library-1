
/**
 * The Class Laptop.
 * 
 * @author Steven Lekwowicz
 */
public class Laptop extends Resource{
	private String manufacturer;
	private String model;
	private String installedOS;
	private double lateReturnFinePerDay;
	private double maxFineAmount;
	
	/**
	 * Creates a new laptop.
	 *
	 * @param uniqueID The unique ID of the laptop
	 * @param title The title of the laptop
	 * @param year The year the laptop was made
	 * @param thumbnail The thumbnail of the laptop
	 * @param manufacturer The laptop's manufacturer
	 * @param model The model number of the laptop
	 * @param installedOS The OS installed on the laptop
	 */
	public Laptop(String uniqueID, String title, int year, String thumbnail, String manufacturer, String model, String installedOS) {
		super(uniqueID, title, year, thumbnail);
		this.manufacturer = manufacturer;
		this.model = model;
		this.installedOS = installedOS;
		this.lateReturnFinePerDay = 10.00;
		this.maxFineAmount = 100.00;
	}
}
