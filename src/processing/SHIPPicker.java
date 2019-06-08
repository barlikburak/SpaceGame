package processing;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.SHIP;
import model.SHIPCircle;

public class SHIPPicker extends SHIPCircle {

    private boolean isCircleChoosen;

    public SHIPPicker(SHIP ship) {
        super(ship);
        this.isCircleChoosen = false;
    }

    @Override
    public void setIsCircleChoosen(ImageView circleImage, boolean isCircleChoosen) {
        this.isCircleChoosen = isCircleChoosen;
        String imageToSet = this.isCircleChoosen ? getCircleChoosen() : getCircleNotChoosen();
        circleImage.setImage(new Image(imageToSet));
    }

    public boolean isIsCircleChoosen() {
        return isCircleChoosen;
    }

    public void setIsCircleChoosen(boolean isCircleChoosen) {
        this.isCircleChoosen = isCircleChoosen;
    }

}
