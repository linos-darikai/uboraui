package linos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class RegisterPage {

    @FXML
    private TextField emailInput;

    @FXML
    private Label facultyInd;

    @FXML
    private Label guestIndictator;

    @FXML
    private TextField idInput;

    @FXML
    private TextField nameInput;

    @FXML
    private PasswordField passwordInput;

    @FXML
    private PasswordField reenterPassword;

    @FXML
    private Label studentInd;
    @FXML
    void changeColor(MouseEvent event) {

    }

    @FXML
    void close(MouseEvent event) {


    }

    @FXML
    void backToLogin(ActionEvent event) throws Exception {
       
        Parent root = (new FXMLLoader(getClass().getResource("login_page.fxml"))).load();
        Stage stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
