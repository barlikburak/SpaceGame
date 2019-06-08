package model;

public class ButtonImage {

    private final String BUTTON_PRESSED_STYLE;
    private final String BUTTON_RELEASED_STYLE;

    public ButtonImage() {
        BUTTON_PRESSED_STYLE = "-fx-background-image: url('/model/resources/button_pressed.png');";
        BUTTON_RELEASED_STYLE = "-fx-background-image: url('/model/resources/button.png');";
    }

    public String getBUTTON_PRESSED_STYLE() {
        return BUTTON_PRESSED_STYLE;
    }

    public String getBUTTON_RELEASED_STYLE() {
        return BUTTON_RELEASED_STYLE;
    }

}
