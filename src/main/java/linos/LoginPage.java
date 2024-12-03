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
            return;
            
        }
        User foundUser = userManage.getUserByPassword(userPasswordInput.getText());

        if( foundUser == null){
      
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Password Incorrect");
            alert.setHeaderText("....");
            alert.setContentText("Wrong Password");
            alert.showAndWait();
            System.out.println(userPasswordInput.getText());
            return;
        }
        SceneController sceneController = App.getInstance().getSceneController();
        
        
        HomePage homeController = sceneController.getHomeController();
        
      
        homeController.setCurrentUser(foundUser);
        
        
        sceneController.switchToHome();
        
     
               

    }

  @FXML
    void register(ActionEvent event) throws Exception {
        SceneController sceneController = App.getInstance().getSceneController();
        sceneController.switchToRegister();
    }
}
