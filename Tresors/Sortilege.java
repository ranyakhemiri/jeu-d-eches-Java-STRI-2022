package Tresors;

import Personnages.Fee;
import Personnages.Sorciere;

public class Sortilege extends Tresor{
    //pour imposer le type du propriétaire
        protected Sorciere proprio;

    public Sortilege(){
        super("sortilege",30);
        //le sortilege diminue de 30pts la vie d'une fée attaquée
    }

    public String attaque (Fee f){
        String texte="";
        texte= this.proprio.getNom()+" attaque la fée "+f.getNom()+" avec son sortilège.";
        texte += f.subirAttaque (this.degats);
        return texte;
    }
}