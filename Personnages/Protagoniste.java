package Personnages;
import java.util.LinkedList;

import Affrontement.Batailles;
import Map.Echec;
import Tresors.Tresor;
import Tresors.Typetresorr;

public abstract class Protagoniste {
   
    public int xp;
    public int yp;
    public int x;
    public int y;
    protected  String nom;
    protected int point_vie;
    private Tresor equipement;
    protected Batailles bataille;


    public Protagoniste(String nom, int point_vie){
        this.nom=nom;
        this.point_vie=point_vie;
    }

   

//    public Protagoniste (int xp, int yp, boolean isnice,String n, LinkedList<Protagoniste> ps) {
//         this.xp = xp;
//         this.yp = yp;
//         x=xp*64;
//         y=yp*64;
//         this.isnice = isnice;
//         this.ps=ps;
//         name=n;
//         ps.add(this);

//     }
    //  public Protagoniste(String nom){
    //     Protagoniste.nom=nom;
    //  }
   
   public String getNom(){
        return nom;
   }
   public int getPointsv(){
       return point_vie;
   }

//    public String subirAttaque (int nb_degats){
//        String texte=" ";
//        texte=this.nom+" est attaqué!";
//        this.point_vie-=1+nb_degats;
//        if(this.point_vie>0){
//            texte+=this.nom+ "est malmenée mais resiste encore\n";
//        }
//        else{
//            texte+=" Les degats sont trop gros!\n";
//            texte+=this.die();
//        }
//        return texte;
//    }
    public String rejointBataille(Batailles bataille){
        return "";
    } 
   public abstract String gagnerTresor();
//    public abstract String attaquer();
   public abstract String die();
   public abstract String win();

   public Tresor getEquipement() {
    return equipement;
    }

    public void equiper(Tresor tresor) {
    	this.equipement = tresor;
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
    //     ps.remove(this);
    // }
    






}

