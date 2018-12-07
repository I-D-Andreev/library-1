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
 * Class to model the drawing of an avatar for a profile.
 */
public class DrawAvatar extends Application {

    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 500;

    private static final int CANVAS_WIDTH = 400;
    private static final int CANVAS_HEIGHT = 400;
    private int counter = 0;

    private Pair<Double, Double> initialTouch;
    private Canvas layer;
    private Canvas trace;

    /**
     * Method to make a profile image.
     * @param primaryStage  The image to be made.
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
     * The size of the border where the image is inserted in.
     * @param gc The border of the image.
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
     * Allows you to choose a picture for your profile.
     * @param g
     * @param r
     * @param s
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

    /*public static void main(String[] args) {
        launch(args);
    }*/

}