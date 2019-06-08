package processing;

import javafx.scene.image.ImageView;

public class SHIPLayout extends SpaceGame {

    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;
    private int rotateIncrease;
    private int layoutXIncrease;

    private final ImageView ship;

    public SHIPLayout(ImageView ship) {
        this.ship = ship;
        this.isLeftKeyPressed = false;
        this.isRightKeyPressed = false;
        this.rotateIncrease = 5;
        this.layoutXIncrease = 3;
    }

    public void move() {
        if (isLeftKeyPressed && !isRightKeyPressed) {
            if (ship.getRotate() > -30) {
                ship.setRotate(ship.getRotate() - rotateIncrease);
            }
            if (ship.getLayoutX() > -10) {
                ship.setLayoutX(ship.getLayoutX() - layoutXIncrease);
            }
        }
        if (!isLeftKeyPressed && isRightKeyPressed) {
            if (ship.getRotate() < 30) {
                ship.setRotate(ship.getRotate() + rotateIncrease);
            }
            if (ship.getLayoutX() < 530) {
                ship.setLayoutX(ship.getLayoutX() + layoutXIncrease);
            }
        }
        if (!isLeftKeyPressed && !isRightKeyPressed) {
            if (ship.getRotate() < 0) {
                ship.setRotate(ship.getRotate() + 5);
            } else if (ship.getRotate() > 0) {
                ship.setRotate(ship.getRotate() - 5);
            }
        }
        if (isLeftKeyPressed && isRightKeyPressed) {
            if (ship.getRotate() < 0) {
                ship.setRotate(ship.getRotate() + 5);
            } else if (ship.getRotate() > 0) {
                ship.setRotate(ship.getRotate() - 5);
            }
        }
    }

    public boolean isIsLeftKeyPressed() {
        return isLeftKeyPressed;
    }

    public void setIsLeftKeyPressed(boolean isLeftKeyPressed) {
        this.isLeftKeyPressed = isLeftKeyPressed;
    }

    public boolean isIsRightKeyPressed() {
        return isRightKeyPressed;
    }

    public void setIsRightKeyPressed(boolean isRightKeyPressed) {
        this.isRightKeyPressed = isRightKeyPressed;
    }

    public ImageView getShip() {
        return ship;
    }

    public int getRotateIncrease() {
        return rotateIncrease;
    }

    public void setRotateIncrease(int rotateIncrease) {
        this.rotateIncrease = rotateIncrease;
    }

    public int getLayoutXIncrease() {
        return layoutXIncrease;
    }

    public void setLayoutXIncrease(int layoutXIncrease) {
        this.layoutXIncrease = layoutXIncrease;
    }

}
