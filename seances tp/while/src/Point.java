public class Point {
    private double x;
    private double y;

    public Point(double X, double Y) {
        this.x = X;
        this.y = Y;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double X) {
        this.x = X;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double Y) {
        this.y = Y;
    }

    public String toString() {
        return "("+ this.x + "," + this.y + ")";
    }
}
