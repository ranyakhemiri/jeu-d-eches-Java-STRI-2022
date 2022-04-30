package Tresors;

import Personnages.Fee;
import Personnages.Sorciere;

public class Sortilege extends Tresor{
    //pour imposer le type du propriétaire
        protected Sorciere proprio;
        public int degats;

    public Sortilege(){
        super("sortilege");
        this.degats=1;
    }

    public String attaque (Fee f){
        String texte="";
        texte= this.proprio.getNom()+" attaque la fée "+f.getNom()+" avec son sortilège.";
        texte += f.subirAttaque (this.degats);
        return texte;
    }
}
