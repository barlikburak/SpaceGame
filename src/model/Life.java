package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Life extends ImageView {

    public Life() {
        super(new Image("/view/resources/life.png"));
        setFitWidth(30);
        setFitHeight(30);
        setLayoutY(1000);
    }

    public Life(String URL) {
        super(new Image(URL));
        setFitWidth(30);
        setFitHeight(22.5f);
        setLayoutY(80);
        setLayoutX(460);
    }

}
