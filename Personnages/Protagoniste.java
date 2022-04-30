package Personnages;
import java.util.LinkedList;

import Map.Echec;

public class Protagoniste {
    public int xp;
    public int yp;
    public int x;
    public int y;
    private boolean isnice;
    LinkedList<Protagoniste> ps;
    public String name;
   
 
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
   
    public void move(int xp,int yp){
        //ps.stream().filter((p) -> (p.xp==xp&&p.yp==yp)).forEachOrdered((p) -> {
           // p.kill();
        //});
        if(Echec.getPiece(xp*64, yp*64)!=null){
            if(Echec.getPiece(xp*64, yp*64).isnice!=isnice){
            Echec.getPiece(xp*64, yp*64).kill();
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
}

