package student;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;



public class MainStudent extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("student.fxml"));

        Scene scene = new Scene(root, 658, 550);

        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/Screenshot 2025-04-16 102359.png")));
        primaryStage.setTitle("Student");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
