package Affrontement;

import Personnages.Fee;
import Personnages.Sorciere;

public class Batailles {
    public Camps campSorciere= new Camps();
    public Camps campFee= new Camps();

    public void rejoindreS(Sorciere witch){
        System.out.println(witch.getNom()+" Rejoint un combat. \n");
    }
    public void rejoindreF(Fee fee){
        System.out.println(fee.getNom()+" Rejoint un combat. \n");
    }

    public void massacrer(Sorciere witch){
        String texte=" ";
        campSorciere.supprimerCombattant(witch);
		if (campSorciere.nbCompagnon() == 0 && campHomme.nbCompagnon() > 0) {
			texte = "Les Hommes ont conquis la lande, leurs villages n'auront plus jamais à trembler devant les dragons.\n";
		}
		return texte;

    }
    
}
