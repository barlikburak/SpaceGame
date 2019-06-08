package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public final class Star extends ImageView {

    public Star() {
        super(new Image("/view/resources/star.png"));
        setFitHeight(30);
        setFitWidth(30);
        setLayoutY(1000);
    }

}
