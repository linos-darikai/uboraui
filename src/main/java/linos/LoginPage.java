package linos;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    public Stage getPrimaryStage(){
        return primaryStage;
    }
    public void setMainWindow(Stage stage) {
        this.primaryStage = stage;
    }
    
    

    @FXML
    void login(ActionEvent event) {

    }

  @FXML
    void register(ActionEvent event) throws Exception {
        Parent root = (new FXMLLoader(getClass().getResource("register_page.fxml"))).load();
        Stage stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
