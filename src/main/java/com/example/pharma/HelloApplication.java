package com.example.pharma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
       //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("stock.fxml"));
       FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("homepage.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 838, 635);
        Scene scene1 = new Scene(fxmlLoader1.load(), 700, 635);
        //stage.initStyle(StageStyle.UNDECORATED);
        //stage.setScene(scene);
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}