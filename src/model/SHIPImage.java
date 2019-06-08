package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SHIPImage extends ImageView {

    public SHIPImage(SHIP ship) {
        super(new Image(ship.getUrlShip()));
        setFitWidth(75);
        setFitHeight(60);
        setLayoutX(250);
        setLayoutY(610);
    }

}
