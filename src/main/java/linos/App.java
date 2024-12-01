package linos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/linos/login_page.fxml"));
            Parent root = loader.load();
            LoginPage controller = loader.getController();
            controller.setMainWindow(primaryStage);
            
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(new Scene(root, 700, 500));
            primaryStage.setTitle("Hello World");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace(); // This will print the full stack trace
            throw e; // Rethrow to maintain original behavior
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
