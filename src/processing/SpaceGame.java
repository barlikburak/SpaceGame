package processing;

import java.util.Random;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class SpaceGame implements Game {

    private final String BACKGROUND_IMAGE;
    private final Random random;

    public SpaceGame() {
        this.BACKGROUND_IMAGE = "/view/resources/background.png";
        this.random = new Random();
    }

    @Override
    public void createBackground(GridPane gridPane1, GridPane gridPane2) {
        for (int i = 0; i < 12; i++) {
            ImageView backgroundImage1 = new ImageView(BACKGROUND_IMAGE);
            ImageView backgroundImage2 = new ImageView(BACKGROUND_IMAGE);
            GridPane.setConstraints(backgroundImage1, i % 3, i / 3);
            GridPane.setConstraints(backgroundImage2, i % 3, i / 3);
            gridPane1.getChildren().add(backgroundImage1);
            gridPane2.getChildren().add(backgroundImage2);
        }
    }

    @Override
    public void moveBackground(GridPane gridPane1, GridPane gridPane2) {
        gridPane1.setLayoutY(gridPane1.getLayoutY() + 1);
        gridPane2.setLayoutY(gridPane2.getLayoutY() + 1);

        if (gridPane1.getLayoutY() >= 800) {
            gridPane1.setLayoutY(-800);
        }
        if (gridPane2.getLayoutY() >= 800) {
            gridPane2.setLayoutY(-800);
        }
    }

    @Override
    public boolean checkIfElementsCollide(ImageView element, ImageView ship) {
        return element.getLayoutY() + element.getFitHeight() > ship.getLayoutY()
                && ship.getLayoutX() + ship.getFitWidth() >= element.getLayoutX()
                && ship.getLayoutX() <= element.getLayoutX() + element.getFitWidth();
    }

    @Override
    public void setNewElementPosition(ImageView image) {
        image.setLayoutX(random.nextInt(400));
        image.setLayoutY(-(random.nextInt(1000) + 200));
    }

    @Override
    public void setNewElementRotate(ImageView image) {
        image.setRotate(random.nextInt(360));
    }

}
