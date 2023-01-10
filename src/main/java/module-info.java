module com.example.simonsjavafxgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.simonsjavafxgame to javafx.fxml;
    exports com.example.simonsjavafxgame;
}