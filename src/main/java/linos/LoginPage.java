import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginPage {

    @FXML
    private Button closeButton;
    private Stage primaryStage;

    @FXML
    private TextField userEmail;

    @FXML
    private PasswordField userPassword;

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }
    public void setMainWindow(Stage stage) {
        this.primaryStage = stage;
    }
    

    @FXML
    void login(ActionEvent event) {

    }

    @FXML
    void register(ActionEvent event) {

    }

}
