package Affrontement;

import java.util.ArrayList;
import java.util.List;

import Personnages.Protagoniste;

public class Camps {
    private List<Protagoniste> combattants= new ArrayList<>();

    public void ajouterProtagoniste(Protagoniste combattant) {
		combattants.add(combattant);
	}

	public void supprimerCombattant(Protagoniste combattant) {
		combattants.remove(combattant);
	}

	public int nbCombattant() {
		return combattants.size();
	}
    
}
