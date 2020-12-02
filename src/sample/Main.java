package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    Stage stage =  new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        Scene scene = new Scene(root, 600,600);
        stage.setScene(scene);
        stage.show();

        Slider slider = new Slider(1,16, 3);
        slider.setMajorTickUnit(1);
        slider.setTranslateX(100);
        root.add(slider,2,1);
        

        Button buttonFileChooser = new Button("Browse from computer files");

        buttonFileChooser.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open File");
            File file = fileChooser.showOpenDialog(new Stage());
            if (file != null) {

                Image image = new Image("file:" + file.getAbsolutePath());
                ImageView imageView = new ImageView(image);
            root.add(imageView,2,4);

            }
        });

        root.add(buttonFileChooser,0,0);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
