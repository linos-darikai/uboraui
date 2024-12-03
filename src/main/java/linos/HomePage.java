package linos;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HomePage {
    private UserManager userManager;
    private User currentUser;

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

    @FXML
    public void initialize() {
        // Retrieve current user when the page initializes
        currentUser = App.getInstance().getCurrentUser();
        
        // Display welcome message if user exists
        if (currentUser != null && welcomeMessage != null) {
            welcomeMessage.setText("Welcome, " + currentUser.getName());
        }
    }

    // Return to login after registering
    @FXML
    void backToLogin(MouseEvent event) throws Exception {
        SceneController sceneController = App.getInstance().getSceneController();
        sceneController.switchToLogin();
    }

    public void setUserManager(UserManager us) {
        this.userManager = us;
    }

    public void setCurrentUser(User us) {
        this.currentUser = us;
        
        // Update welcome message when user is set
        if (welcomeMessage != null || us != null) {
            welcomeMessage.setText("Welcome, " + App.getInstance().getCurrentUser().getName());
        }
    }

    // Goes to ticket_page
    @FXML
    void toPurchaseTicket(MouseEvent event) throws IOException {
        SceneController sceneController = App.getInstance().getSceneController();
        sceneController.switchToPurchase();
    }
}