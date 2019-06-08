package processing;

import javafx.animation.FadeTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.Explosion;
import model.METEOR;
import model.METEORImage;

public class MeteorLayout extends LaserLayout {

    private ImageView[] meteorList;
    private ImageView[] explosion;
    private byte explosionIndex;

    public MeteorLayout(ImageView ship) {
        super(ship);
        
        this.meteorList = new ImageView[10];
        /* polymorphism */
        meteorList[0] = new METEORImage(METEOR.MeteorBrown_med1);
        meteorList[1] = new METEORImage(METEOR.MeteorGrey_med1);
        meteorList[2] = new METEORImage(METEOR.MeteorBrown_big4);
        meteorList[3] = new METEORImage(METEOR.MeteorGrey_big4);
        meteorList[4] = new METEORImage(METEOR.MeteorGrey_big3);
        meteorList[5] = new METEORImage(METEOR.MeteorBrown_big3);
        meteorList[6] = new METEORImage(METEOR.MeteorBrown_big2);
        meteorList[7] = new METEORImage(METEOR.MeteorGrey_big1);
        meteorList[8] = new METEORImage(METEOR.MeteorGrey_big2);
        meteorList[9] = new METEORImage(METEOR.MeteorGrey_big1);

        explosion = new ImageView[20];
        for (int i = 0; i < explosion.length; i++) {
            explosion[i] = new Explosion();//polymorphism
        }
        
        explosionIndex = 0;
    }

    public void meteorBreaking() {
        for (int i = 0; i < getLaserList().length; i++) {
            for (int j = 0; j < meteorList.length; j++) {
                if (checkIfElementsCollide(meteorList[j], getLaserList()[i])) {

                    explosion[explosionIndex].setLayoutX(meteorList[j].getLayoutX());
                    explosion[explosionIndex].setLayoutY(meteorList[j].getLayoutY());
                    opacitySet(explosion[explosionIndex]);

                    if (++explosionIndex == 20) {
                        explosionIndex = 0;
                    }

                    getLaserList()[i].setLayoutY(-100);
                    getLaserList()[i].setLayoutX(0);
                    setNewElementPosition(meteorList[j]);
                }
            }
        }

    }

    private void opacitySet(ImageView explosion) {
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(5000));
        fade.setFromValue(10);
        fade.setToValue(0);
        fade.setNode(explosion);
        fade.play();
    }

    public void moveMeteor() {
        for (int i = 0; i < meteorList.length; i++) {
            if (meteorList[i].getLayoutY() < 700) {
                meteorList[i].setLayoutY(meteorList[i].getLayoutY() + ((i + 1) * 0.7));
                meteorList[i].setRotate(meteorList[i].getRotate() + (i + 1) * 0.5);
            } else {
                setNewElementPosition(meteorList[i]);
            }
        }
    }

    public void setMeteorPosition(int index) {
        setNewElementPosition(meteorList[index]);
    }

    public ImageView[] getMeteorList() {
        return meteorList;
    }

    public void setMeteorList(ImageView[] meteorList) {
        this.meteorList = meteorList;
    }

    public ImageView[] getExplosion() {
        return explosion;
    }

    public void setExplosion(ImageView[] explosion) {
        this.explosion = explosion;
    }

}
