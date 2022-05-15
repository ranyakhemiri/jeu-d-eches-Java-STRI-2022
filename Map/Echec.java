package Map;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Personnages.*;

/**
 *
 * @author yaicicelina
 */
public class Echec {
    public static LinkedList<Protagoniste> ps=new LinkedList<>();
    public static Protagoniste selectedPiece=null;
    
    public static void main(String[] args)throws IOException {
        BufferedImage all=ImageIO.read(new File("/home/yaicicelina/Téléchargements/winxxx (1).png"));
        Image imgs[]=new Image[12];
       int ind=0;
        for(int y=0;y<400;y+=200){
        for(int x=0;x<1200;x+=200){
            imgs[ind]=all.getSubimage(x, y, 200, 200).getScaledInstance(62, 62, BufferedImage.SCALE_SMOOTH);
       ind++;
        }    
        }
        
        
        /*------------pieces-------------*/
        Fee bloom=new Fee(0, 0, false, "Bloom", ps);
        Fee flora=new Fee(1, 0, false, "Flora", ps);
        Fee tecna=new Fee(2, 0, false, "Tecna", ps);
        Fee musa=new Fee(3, 0, false, "Musa", ps);
        Fee layla=new Fee(4, 0, false, "Layla", ps);
        Fee tecnaa=new Fee(5, 0, false, "Tecna", ps);
        Fee floraa=new Fee(6, 0, false, "Flora", ps);
        Fee bloomm=new Fee(7, 0, false, "Bloom", ps);
        
        Fee stella=new Fee(1, 1, false, "Stella", ps);
        Fee stella2=new Fee(2, 1, false, "Stella", ps);
        Fee stella3=new Fee(3, 1, false, "Stella", ps);
        Fee stella4=new Fee(4, 1, false, "Stella", ps);
        Fee stella5=new Fee(5, 1, false, "Stella", ps);
        Fee stella6=new Fee(6, 1, false, "Stella", ps);
        Fee stella7=new Fee(7, 1, false, "Stella", ps);
        Fee stella8=new Fee(0, 1, false, "Stella", ps);
        
        Sorciere icy=new Sorciere(0, 7, true, "Icy", ps);
        Sorciere darcy=new Sorciere(1, 7, true, "Darcy", ps);
        Sorciere strormy=new Sorciere(2, 7, true, "Stormy", ps);
        Sorciere belladone=new Sorciere(3, 7, true, "Belladone", ps);
        Sorciere lysliss=new Sorciere(4, 7, true, "Lysliss", ps);
        Sorciere stormyy=new Sorciere(5, 7, true, "Stormy", ps);
        Sorciere darcyy=new Sorciere(6, 7, true, "Darcy", ps);
        Sorciere icyy=new Sorciere(7, 7, true, "Icy", ps);
        
        Sorciere tharma=new Sorciere(1, 6, true, "Tharma", ps);
        Sorciere tharma2=new Sorciere(2, 6, true, "Tharma", ps);
        Sorciere tharma3=new Sorciere(3, 6, true, "Tharma", ps);
        Sorciere tharma4=new Sorciere(4, 6, true, "Tharma", ps);
        Sorciere tharma5=new Sorciere(5, 6, true, "Tharma", ps);
        Sorciere tharma6=new Sorciere(6, 6, true, "Tharma", ps);
        Sorciere tharma7=new Sorciere(7, 6, true, "Tharma", ps);
        Sorciere tharma8=new Sorciere(0, 6, true, "Tharma", ps);
        /*------------pieces-------------*/
        
        
        
        /*------------plateau-------------*/
        
        JFrame frame = new JFrame();
        frame.setBounds(10, 10, 512, 512);/*dimensions du board*/
/*frame.setUndecorated(true); /*enleve ce qui est autour comme bordure*/
        JPanel pn=new JPanel(){
            @Override
            public void paint(Graphics g) {
                /*affichage à l'ecran*/
            boolean pink=true;
                for(int y= 0;y<8;y++){ /* on fait un echiquier de 8*/
            for(int x= 0;x<8;x++){
                if(pink){
                    g.setColor(Color.pink);
                }else{
                    g.setColor(new Color(119, 148, 85));
                    
                }
                g.fillRect(x*64, y*64, 64, 64);
           pink=!pink;
            }
            pink=!pink;
            
          /*-----------plateau---------------*/
            }
                for(Protagoniste p: ps){
                    int ind=0;
                    
                    if(p.name.equalsIgnoreCase("Layla")){
                        ind=0;
                    }
                    if(p.name.equalsIgnoreCase("Musa")){
                        ind=1;
                    }
                    if(p.name.equalsIgnoreCase("Tecna")){
                        ind=2;
                    }
                    if(p.name.equalsIgnoreCase("Flora")){
                        ind=3;
                    }
                    if(p.name.equalsIgnoreCase("Bloom")){
                        ind=4;
                    }
                    if(p.name.equalsIgnoreCase("Stella")){
                        ind=5;
                    }
                   
                    if(p.name.equalsIgnoreCase("Lysliss")){
                        ind=6;
                    }
                    if(p.name.equalsIgnoreCase("Belladone")){
                        ind=7;
                    }
                    if(p.name.equalsIgnoreCase("Stormy")){
                        ind=8;
                    }
                    if(p.name.equalsIgnoreCase("Darcy")){
                        ind=9;
                    }
                    if(p.name.equalsIgnoreCase("Icy")){
                        ind=10;
                    }
                    if(p.name.equalsIgnoreCase("Tharma")){
                        ind=11;
                    }
                    
                    g.drawImage(imgs[ind], p.x, p.y, this);
                }
            }
            
        };
        
        
        
        
        /* -------------selection et mouvement des pieces---------------*/
        frame.addMouseMotionListener(new MouseMotionListener(){
             @Override
            public void mouseDragged(MouseEvent me) {
                if(selectedPiece!=null){
                    selectedPiece.x=me.getX()-32;
                    selectedPiece.y=me.getY()-32;
                    frame.repaint();


                }

            }

            @Override
            public void mouseMoved(MouseEvent me) {
            }
    
        });
        frame.add(pn);
        frame.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
                //System.out.println(getPiece(me.getX(), me.getY()).name);
                selectedPiece=getProtagoniste(me.getX(), me.getY());
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                selectedPiece.move(me.getX()/64, me.getY()/64);   
                frame.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
            
        });
           /* -------------selection et mouvement des pieces---------------*/

        frame.setDefaultCloseOperation(3);/*fermeture du board*/
        frame.setVisible(true);         
}
    public static Protagoniste getProtagoniste(int x, int y){
        int xp=x/64;
        int yp=y/64;
        
        for(Protagoniste p:ps){
            if (p.xp==xp && p.yp==yp){
                return p;
            }
        }
        return null;
    }
    
    
}