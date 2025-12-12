module com.example.bar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bar to javafx.fxml;
    exports com.example.bar;
}