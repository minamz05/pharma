package com.example.pharma;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.sql.*;

public class MedDB {
    static Connection connection = DatabaseConnection.getConnection();
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;

    public static ObservableList<Meds> getMedicament(){
        ObservableList<Meds> medicament = FXCollections.observableArrayList();

        String query = "select * from stock";
        try {
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int Med_Id = resultSet.getInt("reference");
                int QTE = resultSet.getInt("QTE");
                int DCI = resultSet.getInt("DCI");
                int price = resultSet.getInt("price");
                String Name = resultSet.getString("Name");
                String date_expd = resultSet.getString("date_expd");
                String date_perm = resultSet.getString("date_perm");
                Meds Med = new Meds(Med_Id, DCI,Name ,price ,QTE,  date_expd, date_perm);
                medicament.add(Med);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return medicament;
    }

    public static void AddMeds(String MedNameTextField, String MedCategoryTextField  ,String MedDateTextField, String MedEndDateTextField, Integer MedQuantityTextField, Integer MedPriceTextField){
        String query = "INSERT INTO `stock`(`reference`, `DCI`, `name`, `price`, `QTE`, `date_expd`, `date_perm`) VALUES(?, ?, ?, ?, ?, ?)";

        try {
            statement = connection.prepareStatement(query);
            statement.setString(2, MedNameTextField);
            statement.setString(5, MedCategoryTextField);
            statement.setString(3, MedDateTextField);
            statement.setString(4, MedEndDateTextField);
            statement.setInt(1, MedQuantityTextField);
            statement.setInt(6, MedPriceTextField);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public static void updateMedicament(int Med_ID, String MedNameTextField,  String MedDateTextField, String MedEndDateTextField,
                                        Integer MedQuantityTextField, Integer MedPriceTextField){

        String query = "update stock set QTE= ?, Name = ?, date_expd = ?, date_perm = ?, price= ? where reference = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(2, MedNameTextField);
            statement.setString(3, MedDateTextField);
            statement.setString(4, MedEndDateTextField);
            statement.setInt(1, MedQuantityTextField);
            statement.setInt(6, MedPriceTextField);
            statement.setInt(7, Med_ID);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void RemoveMedicament(int Med_Id){
        String query = "delete from stock where reference = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, Med_Id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}

