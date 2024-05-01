module com.example.addressbook.tammy2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires junit;



    opens com.example.addressbook.tammy2 to javafx.fxml;
    opens com.example.addressbook.tammy2.ProgressTracking;
    opens com.example.addressbook.tammy2.ShopBackEnd;

    exports com.example.addressbook.tammy2;

    exports com.example.addressbook.tammy2.ProgressTracking;
    exports com.example.addressbook.tammy2.ShopBackEnd;
}