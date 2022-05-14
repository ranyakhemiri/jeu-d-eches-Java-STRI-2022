package Personnages;
import Tresors.Pouvoir;
import Tresors.Tresor;

public class Fee extends Protagoniste {
    private Pouvoir pouvoir; //baguettes magiques, par défaut =1
    public int nbPouvoirs;


    
   public Fee(String nom){
        super(nom);
        //les points de vie sont initialisés à 100pts 
        this.point_vie=100;
    }


    public int getNbPouvoirs (){
        return this.nbPouvoirs;
    }

	@Override
	public String subirAttaque(int nb_degats) {
		// TODO Auto-generated method stub
		return null;
	}


    @Override
    public void gagnerTresor(Tresor t) {
        // TODO Auto-generated method stub
        
    }

    


	

}
