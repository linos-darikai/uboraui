package linos;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PurchaseTicket {
    private boolean isVIP;
    private boolean isREGULAR;
    private UserManager userManager;
    private User currentUser;
    @FXML
    private Label regLabel;

    @FXML
    private Label vipLabel;
    @FXML
    private TextField creditInfo;

    @FXML
    private TextField cvvInfo;

    @FXML
    void returnHomePage(MouseEvent event) throws IOException {
        SceneController sceneController = App.getInstance().getSceneController();
        sceneController.switchToHome();
    }
    
    @FXML
    void setRegular(MouseEvent event) {
        if(!isVIP){
            regLabel.setStyle("-fx-background-color: lightgrey ; -fx-text-fill: black;");
            isREGULAR = true;          

        }
      
       
        }

    @FXML
    void setVIP(MouseEvent event) {
        if(!isREGULAR){
        vipLabel.setStyle("-fx-background-color: lightgrey ;-fx-text-fill: black;");
        isVIP = true;
        }
   

    }
    @FXML
    void purchaseTicket(ActionEvent event)throws IOException {
        if(creditInfo.getText().isEmpty() || cvvInfo.getText().isEmpty() || (!isVIP && !isREGULAR)){
               
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("No credit Card Info and ticket type");
            alert.setContentText("Please Enter All fields");
            alert.showAndWait();
            return;
        }
        
        String path = currentUser.getPath();



        Ticket t = new Ticket(currentUser.getName(), "22",133.0, "20", "VIP", path);
        try {
            QRCode.generateQRCode(currentUser.getEmail(), path);
            System.out.println("created QRCode");
            
        } catch (Exception e) {
            System.out.println("Failed to create QRCode");
            return;
        }
        
        currentUser.addTicket(t);
        SceneController sceneController = App.getInstance().getSceneController();
        DisplayTicket displayController = sceneController.getDisplayController();
        displayController.setCurrentUser(currentUser);
        displayController.setQRimage(currentUser.getPath());
        sceneController.switchToDisplay();
    }
    public void setUserManager(UserManager us){
        this.userManager = us;
    }
    public void setCurrentUser(User s){
        this.currentUser = s;
    }

    public boolean isOptionVIP(){return isVIP;}
    public boolean isOptionRegular(){return isREGULAR;}


}
