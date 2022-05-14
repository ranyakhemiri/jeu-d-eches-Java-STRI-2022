package Personnages;
import Tresors.Sortilege;

public class Sorciere extends Protagoniste{
	private Sortilege sortilege;
	
    public Sorciere(String nom){
        super(nom);
        //les points de vie sont initialisés à 90pts 
        point_vie=90;
    }


	@Override
	public String subirAttaque(int nb_degats) {
		// TODO Auto-generated method stub
		return null;
	}

}
