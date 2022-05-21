package protagonistes;
import tresors.*;

public class Personnage {
	private int vie;
	private String nom;
	private String Symbole;
	private String Type;
	private int degat;
	public Personnage(int vie, String nom) {
		this.vie = vie;
		this.nom = nom;
		this.degat = 0;
	}
	
	public String mourir() {
		return this.nom+" die !";
	}

	public int getVie() {
		return vie;
	}
	
	public int getDegat() {
		return degat;
	}

	public int subir_degat(int degat) {
		if (degat > this.vie){
			this.vie = 0;
		}
		else this.vie -= degat;
		return this.vie;
	}

	public String getSymbole() {
		return Symbole;
	}
	public String getType() {
		return Type;
	}
	public String getNom() {
		return nom;
	}
	public int attaque(String type) {
		return 0;
	}
	public void equiper(Arme arme) {
		this.degat += 10;
	}
	public void equiper(Armure armure) {
		this.vie += 10;
	}
	public void equiper(Sortilege sortilege) {
		this.degat += 15;
	}
}
