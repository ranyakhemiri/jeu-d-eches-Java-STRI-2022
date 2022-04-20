package Tresors;

import Personnages.Sorciere;

public class Baguette extends Tresor{
    protected Sorciere proprio;

    public Baguette(){
        super("baguette",40);
        //la baguette magique diminue de 40pts la vie d'une sorcière attaquée
    }
    public String attaque (Sorciere s){
        String texte='';
        texte= this.proprio.getNom()+" attaque la la sorcière "+s.getNom()+" avec sa baguette magique."
        texte += s.subirAttaque (this.degats);
        return texte;
    }
}
