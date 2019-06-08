package model;

import javafx.scene.image.ImageView;

public abstract class SHIPCircle {

    private final String circleNotChoosen;
    private final String circleChoosen;

    private final SHIP ship;

    public SHIPCircle(SHIP ship) {
        circleNotChoosen = "/view/resources/shipchooser/grey_circle.png";
        circleChoosen = "/view/resources/shipchooser/boxTick.png";
        this.ship = ship;
    }

    public abstract void setIsCircleChoosen(ImageView circleImage, boolean isCircleChoosen);

    public SHIP getShip() {
        return ship;
    }

    public String getCircleNotChoosen() {
        return circleNotChoosen;
    }

    public String getCircleChoosen() {
        return circleChoosen;
    }

}
