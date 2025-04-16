package student;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;

public class Kontroll3 {

    @FXML
    private ComboBox<String> Combo_deger;

    @FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

    @FXML
    private ComboBox<String> Combo_emra;

    @FXML
    private TextField Short_description;

    @FXML
    private TextArea details;

    @FXML
    private Button saveBtn;

    //metode ndihmese per te shfaqur Alert
    private void showAlert(AlertType alertType, String title, String header, String content) {
        AudioClip clip = new AudioClip("file:/C:/Windows/Media/Windows%20Background.wav");
        clip.play();

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    //inicializimi dhe mbushja e ComboBox-ve
    public void initialize() {
        Combo_deger.getItems().addAll("Bachelor", "Master", "PhD", "Diploma", "Certificate");
        Combo_emra.getItems().addAll("Arber", "Eridor", "Gent", "Rea", "Drilon");
    }

    //metode per ti shfaqur te dhenat  
    public void shfaqStudent() {
    	//variablat per te marre 
        String dega = Combo_deger.getValue();
        String emri = Combo_emra.getValue();
        
        //tranry tree -->shkurt nje if else
        String from = (fromDate.getValue() != null) ? fromDate.getValue().toString() : "";
        String to = (toDate.getValue() != null) ? toDate.getValue().toString() : "";
        
        
        String pershkrimi = Short_description.getText();
        String reth_meje = details.getText();

        //kontroll për fushat bosh
        if (dega == null || dega.isEmpty() || from.isEmpty() || to.isEmpty() || emri == null || emri.isEmpty() || pershkrimi == null || pershkrimi.isEmpty() || reth_meje == null || reth_meje.isEmpty()) {
            showAlert(AlertType.WARNING, "Error!", "Missing Input", "Please fill all fields before saving.");
            return;
        }

        //nqs gjithcka eshte ok ,shfaq informacionin
        String info = String.format("Degree: %s\nDate From: %s\nDate To: %s\nName: %s\nShort Description: %s\nMore about me: %s",dega, from, to, emri, pershkrimi, reth_meje);

        showAlert(AlertType.INFORMATION, "Student Information", "Information", info);

        //reset të fushave
        Combo_deger.setValue(null);
        Combo_emra.setValue(null);
        fromDate.setValue(null);
        toDate.setValue(null);
        Short_description.clear();
        details.clear();
    }
}
