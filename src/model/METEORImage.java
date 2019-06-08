package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class METEORImage extends ImageView {

    public METEORImage(METEOR meteor) {
        super(new Image(meteor.getURL()));
        setFitWidth(meteor.getSIZE());
        setFitHeight(meteor.getSIZE());
        setLayoutY(1000);
    }

}
