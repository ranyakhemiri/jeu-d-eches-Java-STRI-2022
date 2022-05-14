package Affrontement;

import Personnages.Fee;
import Personnages.Sorciere;

public class Batailles {
    public Camps campSorciere= new Camps();
    public Camps campFee= new Camps();

    public String rejoindreS(Sorciere witch){
        String texte="";   
        texte=witch.getNom()+" Rejoint un combat. \n";
        return texte;
    }
    public String rejoindreF(Fee fee){
        String texte="";   
        texte=fee.getNom()+" Rejoint un combat. \n";
        return texte;
    }

    public String massacrer(Sorciere witch, Fee f){
        String texte="";   
        campSorciere.supprimerCombattant(witch);
		if (campSorciere.nbCombattant() == 0 && campFee.nbCombattant() > 0) {
            f.nbPouvoirs=f.getNbPouvoirs()+1;
            texte="La sorciere "+ witch.getNom()+" a été éliminée \n"+"  la fée "+f.getNom()+" Gagne un nouveau pouvoir ";

        }
        return texte;
    }
    public String massacrer(Fee fee, Sorciere witch){
        String texte="";   
        campFee.supprimerCombattant(fee);
		if (campFee.nbCombattant() == 0 && campSorciere.nbCombattant() > 0) {
            witch.nbSortileges=witch.getNbSortileges()+1;
            System.out.println("La fee "+ fee.getNom()+" a été éliminée");
            texte="La fée "+ fee.getNom()+" a été éliminée \n"+"  la sorciere "+witch.getNom()+" Gagne un nouveau sortilege ";   
        }
        return texte;
    }
    public int donnerNombreSorcieres() {
		return campSorciere.nbCombattant();
	}
	public int donnerNombreFees() {
		return campFee.nbCombattant();
	}


    
}
