import java.util.Objects;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void print() {
        System.out.println("(" + x + "," + y + ")");
    }

    public boolean equals(Point otherPoint) {
        return otherPoint.x == this.x && otherPoint.y == this.y;
    }

    public double distance(Point otherPoint) {
        int dx = x - otherPoint.getX(); // Can also be this.x - otherPoint.x
        int dy = y - otherPoint.getY(); // Can also be this.y - otherPoint.y
        return Math.sqrt(dx * dx + dy * dy);
    }
}

