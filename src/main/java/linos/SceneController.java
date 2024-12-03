package linos;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
    private Stage stage;
    private Scene loginScene;
    private Scene registerScene;
    private Scene homeScene;
    private Scene purchaseTicketScene;
    private Scene displayTicketScene;

    public SceneController(Stage stage) {
        this.stage = stage;
    }

    public void setLoginScene(Scene scene) {
        this.loginScene = scene;
    }

    public void setRegisterScene(Scene scene) {
        this.registerScene = scene;
    }
    public void setHomeScene(Scene scene){
        this.homeScene = scene;
    }
    public void setPurchaseTicketScene(Scene scene){
        this.purchaseTicketScene = scene;
    }
    public void setDisplayTicketScene(Scene scene){
        this.displayTicketScene = scene;
    }
    public void switchToLogin() {
        stage.setScene(loginScene);
    }

    public void switchToRegister() {
        stage.setScene(registerScene);
    }
    public void switchToHome(){
        stage.setScene(homeScene);
    }
    public void switchToPurchase(){
        stage.setScene(purchaseTicketScene);
    }
    public void switchToDisplay(){
        stage.setScene(displayTicketScene);
    }
}
