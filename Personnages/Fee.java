package Personnages;
import java.util.LinkedList;

import Tresors.Pouvoir;
import Tresors.Tresor;
import Tresors.Typetresorr;

public class Fee extends Protagoniste {
    private Pouvoir pouvoir; //baguettes magiques, par défaut =1
    public int nbPouvoirs;
	public int nbArmure=0;
    public int ptprotec;

    LinkedList<Fee> f;
    public int xp;
    public int yp;
    public int x;
    public int y;
    protected boolean isnice;


    // public Fee (int xp, int yp, boolean isnice,String n, LinkedList<Fee> f) {
    //     super(nom);
    //     this.xp = xp;
    //     this.yp = yp;
    //     x=xp*64;
    //     y=yp*64;
    //     this.isnice = isnice;
    //     nom=n;
    //     this.f=f;
    //     f.add(this);

    // } 
   public Fee(String nom){
        super(nom, 30);
        this.nbPouvoirs=1;
        this.ptprotec=0;
        this.nbArmure=0;

    }


    public int getNbPouvoirs (){
        return this.nbPouvoirs;
    }
    public int getNbArmures (){
        return this.nbArmure;
    }
    public int getNbptprotec (){
        return this.nbArmure;
    }

	// @Override
	public String subirAttaque(Sorciere w, int nb_degats) {
		String texte=" ";
		texte+="La Fee "+this.getNom()+" est attaquée";

		if(nbArmure!=0){
			if(ptprotec>nb_degats){
				ptprotec-=nb_degats;
				texte+=", Heureusement que son armure la protege \n";
			}
			else{
				point_vie-=(nb_degats-ptprotec);
			}
		}
		else{
			if(point_vie> nb_degats){
				texte+="Aie \n";
				point_vie-=nb_degats;
			}
			else{
				this.die();
                w.win();
			}
		}
			return texte;
		}


    @Override
    public String gagnerTresor() {
        String texte=" ";
        Typetresorr t=Typetresorr.generateRandomTresor();
        
        if(t==Typetresorr.ARMURE){
        texte+="La fee "+ getNom()+" Obtient une armure";
        ptprotec+=10;
        nbArmure+=1;
        }
        else if(t==Typetresorr.POUVOIR){
            texte+="La fee "+ getNom()+" Obtient unn nouveau pouvoir";
            nbPouvoirs+=1;
        }
        else {
            gagnerTresor();
        }
        return texte;  
    }


    // @Override
    public String attaquerS(Sorciere w,int nb_degats) {
		String texte=" ";
		texte+="La sorciere "+getNom()+" attaque la fee présente sur la case";
		w.subirAttaque( this, 10);
		return texte;
    }
    @Override
    public String die(){
		String texte=" ";
		texte+=this.getNom()+" n'a pas survécu \n";
		//il faut remove ici
		return texte;
		}


    @Override
    public String win() {
		String msg=" ";
		this.gagnerTresor();
		this.regeneration();
		msg+="La fée "+ this.getNom()+ " remporte le duel \n";
		return msg;
	}

	public String regeneration(){
		String texte=" ";
		if(point_vie<20){
			point_vie=20;
			texte+="La fée "+this.getNom()+" a récupéré ses points de vie \n";
		}
		else{
			texte+="La fée "+this.getNom()+" a deja tous ses points de vie \n";
		}
		return texte;
	}
    


	

}
