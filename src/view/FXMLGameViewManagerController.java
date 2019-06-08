package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.SHIPImage;
import processing.InfoLabel;
import processing.LifeLayout;
import processing.SHIPPicker;
import processing.SlowingPanelLayout;
import processing.StarLayout;
import processing.TextOperation;

public class FXMLGameViewManagerController extends AnimationTimer implements Initializable {

    @FXML
    private AnchorPane gamePane;
    @FXML
    private GridPane gridPane1;
    @FXML
    private GridPane gridPane2;
    @FXML
    private Button play;

    private Stage menuStage;
    private Stage gameStage;

    private SHIPPicker shipToPick;
    private ImageView ship;

    private SlowingPanelLayout slowingPanelLayout;
    private LifeLayout lifeLayout;
    private StarLayout starLayout;

    @FXML
    private void initializeGame() {
        play.setVisible(false);
        this.ship = new SHIPImage(shipToPick.getShip());//polymorphism
        this.slowingPanelLayout = new SlowingPanelLayout(ship);
        this.lifeLayout = new LifeLayout(ship, shipToPick.getShip().getUrlLife());
        this.starLayout = new StarLayout(ship);
        this.lifeLayout.createBackground(gridPane1, gridPane2);

        gamePane.getChildren().add(slowingPanelLayout.getSlowingPanel());
        gamePane.getChildren().addAll(lifeLayout.getExplosion());
        gamePane.getChildren().addAll(lifeLayout.getMeteorList());
        gamePane.getChildren().addAll(lifeLayout.getLaserList());
        gamePane.getChildren().add(lifeLayout.getLife());
        gamePane.getChildren().add(starLayout.getStar());
        gamePane.getChildren().add(starLayout.getPointsLabel());
        gamePane.getChildren().addAll(lifeLayout.getPlayerLife());
        gamePane.getChildren().add(ship);

        start();
    }

    @FXML
    private void playButtonEntered() {
        play.setEffect(new DropShadow());
    }

    @FXML
    private void playButtonExited() {
        play.setEffect(null);
    }

    @FXML
    private void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.LEFT) {
            slowingPanelLayout.setIsLeftKeyPressed(true);
        }
        if (event.getCode() == KeyCode.RIGHT) {
            slowingPanelLayout.setIsRightKeyPressed(true);
        }
        if (event.getCode() == KeyCode.SPACE) {
            lifeLayout.setIsSpaceKeyPressed(true);
        }
    }

    @FXML
    private void onKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.LEFT) {
            slowingPanelLayout.setIsLeftKeyPressed(false);
        }
        if (event.getCode() == KeyCode.RIGHT) {
            slowingPanelLayout.setIsRightKeyPressed(false);
        }
        if (event.getCode() == KeyCode.SPACE) {
            lifeLayout.setIsSpaceKeyPressed(false);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void handle(long now) {
        this.slowingPanelLayout.moveBackground(gridPane1, gridPane2);
        this.lifeLayout.moveLaser();
        this.slowingPanelLayout.move();
        this.slowingPanelLayout.movePanel();
        this.lifeLayout.moveMeteor();
        this.lifeLayout.meteorBreaking();
        this.lifeLayout.move();
        this.starLayout.move();
        this.starLayout.setPoints();
        if (this.lifeLayout.removeLife()) {
            TextOperation pointSave = new InfoLabel(Integer.toString(this.starLayout.getPoints()));//polymorphism
            pointSave.writeOperation();
            this.gameStage.close();
            stop();
            this.menuStage.show();
        }
        this.lifeLayout.lifeCollide();
    }

    public void setMenuStage(Stage menuStage) {
        this.menuStage = menuStage;
    }

    public void setGameStage(Stage gameStage) {
        this.gameStage = gameStage;
    }

    public void setShipToPick(SHIPPicker shipToPick) {
        this.shipToPick = shipToPick;
    }

}
