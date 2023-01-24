module com.example.loginproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.loginproject to javafx.fxml;
    exports com.example.loginproject;
}