package linos;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {
    private UserManager appManager;
    private SceneController sceneController;
    private static App instance;
    private User currentUser;// = new User("0", "John Doe","@", "0000");   

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            instance = this;
            sceneController = new SceneController(primaryStage);
            appManager = new UserManager();

           
            URL fileUrl = getClass().getResource("/tickets.csv");
            if (fileUrl != null) {
                System.out.println("File path: " + fileUrl.getPath());
                appManager.loadUsersFromCSV(fileUrl.getPath());
            } else {
                System.err.println("CSV file not found");
            }
            // Loading the main page
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/linos/login_page.fxml"));
            Parent loginRoot = loginLoader.load();
            LoginPage loginController = loginLoader.getController();
            loginController.setUserManager(appManager);
            loginController.setCurrentUser(currentUser);
            Scene loginScene = new Scene(loginRoot, 700, 500);
            sceneController.setLoginScene(loginScene);

            // Loading the Register Scene
            FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("/linos/register_page.fxml"));
            Parent registerRoot = registerLoader.load();
            RegisterPage registerController = registerLoader.getController();
            registerController.setUserManager(appManager);
            Scene registerScene = new Scene(registerRoot, 800, 500);
            sceneController.setRegisterScene(registerScene);

            FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/linos/home_page.fxml"));
            Parent homeRoot = homeLoader.load(); 
            HomePage homeController = homeLoader.getController();
            homeController.setUserManager(appManager);
            Scene homeScene = new Scene(homeRoot, 800, 500);
            sceneController.setHomeScene(homeScene, homeController);

            // Loading the Purchase Ticket Scene
            FXMLLoader purchaseLoader = new FXMLLoader(getClass().getResource("/linos/purchase_ticket.fxml"));
            Parent purchaseRoot = purchaseLoader.load();
            PurchaseTicket purchaseController = purchaseLoader.getController();
            purchaseController.setUserManager(appManager);
            Scene purchaseScene = new Scene(purchaseRoot, 800, 500);
            sceneController.setPurchaseTicketScene(purchaseScene, purchaseController);

            // Loading the Display Ticket Scene
            FXMLLoader dLoader = new FXMLLoader(getClass().getResource("/linos/display_ticket.fxml"));
            Parent displayRoot = dLoader.load();
            DisplayTicket displayController = dLoader.getController();
            displayController.setUserManager(appManager);
            Scene displayScene = new Scene(displayRoot, 800, 500);
            sceneController.setDisplayTicketScene(displayScene, displayController);

            // Show the initial scene (login page)
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.setScene(loginScene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace(); 
            throw e; 
        }
    }


    public SceneController getSceneController() {
        return sceneController;
    }

    public static App getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setCurrentUser(User userByPassword) {
        this.currentUser = userByPassword;
    }
    public User getCurrentUser() {
        return this.currentUser;
        }
}
