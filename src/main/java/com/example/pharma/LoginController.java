package com.example.pharma;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;
import java.util.Objects;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Button loginButton;
    @FXML

    private Label loginMessageLabel;

    @FXML

    private ImageView brandingImageView;

    @FXML

    TextField username;

    @FXML
    PasswordField passwordField;


    @Override

    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile = new File("@IMAGE/316040130_469666755256765_2266820998115937530_n.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
    }



    public void LoginButtonOnAction(ActionEvent event){
        if(username.getText().isBlank() == false && passwordField.getText().isBlank() == false){
            ValidateLogin();
        }
        else{
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    private void ValidateLogin() {
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM Users_accounts WHERE username='" + username.getText() +"'AND password ='" + passwordField.getText()+"'";

        try{

            Statement statement = connectDB.createStatement();
            ResultSet queryresult = statement.executeQuery((verifyLogin));
            while (queryresult.next()){
                if (queryresult.getInt(1)==1){
                    loginMessageLabel.setText("Conglatulations!");

                }else {
                    loginMessageLabel.setText("Invalid login. Please try again");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void CancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

   public void creatAccountForm(){
        try{
          FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("register.fxml"));
          Stage registerstage = new Stage();
          Scene scene = new Scene(fxmlLoader1.load(), 514, 581);
          registerstage.initStyle(StageStyle.UNDECORATED);
            registerstage.setScene(scene);
            registerstage.show();

        }catch(Exception e){
           e.printStackTrace();
           e.getCause();
        }

    }
    public void LoginButtonOnAction() throws IOException{
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homepage.fxml")));
        primaryStage.setTitle("HomePage interface");
        primaryStage.setScene(new Scene(root,320,240));
        primaryStage.show();







    }
}