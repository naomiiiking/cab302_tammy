module com.example.addressbook.tammy2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.addressbook.tammy2 to javafx.fxml;
    opens com.example.addressbook.tammy2.AuthenLog;

    exports com.example.addressbook.tammy2;
    exports com.example.addressbook.tammy2.AuthenLog;
}