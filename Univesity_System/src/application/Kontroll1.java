package application;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Kontroll1 {

    @FXML
    private Button logohu;

    @FXML
    private RadioButton professorbtn;

    @FXML
    private RadioButton studentbtn;

    private ToggleGroup group;

    //inicializim dhe togglegroup qe te jete e mundeur per  perdoruesin qe te zgjedhe vetem nje opsion
    public void initialize() {
        group = new ToggleGroup();
        professorbtn.setToggleGroup(group);
        studentbtn.setToggleGroup(group);
    }

    //metode ndihmese per te shfaqur Alert
    private void showAlert(AlertType alertType, String title, String content) {
        AudioClip clip = new AudioClip("file:/C:/Windows/Media/Windows%20Background.wav");
        clip.play();

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    //metode per te hapur dritaret e profesorit  dhe studentit
    public void handleLogin() {
        try {
            if (professorbtn.isSelected()) {
                hapDritareProfesori();
            } else if (studentbtn.isSelected()) {
                hapDritareStudenti();
            } else {
                showAlert(AlertType.WARNING, "Error!", "You have not selected any user type.Please choose one.");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //metoda ndihmese per te hapur dritaren studenti
    public void hapDritareStudenti() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/student/student.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 658, 550);
            Stage stage_i_ri = new Stage();
            stage_i_ri.getIcons().add(new Image(getClass().getResourceAsStream("/Screenshot 2025-04-16 102359.png")));
            stage_i_ri.setScene(scene);
            stage_i_ri.setTitle("Student");
            stage_i_ri.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  //metoda ndihmese per te hapur dritaren profesori
    public void hapDritareProfesori() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/professor/professor.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root, 682, 593);
            Stage stage_i_ri = new Stage();
            stage_i_ri.getIcons().add(new Image(getClass().getResourceAsStream("/Screenshot 2025-04-16 102438.png")));
            stage_i_ri.setScene(scene);
            stage_i_ri.setTitle("Professor");
            stage_i_ri.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
