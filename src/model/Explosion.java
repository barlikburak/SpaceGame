package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Explosion extends ImageView {

    public Explosion() {
        super(new Image("/view/resources/explosion.png"));
        setFitWidth(70);
        setFitHeight(70);
        setLayoutY(-100);
    }

}
