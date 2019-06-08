package processing;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import model.ButtonImage;

public class ButtonStyle extends ButtonImage {

    public void setOnMouseReleased(Button button) {
        button.setStyle(getBUTTON_RELEASED_STYLE());
        button.setPrefHeight(49);
        button.setLayoutY(button.getLayoutY() - 4);
    }

    public void setOnMousePressed(Button button) {
        button.setStyle(getBUTTON_PRESSED_STYLE());
        button.setPrefHeight(45);
        button.setLayoutY(button.getLayoutY() + 4);
    }

    public void setOnMouseEntered(Button button) {
        button.setEffect(new DropShadow());
    }

    public void setOnMouseExited(Button button) {
        button.setEffect(null);
    }
}
