package Personnages;
import java.util.LinkedList;

import Affrontement.Batailles;
import Affrontement.Camps;
import Map.Echec;
import Tresors.Sortilege;
import Tresors.Tresor;
import Tresors.Typetresorr;

public class Sorciere extends Protagoniste{
	LinkedList<Sorciere> w;
    public int xp;
    public int yp;
    public int x;
    public int y;
    protected boolean isnice;
	
	
	private Sortilege sortilege;
	public int nbSortileges;
	public int nbArmure=0;
    public int ptprotec;


    public Sorciere(String nom){
        super(nom, 20);
		this.nbSortileges=1;
		this.nbArmure=0;

    }
	// public Sorciere (int xp, int yp, boolean isnice,String n, LinkedList<Sorciere> w) {
    //     super(nom);	
	// 	x=xp*64;
    //     y=yp*64;
    //     ps.add(this);
// }

	
	public int getNbSortileges(){
        return this.nbSortileges;
    }
	public int getNbArmures (){
        return this.nbArmure;
    }
	public int getNbptprotec (){
        return this.nbArmure;
    }



	

	@Override
	public String gagnerTresor() {
		String texte=" ";
        Typetresorr t=Typetresorr.generateRandomTresor();
        
        if(t==Typetresorr.ARMURE){
        texte+="La Sorciere "+ getNom()+" Obtient une armure";
        ptprotec+=10;
        nbArmure+=1;
        }
        else if(t==Typetresorr.SORTILEGE){
            texte+="La Sorciere "+ getNom()+" Obtient unn nouveau pouvoir";
            nbSortileges+=1;
        }
        else {
            gagnerTresor();
        }
        return texte;  
    }
	public String rejointBataille(Batailles bataille){
        this.bataille = bataille;
        return bataille.rejoindreS(this);
    }


	// @Override
	public String attaquerF(Fee f,int nb_degats) {
		String texte=" ";
		texte+="La sorciere "+getNom()+" attaque la fee présente sur la case";
		this.rejointBataille(bataille);
	    f.subirAttaque( this, 10  );
		return texte;
		}



	// @Override
	public String subirAttaque(Fee f,int nb_degats) {
		String texte=" ";
		texte+="La sorciere "+this.getNom()+" est attaquée";

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
				f.win();	
			}
		}
			return texte;
		}



	@Override
	public String die() {
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
		msg+="La sorciere "+ this.getNom()+ " remporte le duel \n";
		return msg;
	}

	public String regeneration(){
		String texte=" ";
		if(point_vie<20){
			point_vie=20;
			texte+="La sorciere "+this.getNom()+" a récupéré ses points de vie \n";
		}
		else{
			texte+="La sorciere "+this.getNom()+" a deja tous ses points de vie \n";
		}
		return texte;
	}
		// public void move(int xp,int yp){
    //     //ps.stream().filter((p) -> (p.xp==xp&&p.yp==yp)).forEachOrdered((p) -> {
    //        // p.kill();
    //     //});
    //     if(Echec.getProtagoniste(xp*64, yp*64)!=null){
    //         if(Echec.getProtagoniste(xp*64, yp*64).isnice!=isnice){
    //         Echec.getProtagoniste(xp*64, yp*64).kill();
    //     }
    //         else{
    //             x=this.xp*64;
    //             y=this.yp*64;
    //             return;
    //         }
    //     }
    //     this.xp=xp;
    //     this.yp=yp;
    //     x=xp*64;
    //     y=yp*64;
    // }
    // public void kill(){
    //     w.remove(this);
    // }
}
