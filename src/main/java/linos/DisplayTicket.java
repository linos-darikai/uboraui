package linos;

import java.io.File;
import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DisplayTicket {

    private UserManager userManager;
    private User currentUser;
    
    @FXML
    private Label locationEvent;

    @FXML
    private ImageView qrCodeForTicket;

    @FXML
    private Label seatNumber;

    @FXML
    private Label typeTicket;

    @FXML
    void backToHome(MouseEvent event) throws IOException {
         
        Parent root = (new FXMLLoader(getClass().getResource("home_page.fxml"))).load();
        Stage stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void setUserManager(UserManager us){
        this.userManager = us;
    }
    public void setCurrentUser(User s){
        this.currentUser = s;
    }
    public void setQRimage(String url) {
    try {
        File file = new File(url);
        if (!file.exists()) {
            System.err.println("QR Code file does not exist: " + url);
            return;
        }

        
        Platform.runLater(() -> {
            try {
                
                Image img = new Image(file.toURI().toString());
                
                if (img.isError()) {
                    System.err.println("Error loading image: " + url);
                    return;
                }
                
                qrCodeForTicket.setImage(img);
                typeTicket.setText("Name" + currentUser.getName());
                
            } catch (Exception e) {
                System.err.println("Error setting QR code image: " + e.getMessage());
                e.printStackTrace();
            }
        });
    } catch (Exception e) {
        System.err.println("Error preparing QR code image: " + e.getMessage());
        e.printStackTrace();
    }
}
   

}
