package professor;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;


public class MainProfessor extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("professor.fxml"));

        Scene scene = new Scene(root, 682, 593);

        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/Screenshot 2025-04-16 102438.png")));
        primaryStage.setTitle("Professor");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
