package processing;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public interface Game {

    public void setNewElementRotate(ImageView image);

    public void setNewElementPosition(ImageView image);

    public boolean checkIfElementsCollide(ImageView element, ImageView ship);

    public void moveBackground(GridPane gridPane1, GridPane gridPane2);

    public void createBackground(GridPane gridPane1, GridPane gridPane2);
}
