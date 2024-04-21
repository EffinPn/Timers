module TimersA {
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.base;
	requires javafx.fxml;

    opens App to javafx.fxml;
    opens Items to javafx.fxml;
	
	exports App;
}