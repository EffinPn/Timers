package Items;

import javafx.animation.*;
import javafx.beans.property.*;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.io.*;

public class Timer {

	private Timeline time;
	private KeyFrame key;

	@FXML
	private GridPane pane = new GridPane();
	@FXML
	private Button playbtn;
	@FXML
	private Button stopbtn;
	@FXML
	private Button resetbtn;
	@FXML
	private Label tiempo;
	private long segundos;
	private long minutos;
	private long horas;
	StringProperty formato = new SimpleStringProperty("00:00:00");

	public Timer() {

		FXMLLoader root = new FXMLLoader(getClass().getResource("Tempos.fxml"));
		root.setController(this);

		try {
			pane = root.load();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

		segundos = 0;
		minutos = 0;
		horas = 0;

		key = new KeyFrame(Duration.seconds(1), event -> {
			segundos++;
			if (segundos > 59) {
				minutos++;
				segundos = 0;
			}
			if (minutos > 59) {
				horas++;
				minutos = 0;
			}
			formato.set(String.format("%02d:%02d:%02d", horas, minutos, segundos));
		});

		time = new Timeline(key);
		time.setCycleCount(Timeline.INDEFINITE);

		playbtn = new Button();
		stopbtn = new Button();
		resetbtn = new Button();
		tiempo = new Label();
		tiempo.textProperty().bind(formato);


	}

	public void start() {
		this.time.play();
	}

	public void pause() {
		this.time.pause();
	}

	public void reset() {
		this.time.stop();
		formato.set("00:00:00");
		this.segundos = 0;
		this.minutos = 0;
		this.horas = 0;

	}


	public GridPane getPane() {
		return pane;
	}

}
