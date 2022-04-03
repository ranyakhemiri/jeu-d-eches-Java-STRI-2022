package Personnages;

public class EtreVivant {
    protected String nom;
    
    EtreVivant (String n){
        this.nom=n;
    }

    public String getNom() {
        return this.nom;
    }
}
