package Personnages;

public class Fee extends EtreVivant {
    public String pouvoir;

    Fee(String nom, String pouvoir){
        super(nom);
        this.pouvoir=pouvoir;
    }

    public String getNom (){
        return super.getNom();
    }
}
