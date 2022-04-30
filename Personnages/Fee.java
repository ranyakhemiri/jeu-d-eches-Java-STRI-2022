package Personnages;

public class Fee extends EtreVivant {
    private int baguette; //baguettes magiques, par défaut =1

    Fee(String nom){
        super(nom);
        this.baguette=1; //initialisation par defaut
        //les points de vie sont initialisés à 100pts 
        this.point_vie=100;
    }


    public int getNbBaguettes (){
        return this.baguette;
    }

	@Override
	public String subirAttaque(int nb_degats) {
		// TODO Auto-generated method stub
		return null;
	}
}
