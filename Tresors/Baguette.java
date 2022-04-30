package Tresors;

import Personnages.Fee;

public class Baguette extends Tresor{
    protected Fee proprio;
    public int degats;

    public Baguette(){
        super("baguette");
        this.degats=2;
    }


    public String attaque (Fee s){
        String texte="";
        texte= this.proprio.getNom()+" attaque la sorciere "+s.getNom()+" avec sa baguette magique.";
        texte += s.subirAttaque (this.degats);
        return texte;
    }
}
