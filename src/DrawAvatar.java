import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 * A drawing class that allows the user to make their own avatar
 * Uses straight line and free drawing
 *
 * @author Christina Meggs, Steven Lewkowicz,
 */

public class DrawAvatar extends Application {

    /**
     * The set window width for the window that appears
     */
    private static final int WINDOW_WIDTH = 600;

    /**
     * The set window height for the window that appears
     */
    private static final int WINDOW_HEIGHT = 500;

    /**
     * The set canvas height for the area the user can draw in
     */
    private static final int CANVAS_WIDTH = 400;

    /**
     * The set canvas weight for the area the user can draw in
     */
    private static final int CANVAS_HEIGHT = 400;

    /**
     * Counter used to track what layer nextg canvas should be made on
     */
    private int counter = 0;

    /**
     * Used to detect users inital click
     */
    private Pair<Double, Double> initialTouch;

    /**
     * Current canvas to use for drawing a line
     */
    private Canvas layer;

    /**
     * Current canvas to use to trace a line
     */
    private Canvas trace;

    /**
     * Starts the whole drawing system.
     * @param primaryStage the window the application will appear in
     */
    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        FlowPane grid = new FlowPane();
        root.getChildren().add(grid);

        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        ColorPicker cp = new ColorPicker();
        cp.setValue(Color.BLACK);
        Slider slider = new Slider();
        Label label = new Label("1.0");

        slider.setMax(100);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.valueProperty().addListener(e->{
            double value = slider.getValue();
            String str = String.format("%.0f", value);
            label.setText(str);
            gc.setLineWidth(value);
        });


        RadioButton lineButton = new RadioButton("Line");
        RadioButton traceButton = new RadioButton("Trace");
        ToggleGroup toggleGroup = new ToggleGroup();

        lineButton.setToggleGroup(toggleGroup);
        traceButton.setToggleGroup(toggleGroup);

        borderRect(gc);
        toggleGroup.selectToggle(lineButton);
        makeLine(canvas, root, cp, slider);
        toggleGroup.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
            if(newVal == lineButton) {
                makeLine(canvas, root, cp, slider);
            } else if (newVal == traceButton) {
                makeTrace(canvas, root, cp, slider);
            }
            borderRect(gc);
        });

        Button clearButton = new Button();
        clearButton.setText("Clear");
        clearButton.setOnAction(e->{clear(root,grid, canvas);});

        Button saveButton = new Button();
        saveButton.setText("Save");
        saveButton.setOnAction(e->	 {
            captureAndSaveDisplay(grid,root,primaryStage);
//
//            // here we make image from vbox and add it to scene, can be repeated :)
//            WritableImage snapshot = grid.snapshot(new SnapshotParameters(), null);
//
//            grid.getChildren().add(new ImageView(snapshot));
//            System.out.println(grid.getChildren().size());
//
        });



        grid.getChildren().addAll(cp, lineButton, traceButton, slider, saveButton, clearButton);

        root.getChildren().addAll(canvas);
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Clears the whole canvas for the user to start fresh
     * @param root the Stackpane which contains all nodes on screen
     * @param g the FlowPane which the all the buttons etc appear on
     * @param c the canvas we want to remain after it is cleared
     */
    private void clear(StackPane root, FlowPane g, Canvas c) {
        counter = 0;
        layer = new Canvas();
        trace = new Canvas();

        ArrayList<Node> list = new ArrayList<>();

        list.addAll(root.getChildren());
        list.remove(g);
        list.remove(c);

        root.getChildren().removeAll(list);
    }

    /**
     * Add a border to the canvas
     * @param gc the current GraphicContents the canvas is working on
     */
    public void borderRect(GraphicsContext gc) {
        gc.setLineWidth(8);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(
                0,              //x of the upper left corner
                0,              //y of the upper left corner
                CANVAS_WIDTH,    //width of the rectangle
                CANVAS_HEIGHT);  //height of the rectangle
    }

    /**
     * Allows the user to trace a line (free draw)
     * @param c  the current canvas the user is drawing on
     * @param r the StackPane the contains all the nodes, used to add new canvas to
     * @param cp the ColorPicker to allow the line to change colour
     * @param s the Slider to allow the line to change width
     */
    private void makeTrace(Canvas c,StackPane r, ColorPicker cp, Slider s) {
        c.setOnMousePressed(e->{
            Canvas newTrace = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
            trace = newTrace;
            r.getChildren().add(counter,newTrace);
            counter++;
            GraphicsContext gc = trace.getGraphicsContext2D();
            gc.beginPath();
            gc.lineTo(e.getX(), e.getY());
            gc.stroke();
            borderRect(gc);
        });
        c.setOnMouseDragged(e->{
            GraphicsContext gc = trace.getGraphicsContext2D();
            gc.setStroke(cp.getValue());
            gc.setLineWidth(s.getValue());
            gc.lineTo(e.getX(), e.getY());
            gc.stroke();
            borderRect(gc);
        });
        c.toFront();
    }

    /**
     * Allows the user to draw a line
     * @param c the current canvas the user is drawing on
     * @param r the StackPane the contains all the nodes, used to add new canvas to
     * @param cp the ColorPicker to allow the line to change colour
     * @param s the Slider to allow the line to change width
     */
    private void makeLine(Canvas c, StackPane r, ColorPicker cp, Slider s) {
        c.setOnMousePressed(e->{
            Canvas newLayer = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
            layer = newLayer;
            r.getChildren().add(counter,newLayer);
            counter++;
            initialTouch = new Pair<>(e.getX(), e.getY());
        });

        c.setOnMouseDragged(e->{
            GraphicsContext context = layer.getGraphicsContext2D();
            context.clearRect(0, 0, layer.getWidth(), layer.getHeight());
            context.setStroke(cp.getValue());
            context.setLineWidth(s.getValue());
            context.strokeLine(initialTouch.getKey(), initialTouch.getValue(), e.getX(), e.getY());
        });

    }

    /**
     * Used to save the avatars (canvas's) that user has just drawn
     * @param g the FlowPane that contains all buttons etc at the top
     * @param r the StackPane the contains all of the nodes
     * @param s the Stage the class is working in
     */
    public void captureAndSaveDisplay(FlowPane g,StackPane r, Stage s){
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)", "*.png"));

        //Prompt user to select a file
        File file = fileChooser.showSaveDialog(null);

        if(file != null){
            try {
                //Pad the capture area
                ArrayList<Node> list = new ArrayList<>();
                list.addAll(r.getChildren());
                list.remove(g);

                Group group = new Group();
                group.getChildren().addAll(list);


                WritableImage writableImage = new WritableImage(CANVAS_WIDTH, CANVAS_HEIGHT);
                group.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                //Write the snapshot to the chosen file
                ImageIO.write(renderedImage, "png", file);

                group.getChildren().removeAll(r.getChildren());

                r.getChildren().addAll(list);

            } catch (IOException ex) { ex.printStackTrace(); }
        }
    }


}