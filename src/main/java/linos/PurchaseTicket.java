package linos;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class PurchaseTicket {
    private boolean isVIP;
    private boolean isREGULAR;
    private UserManager userManager;

    @FXML
    void returnHomePage(MouseEvent event) throws IOException {
        SceneController sceneController = App.getInstance().getSceneController();
        sceneController.switchToHome();
    }
    
    @FXML
    void setRegular(MouseEvent event) {

    }

    @FXML
    void setVIP(MouseEvent event) {

    }
    @FXML
    void purchaseTicket(ActionEvent event)throws IOException {
        SceneController sceneController = App.getInstance().getSceneController();
        sceneController.switchToDisplay();
    }
    public void setUserManager(UserManager us){
        this.userManager = us;
    }

    public boolean isOptionVIP(){return isVIP;}
    public boolean isOptionRegular(){return isREGULAR;}


}
