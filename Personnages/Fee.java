package Personnages;
import Tresors.Baguette;

public class Fee extends EtreVivant {
    private Baguette baguette; //baguettes magiques, par défaut =1
    private int nbBaguettes;
    
    Fee(String nom){
        super(nom);
        //les points de vie sont initialisés à 100pts 
        this.point_vie=100;
    }


    public int getNbBaguettes (){
        return this.nbBaguettes;
    }

	@Override
	public String subirAttaque(int nb_degats) {
		// TODO Auto-generated method stub
		return null;
	}
}
