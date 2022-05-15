package Affrontement;

import Personnages.Fee;
import Personnages.Sorciere;

public class Batailles {
    public Camps campSorciere= new Camps();
    public Camps campFee= new Camps();

    public String rejoindreS(Sorciere witch){
        String texte="";   
        texte=witch.getNom()+" Rejoint un combat. \n";
        campSorciere.ajouterS(witch);
        return texte;
    }
    public String rejoindreF(Fee fee){
        String texte="";   
        texte=fee.getNom()+" Rejoint un combat. \n";
        campFee.ajouterF(fee);
        return texte;
    }

    public String massacrerS(Sorciere witch){
        String texte="";   
        campSorciere.supprimerS(witch);
		if (campSorciere.nbSorcieres() == 0 && campFee.nbFees() > 0) {
            texte="La sorciere "+ witch.getNom()+" a été éliminée \n";
            
        }
        return texte;
    }
    public String massacrerF(Fee fee, Sorciere witch){
        String texte="";   
        campFee.supprimerF(fee);
		if (campFee.nbFees() == 0 && campSorciere.nbSorcieres() > 0) {
            witch.gagnerTresor();
            texte="La fée "+ fee.getNom()+" a été éliminée \n"+"  la sorciere "+witch.getNom()+" Gagne un nouveau sortilege ";   
        }
        return texte;
    }
    public int donnerNombreSorcieres() {
		return campSorciere.nbSorcieres();
	}
	public int donnerNombreFees() {
		return campFee.nbFees();
	}


    
}
