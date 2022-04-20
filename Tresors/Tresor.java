package Tresors;

<<<<<<< Updated upstream
import Personnages.EtreVivant;

public class Tresor {
    protected EtreVivant proprio;
    protected String nature;
    //peut être un sortilege pour les sorcières ou une baguette magique pour les fées
    protected int degats; 
    //varient selon la nature du trésor

    public Tresor(String nature, int degats){
        //intialisation du trésor 
        this.nature=nature;
        this.degats=degats;
    }

    public void setProprio (EtreVivant e){
        //le trésor est attribué à un protagoniste
        this.proprio=e;
    }

    public EtreVivant getProprio(){
        //retourne le propriétaire de l'arme
        return this.proprio;
        //car cet attribut n'est visible que pour les classes filles ("protected")
    }

    public String getNature(){
        //renvoie la nature du trésor baguette magique ou sortilege
        return this.nature;
    }

=======
public enum Tresor {
	Arme,Armure,Sortilege;
>>>>>>> Stashed changes
}
