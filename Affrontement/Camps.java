package Affrontement;

import java.util.ArrayList;
import java.util.List;

import Personnages.Fee;
import Personnages.Sorciere;

public class Camps {
    private List<Sorciere> witch= new ArrayList<>();
	private List<Fee> fee= new ArrayList<>();



    public void ajouterS(Sorciere w) {
		witch.add(w);
	}
	public void ajouterF(Fee f) {
		fee.add(f);
	}

	public void supprimerS(Sorciere w) {
		witch.remove(w);
	}
	public void supprimerF(Fee f) {
		fee.remove(f);
	}

	public int nbSorcieres() {
		return witch.size();
	}

	public int nbFees() {
		return fee.size();
	}

    
    }
    

