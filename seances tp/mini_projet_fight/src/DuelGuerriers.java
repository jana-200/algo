import java.sql.SQLOutput;

public class DuelGuerriers {

	public static void main(String[] args) {

		int pointsDeVieCogneDur = lancerDe();
		System.out.println("CogneDur a "+pointsDeVieCogneDur+" points de vie");

		int pointsDeVieFrappeFort = lancerDe();
		System.out.println("FrappeFort a " +pointsDeVieFrappeFort+ " points de vie" );

		int forceCogneDur = lancerDe();
		System.out.println("CogneDur inflige " + forceCogneDur+ " points de degats a FrappeFort.");

		if (forceCogneDur>pointsDeVieFrappeFort) {
			System.out.println("FrappeFort est mort. Paix a son ame, il est mort en brave.");
			System.out.println("CogneDur remporte une coupe en or.");
		}
		else {
			System.out.println("FrappeFort a " + (pointsDeVieFrappeFort - forceCogneDur) + " points de vie");
			int forceFrappeFort = lancerDe();
			System.out.println("FrappeFort inflige " + forceFrappeFort + " points de degats a CogneDur.");
			if(forceFrappeFort>pointsDeVieCogneDur) {
				System.out.println("CogneDur est mort. Paix a son ame, il est mort en brave.");
				System.out.println("FrappeFort remporte une coupe en or.");
			}
			else {
				System.out.println("CogneDur a " + (pointsDeVieCogneDur - forceFrappeFort) + " points de vie");
				if (pointsDeVieCogneDur == pointsDeVieFrappeFort) {
					System.out.println("CogneDur remporte une coupe en or.");
					System.out.println("FrappeFort remporte une coupe en or.");
				}
				else
					if (pointsDeVieCogneDur < pointsDeVieFrappeFort) {
						System.out.println("CogneDur remporte une coupe en or.");
						System.out.println("FrappeFort remporte une coupe en argent.");
					}
					else {
						System.out.println("FrappeFort remporte une coupe en or.");
						System.out.println("CogneDur remporte une coupe en argent.");
					}
			}
		}
	}

	public static int lancerDe(){
		return (int)((Math.random() * 6) + 1);
	}
}
