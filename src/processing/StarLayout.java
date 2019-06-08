package processing;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.PointsLabel;
import model.Star;

public class StarLayout extends SHIPLayout {

    private ImageView star;
    private Label pointsLabel;
    private int points;
    private String textToSet;

    public StarLayout(ImageView ship) {
        super(ship);
        this.star = new Star();//polymorphism
        this.pointsLabel = new PointsLabel();//polymorphism
        this.points = 0;
        textToSet = "";
    }

    public void setPoints() {
        if (checkIfElementsCollide(star, getShip())) {
            setNewElementPosition(star);
            points++;
            textToSet = "POINTS : ";
            if (points < 10) {
                textToSet += "0";
            }
            textToSet += points;
            pointsLabel.setText(textToSet);
        }
    }

    @Override
    public void move() {
        if (star.getLayoutY() < 1000) {
            star.setLayoutY(star.getLayoutY() + 7.7f);
        } else {
            setNewElementPosition(star);
            setNewElementRotate(star);
        }
    }

    public ImageView getStar() {
        return star;
    }

    public void setStar(ImageView star) {
        this.star = star;
    }

    public Label getPointsLabel() {
        return pointsLabel;
    }

    public void setPointsLabel(Label pointsLabel) {
        this.pointsLabel = pointsLabel;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getTextToSet() {
        return textToSet;
    }

    public void setTextToSet(String textToSet) {
        this.textToSet = textToSet;
    }

}
