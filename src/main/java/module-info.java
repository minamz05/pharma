module com.example.pharma {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires  java.desktop;

    opens com.example.pharma to javafx.fxml;
    exports com.example.pharma;
}