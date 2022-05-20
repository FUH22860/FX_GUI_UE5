package application;

import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class RootBorderPane extends BorderPane {
	
	private MenuBar menuBar;
	private Menu mDatei, mBearbeiten;
	private MenuItem miBeenden, miReset;
	
	private GridPane gpZentrum;
	
	private RadioButton rbDirekt, rbLeerzeichen, rbLeerzeile;
	
	private ToggleGroup tgRadios;
	
	private TextField tfText1, tfText2;
	private TextArea taErgebnis;
	
	private Button btVerbinden;
	
	private Label lbErgebnis;
	
	public RootBorderPane() {
		initComponents();
		addComponents();
		addHandler();
	}

	private void initComponents() {
		String promptText = "Bitte einen Text eingeben...";
		
		menuBar = new MenuBar();
		mDatei = new Menu("Datei");
		mBearbeiten = new Menu("Bearbeiten");
		miBeenden = new MenuItem("Beenden");
		miReset = new MenuItem("Reset");
		
		gpZentrum = new GridPane();
			gpZentrum.setAlignment(Pos.CENTER);
			gpZentrum.setHgap(10);
			gpZentrum.setVgap(10);
			gpZentrum.setPadding(new Insets(10));
		
		tfText1 = new TextField();
			tfText1.setPromptText(promptText);
		
		tfText2 = new TextField();
			tfText2.setPromptText(promptText);
		
		taErgebnis = new TextArea();
			taErgebnis.setDisable(true);
			taErgebnis.setEditable(false);
			
		rbDirekt = new RadioButton("Direkt: ");
		rbLeerzeichen = new RadioButton("Leerzeichen: ");
		rbLeerzeile = new RadioButton("Leerzeile: ");
		
		btVerbinden = new Button("Verbinden");
		
		tgRadios = new ToggleGroup();
		
		lbErgebnis = new Label("Ergebnis");
	}
	
	private void addComponents() {
		mDatei.getItems().addAll(miBeenden);
		mBearbeiten.getItems().addAll(miReset);
		menuBar.getMenus().addAll(mDatei, mBearbeiten);
		
		gpZentrum.add(new Label("Verbinden"), 	0, 0);
		gpZentrum.add(new Label("Text 1"), 		0, 3);
		gpZentrum.add(new Label("Text 2"), 		0, 4);
//		gpZentrum.add(new Label("Ergebnis:"), 	0, 5);
		gpZentrum.add(lbErgebnis, 0, 5);
			GridPane.setValignment(lbErgebnis, VPos.TOP);
		
		gpZentrum.add(rbDirekt, 		1, 0);
		gpZentrum.add(rbLeerzeichen, 	1, 1);
		gpZentrum.add(rbLeerzeile, 		1, 2);
		
		gpZentrum.add(tfText1, 		1, 3);
		gpZentrum.add(tfText2, 		1, 4);
		gpZentrum.add(taErgebnis, 	1, 5);
		
		gpZentrum.add(btVerbinden, 1, 6);
		
		GridPane.setHalignment(btVerbinden, HPos.RIGHT);
		
		tgRadios.getToggles().addAll(rbDirekt, rbLeerzeichen, rbLeerzeile);
			tgRadios.selectToggle(rbDirekt);
		
		setTop(menuBar);
		setCenter(gpZentrum);
	}
	
	private void addHandler() {
		miBeenden.setOnAction(event -> { Platform.exit(); } );
		btVerbinden.setOnAction(event -> verbinden());
		miReset.setOnAction(event -> reset());
	}

	// -------------------------- handler -------------------------
	
	private void verbinden() {
		String text1 = tfText1.getText();
		String text2 = tfText2.getText();
		String verbinder = ""; // Direct
		
		if (rbLeerzeichen.isSelected()) {
			verbinder = " "; // spacebar
		}
		
		if (rbLeerzeile.isSelected()) {
			verbinder = "\n"; // NewLine
		}
		
		if (!text1.isEmpty() && !text2.isEmpty()) {
			String ergebnis = text1 + verbinder + text2;
			
			taErgebnis.setText(ergebnis); 
			taErgebnis.setDisable(false);
		} else {
			if (text1.isEmpty() && text2.isEmpty()) {
				Main.showAlert(AlertType.ERROR, "Text1 fehlt\nText2 fehlt");
			} else {
				if (text1.isEmpty()) {
					Main.showAlert(AlertType.ERROR, "Text1 fehlt");
				} else {
					Main.showAlert(AlertType.ERROR, "Text2 fehlt");
				}
			}
			
		}
	}
	
	private void reset() {
		tgRadios.selectToggle(rbDirekt);
		
		tfText1.clear();
		tfText2.clear();
		
		taErgebnis.clear();
		taErgebnis.setDisable(true);
	}
	
}
