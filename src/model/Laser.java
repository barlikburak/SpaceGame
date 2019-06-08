package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Laser extends ImageView {

    public Laser() {
        super(new Image("/view/resources/laser.png"));
        setLayoutY(-100);
    }

}
