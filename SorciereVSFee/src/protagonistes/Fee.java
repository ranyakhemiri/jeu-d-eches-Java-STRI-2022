package protagonistes;

public class Fee extends Personnage{
	public String Symbole;
	public String TypeFort;
	public Fee(String nom,String Type) {
		super(20, nom);
	}
	public int attaque(String type_ennemi) {
		int degat = 0;
		if (type_ennemi == TypeFort) {
			degat = 10;
		}
		else {
			degat = 5;
		}
		return degat+getDegat();
	}
	
}