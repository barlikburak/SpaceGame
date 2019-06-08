package processing;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class SpaceGameMainPane {

    private boolean isHidden;
    private AnchorPane paneToHide;

    public SpaceGameMainPane() {
        isHidden = false;
        paneToHide = null;
    }

    private void moveSubScene(AnchorPane pane) {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(pane);
        if (isHidden) {
            transition.setToX(700);
            isHidden = false;
        } else {
            transition.setToX(0);
            isHidden = true;
        }
        transition.play();
    }

    public void showPane(AnchorPane pane) {
        if (paneToHide != null) {
            moveSubScene(paneToHide);
        }
        moveSubScene(pane);
        paneToHide = pane;
    }
}
