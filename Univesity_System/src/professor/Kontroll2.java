package professor;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;

public class Kontroll2 {

	@FXML
	private ComboBox<String> Combo_akt;

	@FXML
	private DatePicker fromDate, toDate;

	@FXML
	private RadioButton allDayRadio, morningRadio, afternoonRadio;

	@FXML
	private ComboBox<String> Combo_prf;

	@FXML
	private TextField Short_descripton;

	@FXML
	private TextArea details;

	private ToggleGroup grupimi_i_zgjedhuar;
	
	//metodw ndihmëse per te shfaqur Alert
	private void showAlert(AlertType alertType, String title, String header, String content) {
	    AudioClip clip = new AudioClip("file:/C:/Windows/Media/Windows%20Background.wav");
	    clip.play();

	    Alert alert = new Alert(alertType);
	    alert.setTitle(title);
	    alert.setHeaderText(header);
	    alert.setContentText(content);
	    alert.showAndWait();
	}
	
    
	//inicializimi dhe mbushja e cobobox
	public void initialize() {
		Combo_akt.getItems().addAll("Office", "Home-day", "Day-off");

		Combo_prf.getItems().addAll("Prof. Arber", "Prof. Blerta", "Prof. Luan", "Prof. Drita", "Prof. Shkelqim");

		//toggleGroup qe mos te zgjidhet me shume se nje opsion
	    //dhe i caktojme butonat perkates
		grupimi_i_zgjedhuar = new ToggleGroup();
		allDayRadio.setToggleGroup(grupimi_i_zgjedhuar);
		morningRadio.setToggleGroup(grupimi_i_zgjedhuar);
		afternoonRadio.setToggleGroup(grupimi_i_zgjedhuar);
	}

	//metoda per te marre dhe shfaqur te dhenat e profesorit
	public void ShfaqProfesor() {
		//variablat perkatese per secilin fxml 
		String aktiviteti = Combo_akt.getValue();
		
		String from = (fromDate.getValue() != null) ? fromDate.getValue().toString() : "";
		String to = (toDate.getValue() != null) ? toDate.getValue().toString() : "";

		Toggle zgjedhja = grupimi_i_zgjedhuar.getSelectedToggle();
		String prof = Combo_prf.getValue();
		String pershkrimi = Short_descripton.getText();
		String reth_meje = details.getText();

		//kontroll nese njera nga fushat lihet bosh
		if (aktiviteti == null || aktiviteti.isEmpty() || from.isEmpty() || to.isEmpty() || zgjedhja == null|| prof == null || prof.isEmpty() || pershkrimi == null || pershkrimi.isEmpty()|| reth_meje == null || reth_meje.isEmpty()) {
			showAlert(AlertType.WARNING, "Error!", "Missing Input", "Please fill all in fields before saving");
			return; //ndalo veprimin
		}

		//kontroll per cilen pjese te dites ka zgjedhur porofesori dhe mos te kemi me shume se nje zgjedhje
		String pjesa_e_dites = "";
		if (allDayRadio.isSelected())
			pjesa_e_dites = "All day";
		else if (morningRadio.isSelected())
			pjesa_e_dites = "Morning";
		else if (afternoonRadio.isSelected())
			pjesa_e_dites = "Afternoon";

		//mesazh afishues 
		showAlert(AlertType.INFORMATION, "Professor Information", "Information", String.format("Activity: %s\nDate From: %s\nDate To: %s\nPortion: %s\nUser: %s\nShort Description: %s\nMore about me: %s",aktiviteti, from, to, pjesa_e_dites, prof,  pershkrimi, reth_meje));
		
		//reset te fushave pas shaqjes se mesazhit informues 
		Combo_akt.setValue(null);
		fromDate.setValue(null);
		toDate.setValue(null);
		grupimi_i_zgjedhuar.selectToggle(null);
		allDayRadio.setSelected(false); 
		morningRadio.setSelected(false);
		afternoonRadio.setSelected(false);
		Combo_prf.setValue(null);
		Short_descripton.clear();
		details.clear();
	}
}
