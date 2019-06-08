package processing;

import javafx.scene.image.ImageView;
import model.Life;

public class LifeLayout extends MeteorLayout {

    private ImageView life;
    private ImageView[] playerLife;
    private byte lifeCount;

    public LifeLayout(ImageView ship, String lifeURL) {
        super(ship);
        this.life = new Life();//polymorphism

        playerLife = new ImageView[3];
        for (int i = 0; i < playerLife.length; i++) {
            playerLife[i] = new Life(lifeURL); //polymorphism
            playerLife[i].setLayoutX(playerLife[i].getLayoutX() + (i * 50));
        }
        this.lifeCount = 2;
    }

    public void lifeCollide() {
        if (checkIfElementsCollide(life, getShip()) && lifeCount < 2) {
            setNewElementPosition(life);
            setNewElementRotate(life);
            playerLife[++this.lifeCount].setVisible(true);
        }
    }

    public boolean removeLife() {
        for (int i = 0; i < getMeteorList().length; i++) {
            if (checkIfElementsCollide(getMeteorList()[i], getShip())) {
                setNewElementPosition(getMeteorList()[i]);
                playerLife[lifeCount].setVisible(false);
                if (this.lifeCount-- == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void move() {
        if (life.getLayoutY() < 4000) {
            life.setLayoutY(life.getLayoutY() + 9);
        } else {
            setNewElementPosition(life);
            setNewElementRotate(life);
        }
    }

    public ImageView getLife() {
        return life;
    }

    public void setLife(ImageView life) {
        this.life = life;
    }

    public ImageView[] getPlayerLife() {
        return playerLife;
    }

    public void setPlayerLife(ImageView[] playerLife) {
        this.playerLife = playerLife;
    }

}
