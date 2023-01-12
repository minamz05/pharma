package com.example.pharma;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;


import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class SellsController  implements Initializable {


    @FXML
    private TableColumn<SellsTableClass, String> DATEcolumn;

    @FXML
    private Text NEWtext;

    @FXML
    private TableColumn<SellsTableClass, String> Pricecolumn;

    @FXML
    private TextField QTE;

    @FXML
    private TableColumn<SellsTableClass, Integer> QTEcolumn;

    @FXML
    private TableColumn<SellsTableClass, String> REFcolumn;

    @FXML
    private TextField date;

    @FXML
    private TableColumn<SellsTableClass,Integer > idcolumn;

    @FXML
    private TextField medicationREF;

    @FXML
    private TextField medicationid;

    @FXML
    private TextField medprice;

    @FXML
    private Text recentsellsText;
    @FXML
    private Button sellbutton;
    @FXML
    private TableView<SellsTableClass> sellsTableView ;


    public void NewSell (ActionEvent Event) {
        idcolumn.setText(String.valueOf(medicationid));
        REFcolumn.setText(String.valueOf(medicationREF));
        DATEcolumn.setText(String.valueOf(date));
        Pricecolumn.setText(String.valueOf(medprice));
        QTEcolumn.setText(String.valueOf(QTE));
        addsell();
    }
     public void addsell(){
           DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();

            String id_med = medicationid.getText();
            String reference = medicationREF.getText();
           String date_sell = date.getText();
            String Qte = QTE.getText();
            String price = medprice.getText();


            String insertFields = " INSERT INTO med_vendu(  reference, id_med,  date_sell, Qte, price) VALUES ('";
           String insertValues = reference + "','" + id_med + "','" + date_sell+ "','" + Qte +"','" +price+  "')";
            String insertToRegister = insertFields + insertValues;

            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertToRegister);


           } catch (Exception e) {
               e.printStackTrace();
              e.getCause();
           }

        }




       @Override
        public void initialize (URL url, ResourceBundle resourceBundle){
            idcolumn.setCellValueFactory(new PropertyValueFactory<>("Purchase ID"));
             REFcolumn.setCellValueFactory(new PropertyValueFactory<>("REF"));
              DATEcolumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
            QTEcolumn.setCellValueFactory(new PropertyValueFactory<>("QTE"));
             Pricecolumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
            // List = (ObservableList<SellsTableClass>) DatabaseConnection.getConnection();
            //sellsTableView.setItems(List);
        }
}


