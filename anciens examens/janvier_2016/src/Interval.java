
public class Interval {

	int debut, fin;

	public int getDebut() {
		return debut;
	}

	public void setDebut(int debut) {
		this.debut = debut;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public Interval(int debut, int fin) {
		super();
		this.debut = debut;
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "Interval [debut=" + debut + ", fin=" + fin + "]";
	}
	
}
