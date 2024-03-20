module org.example.javarpg {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javarpg to javafx.fxml;
    exports org.example.javarpg;
}