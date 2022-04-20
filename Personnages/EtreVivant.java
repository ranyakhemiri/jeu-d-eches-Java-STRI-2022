package Personnages;
import Tresors.Tresor;

public abstract class EtreVivant {
    protected String nom;
    public int point_vie;
    private Tresor equipement;
    
    public EtreVivant(String nom) {
		this.nom = nom;
	}
    /* getters */
    public String getNom() {
        return this.nom;
        //car c'est un attribut "protected"
    }

    //méthode abstraite: on oblige les classes Sorcieres et Fee à coder cette méthode qui est differente selon l'etre vivant
    public abstract String subirAttaque (int nb_degats);

    //obtenir l'equipement de l'etre vivant 
	public Tresor getEquipement() {
		return equipement;
	}
	
    //obtenir une nouvelle arme
    public void equiper(Tresor tresor) {
    	this.equipement = tresor;
    }
    
    public void combat(EtreVivant ennemi) {
    	
    }

}
