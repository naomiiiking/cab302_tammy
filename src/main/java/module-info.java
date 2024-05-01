module com.example.addressbook.tammy2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    requires org.junit.jupiter.api;


    opens com.example.addressbook.tammy2 to javafx.fxml;
    opens com.example.addressbook.tammy2.AuthenLog;

    exports com.example.addressbook.tammy2;
    exports com.example.addressbook.tammy2.AuthenLog;
}