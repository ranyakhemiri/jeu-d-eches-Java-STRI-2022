package Tresors;

public class Arme {
	private String nom;
	private int puissance;
	public Arme(String nom, int puissance) {
		super();
		this.nom = nom;
		this.puissance = puissance;
	}
	public String getNom() {
		return nom;
	}
	public int getPuissance() {
		return puissance;
	}
}
