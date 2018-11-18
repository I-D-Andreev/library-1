import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;

/**
 * Controller class for the Draw UI.  Handles button events and drawing event.
 *
 * @author Sian Pike
 */
public class DrawController {

    @FXML // fx:id="cancelButton"
    private Button cancelButton; // Value injected by FXMLLoader

    @FXML // fx:id="okayButton"
    private Button okayButton; // Value injected by FXMLLoader

    @FXML // fx:id="drawingCanvas"
    private Canvas drawingCanvas; // Value injected by FXMLLoader

}