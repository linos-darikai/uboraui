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

public class DisplayTicket {

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

   

}
