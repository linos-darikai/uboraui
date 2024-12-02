package linos;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomePage{
    @FXML
    private Label categoryName;
    

    @FXML
    private ImageView qrCode1;

    @FXML
    private ImageView qrCode2;

    @FXML
    private ImageView qrCode3;

// return to login after registering
    @FXML
    void backToLogin(MouseEvent event) throws Exception {
       
        Parent root = (new FXMLLoader(getClass().getResource("login_page.fxml"))).load();
        Stage stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    //goes to ticket_page
    @FXML
    void toPurchaseTicket(MouseEvent event) throws IOException{
          
        Parent root = (new FXMLLoader(getClass().getResource("purchase_ticket.fxml"))).load();
        Stage stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
     

    }

}


