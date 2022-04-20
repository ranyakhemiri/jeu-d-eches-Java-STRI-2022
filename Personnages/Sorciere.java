package Personnages;

public class Sorciere extends EtreVivant{

    public Sorciere(String nom){
        super(nom);
        //les points de vie sont initialisés à 90pts 
        point_vie=90;
    }

    public String getNom (){
        return super.getNom();
    }

}
