import java.util.Arrays;
import java.util.NoSuchElementException;

public class EquipeGuerriers {

	private Guerrier[] tableGuerriers;
	private int nombreGuerriersEnVie;

	/**
	 * construit l'equipe 
	 * @param nombreGuerriers nombre de guerriers en vie au debut du jeu
	 * @param pointsDeVieDeDepart nombre de points de vie attribue a chaque guerrier au debut du jeu
	 * @throws IllegalArgumentException il faut au moins 1 guerrier vivant pour combattre la creature du mal
	 */
	public EquipeGuerriers(int nombreGuerriers, int pointsDeVieDeDepart){
		if(nombreGuerriers<=0||pointsDeVieDeDepart<=0) 
			throw new IllegalArgumentException("jeu impossible!");
		int numero = nombreGuerriers;
		tableGuerriers = new Guerrier[nombreGuerriers];
		nombreGuerriersEnVie = nombreGuerriers;
		for (int i = 0; i < nombreGuerriers; i++) {
			tableGuerriers[i] = new Guerrier(numero, pointsDeVieDeDepart);
			numero--;
		}
	}

	// Attention : seul interet de ce constructeur : les tests!!!
	// A NE PAS MODIFIER
	public EquipeGuerriers(Guerrier[] tableARecopier, int nombreGuerriersEnVie) {
		tableGuerriers = new Guerrier[tableARecopier.length];
		for (int i = 0; i < tableGuerriers.length; i++) {
			tableGuerriers[i]=tableARecopier[i];
		}
		this.nombreGuerriersEnVie = nombreGuerriersEnVie;
	}

	/**
	 * renvoie le nombre de guerriers encore en vie
	 * @return le nombre de guerriers encore en vie
	 */
	public int nombreGuerriersEnVie(){
		return nombreGuerriersEnVie;
	}


	/**
	 * renvoie le numero du guerrier qui doit combattre
	 * @return le numero du guerrier qui doit combattre
	 * @throws NoSuchElementException si tous les guerriers sont morts
	 */
	public int donnerNumeroProchainGuerrier() {
		if(nombreGuerriersEnVie==0)
			throw new NoSuchElementException();

		return tableGuerriers[nombreGuerriersEnVie-1].getNumero();
	}

	/**
	 * diminue le nombre de points de vie du guerrier qui doit combattre
	 * reorganise la table en tenant compte de ces nouveaux points de vie
	 * @param pointsDeViePerdus le nombre de points de vie perdu par le guerrier au combat
	 * @return les nouveaux points de vie du guerrier
	 * @throws NoSuchElementException si tous les guerriers sont morts
	 * @throws IllegalArgumentException si le nombre de points de vie perdus est negatif
	 */
	public int recevoirDegats(int pointsDeViePerdus){
		if(nombreGuerriersEnVie==0)
			throw new NoSuchElementException();
		if(pointsDeViePerdus<0)
			throw new IllegalArgumentException();

		int indiceJoueur=nombreGuerriersEnVie-1;
		Guerrier joueur= tableGuerriers[indiceJoueur];
		joueur.retirerPointsDeVie(pointsDeViePerdus);
		if(joueur.getPointsDeVie()>0){
			for (int i = indiceJoueur-1; i>=0; i--) {
				if(tableGuerriers[i].getPointsDeVie()>=joueur.getPointsDeVie()){
					Guerrier temp=tableGuerriers[i];
					tableGuerriers[i]= tableGuerriers[i+1];
					tableGuerriers[i+1]= temp;
				}
			}
		}else{
		nombreGuerriersEnVie--;
		}
		return joueur.getPointsDeVie();
	}

	/**
	 * construit une table avec les guerriers en vie
	 * La taille logique de cette table doit etre egale a la taille physique
	 * @return la table avec les guerriers en vie
	 */
	public Guerrier[] tableGuerriersEnVie(){
		Guerrier[] enVie= new Guerrier[nombreGuerriersEnVie];
		for (int i = 0; i < nombreGuerriersEnVie; i++) {
			enVie[i]=tableGuerriers[i];
		}
		return enVie;
	}

	/**
	 * construit une table avec les guerriers morts
	 * La taille logique de cette table doit etre egale a la taille physique
	 * @return la table avec les guerriers morts
	 */
	public Guerrier[] tableGuerriersMorts(){
		Guerrier[] morts= new Guerrier[tableGuerriers.length-nombreGuerriersEnVie];
		int indice=0;
		for (int i = nombreGuerriersEnVie; i <tableGuerriers.length ; i++) {
			morts[indice]=tableGuerriers[i];
			indice++;
		}
		return morts;
	}

	/**
	 * A NE PAS MODIFIER
	 * VA SERVIR POUR LES TESTS
	 * @return le contenu de la table des guerriers
	 */
	public String toString(){
		return Arrays.toString(tableGuerriers);
	}

}
