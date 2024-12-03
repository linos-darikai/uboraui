package linos;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginPage {
    private UserManager userManage;
    private User currentUser;

    @FXML
    private Button closeButton;
    private Stage primaryStage;

 

    @FXML
    private TextField userEmail;

    @FXML
    private PasswordField userPasswordInput;

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
    public void setCurrentUser(User s){
        this.currentUser = s;
    }
    public void setUserManager(UserManager userM){
        this.userManage = userM;
    }
    
    

    @FXML
    void login(ActionEvent event)throws IOException {

        if(userManage.getUsers().isEmpty()){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("No User");
            alert.setHeaderText("....");
            alert.setContentText("No User yet Please Register");
            alert.showAndWait();
            
        }
        if(userManage.getUserByPassword(userPasswordInput.getText()) != null){
            this.currentUser = userManage.getUserByPassword(userPasswordInput.getText());
            
            // Set current user in App singleton
            App.getInstance().setCurrentUser(userManage.getUserByPassword(userPasswordInput.getText()));
            
            // Switch to home scene
            SceneController sceneController = App.getInstance().getSceneController();
            sceneController.switchToHome();
        }
        if(userManage.getUserByPassword(userPasswordInput.getText()) == null){
      
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Password Incorrect");
            alert.setHeaderText("....");
            alert.setContentText("Wrong Password");
            alert.showAndWait();
            System.out.println(userPasswordInput.getText());
        }

        

    
        

    }

  @FXML
    void register(ActionEvent event) throws Exception {
        SceneController sceneController = App.getInstance().getSceneController();
        sceneController.switchToRegister();
    }
}
