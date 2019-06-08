package processing;

import javafx.scene.image.ImageView;
import model.Laser;

public class LaserLayout extends SHIPLayout {

    private boolean isSpaceKeyPressed;
    private boolean isLaserDistanceControl;
    private ImageView[] laserList;

    public LaserLayout(ImageView ship) {
        super(ship);
        this.isSpaceKeyPressed = false;
        laserList = new ImageView[10];
        for (int i = 0; i < laserList.length; i++) {
            laserList[i] = new Laser();//polymorphism
        }
    }
    

    public void moveLaser() {
        for (int i = 0; i < laserList.length; i++) {
            if (laserList[i].getLayoutY() > -80) {
                laserList[i].setLayoutY(laserList[i].getLayoutY() - 7);
            }
        }
        if (isSpaceKeyPressed) {
            for (int i = 0; i < laserList.length - 1; i++) {
                isLaserDistanceControl = true;
                for (int j = i - 1; j >= 0 && isLaserDistanceControl; j--) {
                    if (laserList[j].getLayoutY() > (450 - (j * 50))) {
                        isLaserDistanceControl = false;
                    }
                }
                if (isLaserDistanceControl && laserList[i].getLayoutY() < -50) {
                    laserList[i].setLayoutY(550);
                    laserList[i].setLayoutX(getShip().getLayoutX() + 35);
                }
            }
        }
    }

    public boolean isIsSpaceKeyPressed() {
        return isSpaceKeyPressed;
    }

    public void setIsSpaceKeyPressed(boolean isSpaceKeyPressed) {
        this.isSpaceKeyPressed = isSpaceKeyPressed;
    }

    public ImageView[] getLaserList() {
        return laserList;
    }

    public void setLaserList(ImageView[] laserList) {
        this.laserList = laserList;
    }

}
