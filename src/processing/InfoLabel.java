package processing;

import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;

public class InfoLabel extends TextOperation {

    private int index;
    private List<Character> characterList;

    public InfoLabel() {
        this.index = 0;
    }

    public InfoLabel(String point) {
        setPoint(point);
        this.index = 0;
    }

    public void scores(Label label) {
        List<Node> nodeList = readPointsOperation();
        Node[] scores = new Node[3];
        for (int i = 0; i < 3; i++) {
            index = 2;
            for (int j = 3; j < nodeList.size(); j++) {
                if (parseInt(nodeList.get(j).getPoint()) > parseInt(nodeList.get(index).getPoint())) {
                    index = j;
                }
            }
            scores[i] = new Node(nodeList.get(index).getPoint(), nodeList.get(index).getTime());
            nodeList.remove(index);
        }

        label.setText("");
        for (int i = 0; i < 3; i++) {
            label.setText(label.getText() + scores[i].getPoint());
            for (int j = 0; j < 21 - length(scores[i].getPoint()); j++) {
                label.setText(label.getText() + "-");
            }
            label.setText(label.getText() + ">   " + scores[i].getTime() + "\n");
        }
    }

    public int parseInt(String str) {
        int count = 0;
        int step = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                count += ((str.charAt(i) - 48) * step);
                step *= 10;
            }
        }
        return count;
    }

    public int length(String str) {
        int length = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                length++;
            }
        }
        return length;
    }

    public void help(Label label) {
        this.characterList = readHelpOperation();
        label.setText("");
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (labelSetTex(label) == characterList.size()) {
                    stop();
                }
            }
        };
        timer.start();
    }

    private int labelSetTex(Label label) {
        label.setText(label.getText() + this.characterList.get(index));
        return ++index;
    }

    public void points(Label pointsLabel) {
        List<Node> list = readPointsOperation();
        pointsLabel.setText("");
        for (int i = list.size() - 1; i > 1; i--) {
            if (list.size() - i == 14) {
                break;
            }
            pointsLabel.setText(pointsLabel.getText() + list.get(i).getPoint());
            for (int j = 0; j < 21 - length(list.get(i).getPoint()); j++) {
                pointsLabel.setText(pointsLabel.getText() + "-");
            }
            pointsLabel.setText(pointsLabel.getText() + ">   " + list.get(i).getTime());
        }
    }

}
