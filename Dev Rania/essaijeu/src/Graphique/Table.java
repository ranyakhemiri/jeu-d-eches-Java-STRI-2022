package Graphique;

import javax.imageio.ImageIO;
import javax.swing.*;

import Echiquier.Case;
import Echiquier.Echec;
import Echiquier.EchecUtils;
import Echiquier.Move;
import Joueurs.Transition;
import Protagonistes.Camps;
import Protagonistes.Piece;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Table {
	private final JFrame gameFrame;
	private final BoardPanel boardPanel; //gère l'échiquier
	private Echec echec; //représente l'échiquier
	
	
	//lorsque le joueur souhaite déplacer une case:
	//il clique sur la case source ensuite sur la case de destination (où il souhaite déplacer la pièce)
	private Case sourceTile;
	private Case destinationTile;
	private Piece movedPiece;
	
	 private final Color greenColor = Color.decode("#90EE90");
	 private final Color pinkColor = Color.decode("#FFB6C1");
	 private static String defaultPieceImagesPath="art/";
	
	 public Table() {
		this.gameFrame= new JFrame("JChess");
		this.gameFrame.setLayout(new BorderLayout());
		final JMenuBar tableMenuBar= new JMenuBar();
		populateMenuBar (tableMenuBar);
		this.echec= Echec.initialiserEchiquier();
		this.gameFrame.setJMenuBar(tableMenuBar);
		this.gameFrame.setSize(new Dimension(600,600));
		this.gameFrame.setVisible(true);
		
		this.boardPanel= new BoardPanel(); //création de l'échiquier
		//centrer l'échiquier: 
		this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
		
	}

	private void populateMenuBar(JMenuBar tableMenu) {
		tableMenu.add(createFileMenu());
	}

	private JMenu createFileMenu() {
		final JMenu fileMenu= new JMenu("File");
		final JMenuItem openPGN= new JMenuItem("Load PGN File");
		openPGN.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent e) {
				System.out.println("ouvre le fichier pgn!");}
			});
		fileMenu.add(openPGN);
		
		//nous permet de quitter le jeu
		final JMenuItem exitMenuItem= new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				System.exit(0);
			}
		});
		fileMenu.add(exitMenuItem);
		
		return fileMenu;
	}
	
/* ***************** Partie graphique de l'échiquier ***************** */
	private class BoardPanel extends JPanel{
		final List <TilePanel>casesEchec;
		
		BoardPanel(){
			//ajout de 64 cases: 
			super(new GridLayout(8,8));
			this.casesEchec= new ArrayList<>();
			for (int i=0; i< 64; i++) {
				//instanciation d'une nouvelle case: 
				//on lui passe en paramètre l'échiquie où elle doit se poser, ainsi que sa position i
				final TilePanel tilePanel= new TilePanel(this,i);
				//ajoute la case à la liste de case de l'échiquier:
				this.casesEchec.add(tilePanel);
				add(tilePanel);
			}
			//taille de l'échiquier par rapport au Frame total:
			setPreferredSize(new Dimension(400,350));
			validate();
		}

		public void drawBoard(final Echec echec) {
			removeAll();
			for (final TilePanel tilePanel : casesEchec) {
			tilePanel.drawTile(echec);
			add(tilePanel);
			}
			validate();
			repaint();
		}
		
	}
	
/* ***************** Partie graphique des cases ***************** */
	private class TilePanel extends JPanel{
		private final int tileId; //de 0-->63 (64 cases)
		
		TilePanel(final BoardPanel boardPanel,
					final int tileId){
			super(new GridBagLayout());
			this.tileId= tileId;
			//taille de chaque case:
			setPreferredSize(new Dimension(10,10));
			//méthode qui attribue à chaque case sa couleur;
			assignTileColor();
			assignTilePieceIcon(echec);
			
		/*	addMouseListener(new MouseListener() {
				@Override
				public void mouseClicked(final MouseEvent e) {	
					//la selection d'une pièce avec le clique droit annule l'action de déplacement de la pièce
					if (SwingUtilities.isRightMouseButton(e)) {
						sourceTile =null;
						destinationTile=null;
						movedPiece = null;		
					} else if (SwingUtilities.isLeftMouseButton(e)) {
						if (sourceTile == null) {//si le joueur n'a pas selectionné de départ(case)
							sourceTile= echec.getCase(tileId);//on affecte la case à la source a l'aide de son numéro
							movedPiece= sourceTile.getPiece();//on récupère la pièce positionnée sur la case de numéro tileId
							if (movedPiece == null) {//si le joueur selectionne une case vide
								sourceTile = null; //on passe au cas prochain (où source est nulle)
							}
						} else {
							destinationTile = echec.getCase(tileId);
							final Move move = Move.MoveFactory.creerMove(echec,
									sourceTile.getCoordonneeCase(), 
									destinationTile.getCoordonneeCase());
							final Transition transition = echec.getJoueurActuel().seDeplacer(move);
							echec = transition.getEchiquierFinal();
							//après avoir effectué le déplacement(donc la transition), on remet tous à null 
							//pour ne pas avoir d'erreur pour les prochains déplacements
							sourceTile = null;
							destinationTile =null;
							movedPiece=null;
						}
						SwingUtilities.invokeLater(new Runnable() {

							@Override
							public void run() {
								boardPanel.drawBoard(echec);
							}
							
						});
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseReleased(MouseEvent e) {					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					
				}

				@Override
				public void mouseExited(MouseEvent e) {					
				}
				
			});*/
			
			
			validate();
		}

		public void drawTile(final Echec echec) {
			assignTileColor();
			assignTilePieceIcon(echec);
			validate();
			repaint();
		}

		private void assignTilePieceIcon(final Echec echec) {
			this.removeAll();
			if(echec.getCase(tileId).getPiece() != null) {
                try{
                	//convention de nommage des pièces:
                	// pour les sorcières: "S"+initial de la sorcière+".png"
                	//pour les fées: "F"+initial de la fée+ ".png"
                	final BufferedImage image = ImageIO.read(new File("art/" +
                            echec.getCase(tileId).getPiece().getCamp().toString().substring(0, 1) + "" +
                            echec.getCase(tileId).getPiece().toString() +
                            ".png"));
                    add(new JLabel(new ImageIcon(image)));
                } catch(final IOException e) {
                    e.printStackTrace();
                }
            }	
		}
		

		//fonction qui attribue les couleurs aux case
		private void assignTileColor() {
			//on saute une rangée à chaque fois pour les couleurs soit inversées
			if (EchecUtils.FIRST_ROW[this.tileId] ||
				EchecUtils.THIRD_ROW[this.tileId] ||
				EchecUtils.SEVENTH_ROW[this.tileId] ||
				EchecUtils.FIFTH_ROW[this.tileId]) {
			setBackground(this.tileId % 2 == 0 ? greenColor : pinkColor);
			}
			//on saute une rangée à chaque fois,
			else if (EchecUtils.SECOND_ROW[this.tileId] ||
					EchecUtils.FOURTH_ROW[this.tileId] ||
					EchecUtils.SIXTH_ROW[this.tileId] ||
					EchecUtils.EIGHTH_ROW[this.tileId]   ) {
				setBackground(this.tileId % 2 != 0 ? greenColor : pinkColor);
			}
		}
	}
}
