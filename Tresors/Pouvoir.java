package Tresors;

import Personnages.*;

public class Pouvoir extends Tresor{
    protected Fee proprio;
    public int degats;

    public Pouvoir(){
        super("Enchantix");
        this.degats=2;
    }

   
    }

    public String attaque (Sorciere witch){
        
        String texte="";
        texte= this.proprio.getNom()+" attaque la sorciere "+witch.getNom()+" avec son pouvoir magique.";
        texte += witch.subirAttaque (this.degats);
        return texte;
    }
}
