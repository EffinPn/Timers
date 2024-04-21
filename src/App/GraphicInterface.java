package App;

import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import Items.Timer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.fxml.*;

public class GraphicInterface extends Application {

	@FXML
	private Button btnanadir;
	@FXML
	AnchorPane anchor = new AnchorPane();
	@FXML
	private ScrollPane scrllPane = new ScrollPane();
	@FXML
	private GridPane grdpane = new GridPane();
	private int row;

	public static void main(String[] args) {

		launch(GraphicInterface.class);

	}

	public void start(Stage window) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

		anchor.getChildren().add(root);
		
		scrllPane.setContent(anchor); // Aquí 'root' es tu AnchorPane

		Scene scene = new Scene(scrllPane);

		window.setScene(scene);
		window.show();
		
		

	}

	@FXML
	public void anadir() {

		grdpane.add(new Timer().getPane(), 0, row);
		row++;

	}

}
