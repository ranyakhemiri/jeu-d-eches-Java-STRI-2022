package Personnages;
import Tresors.Tresor;

public abstract class EtreVivant {
    protected String nom;
<<<<<<< Updated upstream
    public int point_vie;
=======
    private int vie;
    private Tresor equipement;
>>>>>>> Stashed changes
    
    public EtreVivant(String nom, int vie, Tresor equipement) {
		super();
		this.nom = nom;
		this.vie = vie;
		this.equipement = equipement;
	}
    /* getters */
    public String getNom() {
        return this.nom;
        //car c'est un attribut "protected"
    }
<<<<<<< Updated upstream

    //méthode abstraite: on oblige les classes Sorcieres et Fee à coder cette méthode qui est differente selon l'etre vivant
    public abstract String subirAttaque (int nb_degats);
=======
	public Tresor getEquipement() {
		return equipement;
	}
	
    public void equiper(Tresor tresor) {
    	this.equipement = tresor;
    }


    
    public void combat(EtreVivant ennemi) {
    	
    }
>>>>>>> Stashed changes
}
