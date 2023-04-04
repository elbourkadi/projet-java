module com.fstt.trackingli {
    requires javafx.controls;
    requires javafx.fxml;

requires mysql.connector.j;
requires java.sql;

    opens com.fstt.trackingli to javafx.fxml;
    exports com.fstt.trackingli;
    exports model;
    opens model to javafx.fxml;


}