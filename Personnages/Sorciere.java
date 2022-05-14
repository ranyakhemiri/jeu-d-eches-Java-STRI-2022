package Personnages;
import Tresors.Sortilege;
import Tresors.Tresor;

public class Sorciere extends Protagoniste{
	private Sortilege sortilege;
	public int nbSortileges;
	public int nbArmure=0;


    public Sorciere(String nom){
        super(nom);
        //les points de vie sont initialisés à 90pts 
        point_vie=90;
		this.nbArmure=0;
    }


	@Override
	public String subirAttaque(int nb_degats) {
		if(nbArmure!=0){
			
		}
		point_vie=;
		return null;
	}
	public int getNbSortileges(){
        return this.nbSortileges;
    }


	@Override
	public void gagnerTresor(Tresor t) {
		// TODO Auto-generated method stub
		
	}

}
