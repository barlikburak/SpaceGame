package processing;

public class Node {

    private String point;
    private String time;

    public Node() {
    }

    public Node(String point, String time) {
        this.point = point;
        this.time = time;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
