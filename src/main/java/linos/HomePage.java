package linos;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HomePage{
    private UserManager userManager;
    private User currentUser = App.getInstance().getCurrentUser();
    @FXML
    private Label categoryName;
    @FXML
    private Button welcomeMessage;

    @FXML
    private ImageView qrCode1;

    @FXML
    private ImageView qrCode2;

    @FXML
    private ImageView qrCode3;

// return to login after registering
    @FXML
    void backToLogin(MouseEvent event) throws Exception {
       
        SceneController sceneController = App.getInstance().getSceneController();
        sceneController.switchToLogin();

    }
    public void setUserManager(UserManager us){
        this.userManager = us;
    }
    public void setCurrentUser(User us){
        this.currentUser = us;
    }
    //goes to ticket_page
    @FXML
    void toPurchaseTicket(MouseEvent event) throws IOException{
          
        SceneController sceneController = App.getInstance().getSceneController();
        sceneController.switchToPurchase();


    }

    @FXML
    void welcomeUser(ActionEvent event) {
        welcomeMessage.setText("Welcome, " + currentUser.getName());

    }
   
       

}


