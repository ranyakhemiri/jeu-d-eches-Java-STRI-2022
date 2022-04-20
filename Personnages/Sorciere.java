package Personnages;

public class Sorciere extends EtreVivant{

    public Sorciere(String nom){
<<<<<<< Updated upstream
        super(nom);
        //les points de vie sont initialisés à 90pts 
        point_vie=90;
=======
        super(nom,100,null);
>>>>>>> Stashed changes
    }

    public String getNom (){
        return super.getNom();
    }

}
