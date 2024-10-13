public class CercleDansLePlan {
    private double rayon;
    private Point centre;

    public CercleDansLePlan(double Rayon, Point Centre) {
        this.rayon = Rayon;
        this.centre = Centre;
    }

    public double getRayon() {
        return this.rayon;
    }

    public void setRayon(double Rayon) {
        this.rayon = Rayon;
    }

    public Point getCentre() {
        return this.centre;
    }

    public void setCentre(Point Centre) {
        this.centre = Centre;
    }

    public String toString() {
        return "Cercle de rayon : " + this.rayon + " de centre " + this.centre;
    }
}
