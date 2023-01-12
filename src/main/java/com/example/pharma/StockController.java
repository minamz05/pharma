package com.example.pharma;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import javax.swing.*;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

    public class StockController implements Initializable {
        @FXML
        private Button AddButton;
        @FXML
        private TableView<Meds> TableMed;

        @FXML
        private TableColumn<Meds, Integer> ColDCI;

        @FXML
        private TableColumn<Meds, Integer> ColDExpd;

        @FXML
        private TableColumn<Meds, Integer> ColDPerm;

        @FXML
        private TableColumn<Meds, String> ColName;

        @FXML
        private TableColumn<Meds, Integer> ColPrice;

        @FXML
        private TableColumn<Meds, Integer> ColQte;

        @FXML
        private TableColumn<Meds, Integer> ColRef;

        @FXML
        private Button DeleteButton;


        @FXML
        private Button UpdateButton;
        @FXML
        private TextField TextDCI;

        @FXML
        private TextField TextName;

        @FXML
        private TextField TextQte;
        @FXML
        private TextField TextDexpd;
        @FXML
        private TextField TextDPerm;

        @FXML
        private TextField TextPrice;

        @FXML
        private TextField TextRef;
        @FXML
        private TextField FilterField;
        ObservableList<Meds> list;
        ObservableList<Meds> DataList;



        public void UpdateMeds(){
            ColName.setCellValueFactory(new PropertyValueFactory<Meds,String>(TextName.getText()));
            ColRef.setCellValueFactory(new PropertyValueFactory<Meds,Integer>(TextRef.getText()));
            ColQte.setCellValueFactory(new PropertyValueFactory<Meds,Integer>(TextQte.getText()));
            ColDCI.setCellValueFactory(new PropertyValueFactory<Meds,Integer>(TextDCI.getText()));
            ColPrice.setCellValueFactory(new PropertyValueFactory<Meds,Integer>(TextPrice.getText()));
            ColPrice.setCellValueFactory(new PropertyValueFactory<Meds,Integer>(TextDexpd.getText()));
            ColPrice.setCellValueFactory(new PropertyValueFactory<Meds,Integer>(TextDPerm.getText()));

            TableMed.setItems( list);
        }
        public void DeleteMeds() {

            JOptionPane.showMessageDialog(null,"Delete");
            UpdateMeds();

        }
        // void SearchMeds() {
        //   ColName.setCellValueFactory(new PropertyValueFactory<Meds,String>("Name"));
        // ColRef.setCellValueFactory(new PropertyValueFactory<Meds,Integer>("Ref"));
        //  } else {
        //     return false;
        // });}


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            UpdateMeds();

        }

        public void AddMeds(javafx.event.ActionEvent actionEvent) {


            try{

                JOptionPane.showMessageDialog(null,"Meds add success");


            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
            UpdateMeds();
        }
    }




