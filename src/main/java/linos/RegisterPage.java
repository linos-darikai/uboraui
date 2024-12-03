package linos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class RegisterPage {
    private UserManager userManage;
    private boolean isSTUclicked;
    private boolean isGUEclicked;
    private boolean isFACclicked;


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
    void changeFacState(MouseEvent event) {
        isFACclicked = true;
        facultyInd.setStyle("-fx-text-fill: red;");

    }
    public void setUserManager(UserManager userM){
        this.userManage = userM;
    }
    

    @FXML
    void changeGueState(MouseEvent event) {
        isGUEclicked = true;
        guestIndictator.setStyle("-fx-text-fill: blue;");

    }

    @FXML
    void changeStuState(MouseEvent event) {
        isSTUclicked = true;
        studentInd.setStyle("-fx-background: transparent;");

    }
   
    @FXML
    void close(MouseEvent event) {


    }

    @FXML
    void backToLogin(ActionEvent event) throws Exception {
        if(emailInput.getText().isEmpty() || passwordInput.getText().isEmpty() || reenterPassword.getText().isEmpty() 
            || nameInput.getText().isEmpty() || idInput.getText().isEmpty()){
                 Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Unfilled Fields");
                alert.setHeaderText("Unfield fields");
                alert.setContentText("Please Enter All details");
                alert.showAndWait();
            }
        if (isFACclicked){
            User newFac = new Faculty(idInput.getText(), nameInput.getText(),emailInput.getText(), passwordInput.getText());
            userManage.addUser(newFac);
            SceneController sceneController = App.getInstance().getSceneController();
            sceneController.switchToLogin();
        }
        if (isSTUclicked){
            User newSTU = new Student(idInput.getText(), nameInput.getText(),emailInput.getText(), passwordInput.getText());
            userManage.addUser(newSTU);
            SceneController sceneController = App.getInstance().getSceneController();
            sceneController.switchToLogin();
        }
        if (isGUEclicked){
            User newGUE = new Guest(emailInput.getText(), nameInput.getText(), passwordInput.getText(),idInput.getText());
            userManage.addUser(newGUE);
            SceneController sceneController = App.getInstance().getSceneController();
            sceneController.switchToLogin();
        }
        /*if (reenterPassword.getText().equalsIgnoreCase(passwordInput.getText())){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Password Not The same as Rentered Password");
            alert.setHeaderText("");
            alert.setContentText("Please the same Password and rentered Password");
            alert.showAndWait();

        }*/
      
       /*
 */
        
    }

}
