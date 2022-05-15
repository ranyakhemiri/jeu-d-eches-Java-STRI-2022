package Tresors;

import java.util.Random;

import Personnages.Protagoniste;

public class Tresor {
    protected Protagoniste proprio;
    protected String nature ;
    //peut etre un sortilege pour les sorcieres ou un pouvoir magique pour les fees, ou bien une armure pour les deux
 

    public Tresor(String nature){
        //intialisation du tresor 
        this.nature=nature;
    }

    public void setProprio (Protagoniste e){
        //le trésor est attribué à un protagoniste
        this.proprio=e;
    }

    public Protagoniste getProprio(){
        //retourne le propriétaire de l'arme
        return this.proprio;
        //car cet attribut n'est visible que pour les classes filles ("protected")
    }

    public String getNature(){
        //renvoie la nature du trésor baguette magique ou sortilege
        return nature;
    }
    
    public Typetresor randtresor(){
        Typetresor t = Typetresor.values()[new Random().nextInt(Typetresor.values().length)];
        return t;
    }

}

