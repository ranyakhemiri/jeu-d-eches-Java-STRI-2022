package Tresors;

public class Armure{
    private String nom;
	private int protection;
	public Armure(String nom, int protection) {
		super();
		this.nom = nom;
		this.protection = protection;
	}
	public String getNom() {
		return nom;
	}
	public int getProtection() {
		return protection;
	}
	
}
