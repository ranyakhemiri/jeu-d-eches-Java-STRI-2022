package Tresors;

import Personnages.EtreVivant;

public class Tresor {
    protected EtreVivant proprio;
    protected String nature;
    //peut etre un sortilege pour les sorcieres ou une baguette magique pour les fees, ou bien une armure pour les deux
 

    public Tresor(String nature){
        //intialisation du tresor 
        this.nature=nature;
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
}

