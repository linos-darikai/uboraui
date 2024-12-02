package linos;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PurchaseTicket {
    private boolean isVIP;
    private boolean isREGULAR;

    @FXML
    void returnHomePage(MouseEvent event) throws IOException {
        Parent root = (new FXMLLoader(getClass().getResource("home_page.fxml"))).load();
        Stage stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void setRegular(MouseEvent event) {

    }

    @FXML
    void setVIP(MouseEvent event) {

    }
    @FXML
    void purchaseTicket(ActionEvent event)throws IOException {
        Parent root = (new FXMLLoader(getClass().getResource("display_ticket.fxml"))).load();
        Stage stage = (Stage)((Node)(event.getSource())).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public boolean isOptionVIP(){return isVIP;}
    public boolean isOptionRegular(){return isREGULAR;}


}
