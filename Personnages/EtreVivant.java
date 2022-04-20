package Personnages;

public abstract class EtreVivant {
    protected String nom;
    public int point_vie;
    
    EtreVivant (String n){
        this.nom=n;
    }

    public String getNom() {
        return this.nom;
        //car c'est un attribut "protected"
    }

    //méthode abstraite: on oblige les classes Sorcieres et Fee à coder cette méthode qui est differente selon l'etre vivant
    public abstract String subirAttaque (int nb_degats);
}
