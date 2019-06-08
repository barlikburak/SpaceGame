package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public final class SlowingPanel extends ImageView {

    public SlowingPanel() {
        super(new Image("/view/resources/slowing_panel.png"));
        setFitHeight(150);
        setFitWidth(200);
        setLayoutY(1000);
    }

}
