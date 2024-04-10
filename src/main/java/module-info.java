module com.example.addressbook.tammy2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.addressbook.tammy2 to javafx.fxml;
    exports com.example.addressbook.tammy2;
}