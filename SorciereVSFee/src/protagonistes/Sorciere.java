package protagonistes;

public class Sorciere extends Personnage{
	public String Symbole;
	public String TypeFort;
	public Sorciere(String nom,String Type) {
		super(10, nom);
	}
	public int attaque(String type_ennemi) {
		int degat = 0;
		if (type_ennemi == TypeFort) {
			degat = 20;
		}
		else {
			degat = 8;
		}
		return degat+getDegat();
	}
}
