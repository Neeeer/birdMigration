
package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    Controller controller;
    MediaView mediaView;

    public static void main(String[] args) {
        //System.setProperty("com.sun.javafx.touch", "true");
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        setStage(stage);
        controller.start();

    }

    public void setStage(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mainView.fxml"));

        String filename = "Tervapääsky.mp4";
        //Media media  = new Media("file:///C:/Users/nerst/Desktop/birdMigrationTest/Captures/" + filename);
        //Media media  = new Media("file:///home/pi/birdMigrationTest/Captures/" + filename);


        // Create the media view and add it to the scene
        MediaView mediaView = new MediaView();


// Add the MediaView to the scene's root Group
        Group root = new Group();
        root.getChildren().add(mediaView);

        try {
            Parent loadedParent = fxmlLoader.load();
            controller = fxmlLoader.getController();

            controller.setMediaView(mediaView);

            root.getChildren().add(loadedParent);
        } catch (IOException e) {
            e.printStackTrace();
        }




        stage.setTitle("Bird Migration");
        stage.initStyle(StageStyle.TRANSPARENT);


        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setResizable(false);

        Scene scene = new Scene(root, 1920, 1080);


        mediaView.setFitHeight(1080);
        mediaView.setFitWidth(1920);
        stage.setMinWidth(1920);
        stage.setMinHeight(1080);

        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("CSS/newStyleSheet.css")));
        stage.setScene(scene);
        stage.show();




    }


}