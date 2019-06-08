package processing;

import javafx.scene.image.ImageView;
import model.SlowingPanel;

public class SlowingPanelLayout extends SHIPLayout {

    private ImageView slowingPanel;

    public SlowingPanelLayout(ImageView ship) {
        super(ship);
        this.slowingPanel = new SlowingPanel();//polymorphism
    }

    public void movePanel() {
        if (slowingPanel.getLayoutY() > 800) {
            setNewElementPosition(slowingPanel);
        }
        if (slowingPanel.getLayoutY() + slowingPanel.getFitHeight() >= 0) {
            slowingPanel.setLayoutY(slowingPanel.getLayoutY() + 0.5f);
            if (checkIfElementsCollide(slowingPanel, getShip())
                    && slowingPanel.getLayoutY() < getShip().getLayoutY() + getShip().getFitHeight()) {
                setRotateIncrease(3);
                setLayoutXIncrease(1);
            } else {
                setRotateIncrease(5);
                setLayoutXIncrease(3);
            }
        } else {
            slowingPanel.setLayoutY(slowingPanel.getLayoutY() + 2);
            setRotateIncrease(5);
            setLayoutXIncrease(3);
        }

    }

    public ImageView getSlowingPanel() {
        return slowingPanel;
    }

    public void setSlowingPanel(ImageView slowingPanel) {
        this.slowingPanel = slowingPanel;
    }

}
