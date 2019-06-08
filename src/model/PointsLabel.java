package model;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.text.Font;

public class PointsLabel extends Label {

    public PointsLabel() {
        super("POINTS : 00");
        Image image = new Image("/model/resources/info_label_blue.png", 150, 50, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        setBackground(new Background(backgroundImage));
        setAlignment(Pos.CENTER);
        setPrefWidth(130);
        setPrefHeight(50);
        setLayoutX(460);
        setLayoutY(10);
        setFont(new Font(null, 18));
    }

}
