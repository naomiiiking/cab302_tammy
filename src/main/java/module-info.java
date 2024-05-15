module com.example.addressbook.tammy2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;




    opens com.example.addressbook.tammy2 to javafx.fxml;

    opens com.example.addressbook.tammy2.ProgressTracking;
    opens com.example.addressbook.tammy2.ShopBackEnd;  
    opens com.example.addressbook.tammy2.AuthenLog;

    opens Memorylogs to javafx.base; // Add this line
    exports Memorylogs;

    exports com.example.addressbook.tammy2.ProgressTracking;
    exports com.example.addressbook.tammy2.ShopBackEnd;
    exports com.example.addressbook.tammy2;
    exports com.example.addressbook.tammy2.AuthenLog;

}