package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.SHIP;
import processing.ButtonStyle;
import processing.InfoLabel;
import processing.SHIPPicker;
import processing.SpaceGameMainPane;

public class FXMLViewManagerController extends Application implements Initializable {

    @FXML
    private Button playButton;
    @FXML
    private Button scoresButton;
    @FXML
    private Button helpButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button pointsButton;
    @FXML
    private Button startButton;
    @FXML
    private AnchorPane shipChooserPane;
    @FXML
    private AnchorPane scoresPane;
    @FXML
    private AnchorPane helpPane;
    @FXML
    private AnchorPane pointsPane;
    @FXML
    private ImageView logo;
    @FXML
    private VBox shipBlue;
    @FXML
    private VBox shipGreen;
    @FXML
    private VBox shipOrange;
    @FXML
    private VBox shipRed;
    @FXML
    private ImageView shipBlueCircle;
    @FXML
    private ImageView shipGreenCircle;
    @FXML
    private ImageView shipOrangeCircle;
    @FXML
    private ImageView shipRedCircle;
    @FXML
    private Label helpLabel;
    @FXML
    private Label pointsLabel;
    @FXML
    private Label scoreLabel;

    private ButtonStyle buttonStyle;
    private SpaceGameMainPane anchorPaneStyle;
    private SHIPPicker shipToPick;
    private Stage menuStage;

    @FXML
    private void startMousePressed(MouseEvent event) throws Exception {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            getButtonStyle().setOnMousePressed(startButton);
            if (this.shipToPick != null) {
                start(new Stage());
            }
        }
    }

    @FXML
    private void startMouseReleased(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            getButtonStyle().setOnMouseReleased(startButton);
        }
    }

    @FXML
    private void MouseClikedShipBlue() {
        shipToPick = new SHIPPicker(SHIP.Blue);
        this.setIsCircleNotChoosen();
        shipToPick.setIsCircleChoosen(shipBlueCircle, true);
    }

    @FXML
    private void MouseClikedShipGreen() {
        shipToPick = new SHIPPicker(SHIP.Green);
        this.setIsCircleNotChoosen();
        shipToPick.setIsCircleChoosen(shipGreenCircle, true);
    }

    @FXML
    private void MouseClikedShipOrange() {
        shipToPick = new SHIPPicker(SHIP.Orange);
        this.setIsCircleNotChoosen();
        shipToPick.setIsCircleChoosen(shipOrangeCircle, true);
    }

    @FXML
    private void MouseClikedShipRed() {
        shipToPick = new SHIPPicker(SHIP.Red);
        this.setIsCircleNotChoosen();
        shipToPick.setIsCircleChoosen(shipRedCircle, true);
    }

    @FXML
    private void mouseEnteredLogo() {
        logo.setEffect(new DropShadow());
    }

    @FXML
    private void mouseExitedLogo() {
        logo.setEffect(null);
    }

    @FXML
    private void mouseReleasedPlayButton(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            getButtonStyle().setOnMouseReleased(playButton);
        }
    }

    @FXML
    private void mousePressedPlayButton(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            getButtonStyle().setOnMousePressed(playButton);
            getAnchorPaneStyle().showPane(shipChooserPane);
        }
    }

    @FXML
    private void mouseEnteredPlayButton() {
        getButtonStyle().setOnMouseEntered(playButton);
    }

    @FXML
    private void mouseExitedPlayButton() {
        getButtonStyle().setOnMouseExited(playButton);
    }

    @FXML
    private void mouseReleasedScoresButton(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            getButtonStyle().setOnMouseReleased(scoresButton);
        }
    }

    @FXML
    private void mousePressedScoresButton(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            getButtonStyle().setOnMousePressed(scoresButton);
            getAnchorPaneStyle().showPane(scoresPane);
            InfoLabel infoLabel = new InfoLabel();
            infoLabel.scores(scoreLabel);
        }
    }

    @FXML
    private void mouseEnteredScoresButton() {
        getButtonStyle().setOnMouseEntered(scoresButton);
    }

    @FXML
    private void mouseExitedScoresButton() {
        getButtonStyle().setOnMouseExited(scoresButton);
    }

    @FXML
    private void mouseReleasedHelpButton(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            getButtonStyle().setOnMouseReleased(helpButton);
        }
    }

    @FXML
    private void mousePressedHelpButton(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            getButtonStyle().setOnMousePressed(helpButton);
            getAnchorPaneStyle().showPane(helpPane);
            InfoLabel help = new InfoLabel();
            help.help(helpLabel);
        }
    }

    @FXML
    private void mouseEnteredHelpButton() {
        getButtonStyle().setOnMouseEntered(helpButton);
    }

    @FXML
    private void mouseExitedHelpButton() {
        getButtonStyle().setOnMouseExited(helpButton);
    }

    @FXML
    private void mouseReleasedExitButton(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            getButtonStyle().setOnMouseReleased(exitButton);
        }
    }

    @FXML
    private void mousePressedExitButton(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            getButtonStyle().setOnMousePressed(exitButton);
            Platform.exit();
        }
    }

    @FXML
    private void mouseEnteredExitButton() {
        getButtonStyle().setOnMouseEntered(exitButton);
    }

    @FXML
    private void mouseExitedExitButton() {
        getButtonStyle().setOnMouseExited(exitButton);
    }

    @FXML
    private void mouseReleasedPointsButton(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            getButtonStyle().setOnMouseReleased(pointsButton);
        }
    }

    @FXML
    private void mousePressedPointsButton(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            getButtonStyle().setOnMousePressed(pointsButton);
            getAnchorPaneStyle().showPane(pointsPane);
            InfoLabel infoLabel = new InfoLabel();
            infoLabel.points(pointsLabel);
        }
    }

    @FXML
    private void mouseEnteredPointsButton() {
        getButtonStyle().setOnMouseEntered(pointsButton);
    }

    @FXML
    private void mouseExitedPointsButton() {
        getButtonStyle().setOnMouseExited(pointsButton);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private ButtonStyle getButtonStyle() {
        if (this.buttonStyle == null) {
            this.buttonStyle = new ButtonStyle();
        }
        return buttonStyle;
    }

    private SpaceGameMainPane getAnchorPaneStyle() {
        if (this.anchorPaneStyle == null) {
            this.anchorPaneStyle = new SpaceGameMainPane();
        }
        return anchorPaneStyle;
    }

    private void setIsCircleNotChoosen() {
        shipToPick.setIsCircleChoosen(shipRedCircle, false);
        shipToPick.setIsCircleChoosen(shipBlueCircle, false);
        shipToPick.setIsCircleChoosen(shipGreenCircle, false);
        shipToPick.setIsCircleChoosen(shipOrangeCircle, false);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/FXMLGameViewManager.fxml"));

        Parent root = loader.load();

        FXMLGameViewManagerController fXMLGameViewManagerController = loader.getController();
        fXMLGameViewManagerController.setShipToPick(this.shipToPick);
        fXMLGameViewManagerController.setMenuStage(this.menuStage);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        this.menuStage.hide();
        fXMLGameViewManagerController.setGameStage(primaryStage);

        primaryStage.show();
    }

    public void setMenuStage(Stage menuStage) {
        this.menuStage = menuStage;
    }

}
