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
    private HomePage homeController;
    private PurchaseTicket purchaseTController;
    private DisplayTicket dController;

    public SceneController(Stage stage) {
        this.stage = stage;
    }

    public void setLoginScene(Scene scene) {
        this.loginScene = scene;
    }

    public void setRegisterScene(Scene scene) {
        this.registerScene = scene;
    }
    public void setHomeScene(Scene scene, HomePage controller){
        this.homeScene = scene;
        this.homeController = controller;
    }
    public void setPurchaseTicketScene(Scene scene, PurchaseTicket controller){
        this.purchaseTicketScene = scene;
        this.purchaseTController = controller;
    }
    public void setDisplayTicketScene(Scene scene, DisplayTicket controller){
        this.displayTicketScene = scene;
        this.dController = controller;
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
    public HomePage getHomeController() {
        return homeController;
    }
    public PurchaseTicket getPurchaseController(){
        return purchaseTController;
    }
    public DisplayTicket getDisplayController(){
        return dController;
        
    }
}
