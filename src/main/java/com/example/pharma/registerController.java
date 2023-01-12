package com.example.pharma;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;


public class registerController implements Initializable {


    @FXML
    private Button closeButton;

    @FXML
    private Label registractionmessageLabel;

    @FXML
    private PasswordField setPasswordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label confirmPasswordLabel;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private TextField usernameTextField;

    @FXML

    private ImageView shieldImageView;


    @Override
public void initialize(URL url, ResourceBundle resourceBundle){
        File shieldFile = new File("@IMAGE/images.jpg");
    Image shieldImage = new Image(shieldFile.toURI().toString());
    shieldImageView.setImage(shieldImage);
}



    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();

    }

    public void registerButtonOnAction(ActionEvent event) {

        if (setPasswordField.getText().equals(confirmPasswordField.getText())) {
            registerUser();
            confirmPasswordLabel.setText("");

        } else {
            confirmPasswordLabel.setText("Password does not match");
        }


    }



    public void registerUser() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

            String firstname = firstnameTextField.getText();
            String lastname = lastnameTextField.getText();
            String username = usernameTextField.getText();
            String password = setPasswordField.getText();

            String insertFields = " INSERT INTO users_accounts(  lastname, firstname,  username, password) VALUES ('";
            String insertValues = firstname + "','" + lastname + "','" + username + "','" + password + "')";
            String insertToRegister = insertFields + insertValues;

            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister);

                registractionmessageLabel.setText("user has been registred successfully!");

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }

        }
}




