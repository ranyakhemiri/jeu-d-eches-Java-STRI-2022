package Personnages;
import java.util.LinkedList;

import Map.Echec;
import Tresors.Tresor;

public abstract class Protagoniste {
    public int xp;
    public int yp;
    public int x;
    public int y;
    private boolean isnice;
    LinkedList<Protagoniste> ps;
    
    public String name;
    public int point_vie;
    private Tresor equipement;

   
 
    public Protagoniste (int xp, int yp, boolean isnice,String n, LinkedList<Protagoniste> ps) {
        this.xp = xp;
        this.yp = yp;
        x=xp*64;
        y=yp*64;
        this.isnice = isnice;
        this.ps=ps;
        name=n;
        ps.add(this);

    }
   public Protagoniste(String name){
        this.name=name;
   }
   public String getNom(){
        return this.name;
   }

   public abstract String subirAttaque (int nb_degats);

   public Tresor getEquipement() {
    return equipement;
    }

    public void equiper(Tresor tresor) {
    	this.equipement = tresor;
    }

    public void move(int xp,int yp){
        //ps.stream().filter((p) -> (p.xp==xp&&p.yp==yp)).forEachOrdered((p) -> {
           // p.kill();
        //});
        if(Echec.getProtagoniste(xp*64, yp*64)!=null){
            if(Echec.getProtagoniste(xp*64, yp*64).isnice!=isnice){
            Echec.getProtagoniste(xp*64, yp*64).kill();
        }
            else{
                x=this.xp*64;
                y=this.yp*64;
                return;
            }
        }
        this.xp=xp;
        this.yp=yp;
        x=xp*64;
        y=yp*64;
    }
    public void kill(){
        ps.remove(this);
    }
    

    public void sebattre(){}





}

