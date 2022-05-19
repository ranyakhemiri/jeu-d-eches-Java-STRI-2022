package Echiquier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Joueurs.Joueur;
import Joueurs.JoueurFee;
import Joueurs.JoueurSorciere;
import Protagonistes.Camps;
import Protagonistes.Fee;
import Protagonistes.Piece;
import Protagonistes.Sorciere;

public class Echec {
	
	//l'echiquier est composé de plusieurs cases: 
	private final List<Case> echiquier;
	//attributs qui nous permettent de suivre les joueurs présents dans le jeux de chaque champ
	private final Collection<Piece> joueursSorcieres;
	private final Collection<Piece> joueursFees;
	
	private JoueurFee joueurFee;
	private JoueurSorciere joueurSorciere;
	private Joueur joueurActuel;
	
	
	private Echec (final Builder builder) {
		this.echiquier= creerEchiquier(builder);
		this.joueursFees=calculerPiecesPresentes(builder, Camps.FEE);
		this.joueursSorcieres=calculerPiecesPresentes(builder, Camps.SORCIERE);
		
		/* nous permet de suivre les mouvements des joueurs*/
		final Collection <Move> sorciereDeplacements= calculerDeplacement(this.joueursSorcieres);
		final Collection <Move> feeDeplacements= calculerDeplacement(this.joueursFees);
		
		this.joueurFee= new JoueurFee(this, feeDeplacements, sorciereDeplacements);
		this.joueurSorciere= new JoueurSorciere(this, sorciereDeplacements,feeDeplacements);
		this.joueurActuel= builder.prochainTour.choisirJoueur(this.joueurFee,this.joueurSorciere);
	}
	
	@Override
	public String toString() {
		final StringBuilder builder= new StringBuilder();
		for (int i=0; i<64; i++) {
			final String texteCase= this.echiquier.get(i).toString();
			builder.append(String.format("%3s", texteCase));
			if ((i+1)%8==0) /*a chaque fois qu'on arrive à la fin d'une colonne: */{
				builder.append("\n");
			}
		}
		return builder.toString();
	}
	
	public Case getCase(int coordonneeCase) {
		/* méthode qui retourne la coordonnée d'une case */
		return echiquier.get(coordonneeCase);
	}
	
	public Collection<Piece> getPieces(){
		  return Stream.concat(this.joueursFees.stream(),
                  this.joueursSorcieres.stream()).collect(Collectors.toList());
	}
	
	public Collection<Piece> getPiecesFees(){
		return this.joueursFees;
	}
	
	public Collection<Piece> getPiecesSorcieres(){
		return this.joueursSorcieres;
	}
	
	public JoueurFee getJoueurFee() {
		return this.joueurFee;
	}
	
	public JoueurSorciere getJoueurSociere() {
		return this.joueurSorciere;
	}
	
	public Joueur getJoueurActuel() {
		return this.joueurActuel;
	}

		
    
	private Collection<Move> calculerDeplacement(final Collection<Piece> pieces){
		final List<Move> deplacements= new ArrayList();
		// parcourir les pièces d'un camp présentes sur l'échiquier:
		for (final Piece piece: pieces) {	
				//chaque pièce peut se déplacer à la position "i"
				deplacements.addAll(piece.calculerDeplacement(this));
				//on incrémente i et on parcours toutes les pièces à nouveau
				 
		}
		return deplacements;
	}
	
	
	private static Collection<Piece> calculerPiecesPresentes(Builder builder, Camps camp) {
		/* méthode qui nous permet de suivre les pièces présentes sur l'échiquier de chaque camp*/
		 return builder.boardConfig.values().stream() //parcours de la configuration de l'échiquier
				 //qui associe numéro de case et pièce
	               .filter(piece -> piece.getCamp() == camp) //on récupère les pièces ensuite leur camps
	               .collect(Collectors.toList());
	}
	
	
	private static List<Case> creerEchiquier(final Builder builder){
		final Case[] cases= new Case[64]; //tableau de cases
		//parcours de toutes les cases de l'échiquier de taille 8*8
		for (int i=0; i<64; i++) {
			//get(i): nous permet de récuperer la pièce associée à cette case depuis notre builder
			//creerCase permet de créer une nouvelle case et l'associer à un joueur
			cases[i]= Case.creerCase(i, builder.boardConfig.get(i));
		}
		return Arrays.asList(cases);
	}
	
	public static Echec initialiserEchiquier() {
		/*cette méthode va créer la disposition initial des pièces sur l'échiquier*/
		final Builder builder = new Builder();
		/********** Camps Sorcieres **********/
		builder.setPiece(new Sorciere(0,Camps.SORCIERE,"Icy"));
		builder.setPiece(new Sorciere(1,Camps.SORCIERE,"Icy"));
		builder.setPiece(new Sorciere(2,Camps.SORCIERE,"Icy"));
		builder.setPiece(new Sorciere(3,Camps.SORCIERE,"Icy"));
		builder.setPiece(new Sorciere(4,Camps.SORCIERE,"Stormy"));
		builder.setPiece(new Sorciere(5,Camps.SORCIERE,"Stormy"));
		builder.setPiece(new Sorciere(6,Camps.SORCIERE,"Stormy"));
		builder.setPiece(new Sorciere(7,Camps.SORCIERE,"Stormy"));
		builder.setPiece(new Sorciere(8,Camps.SORCIERE,"Stormy"));
		builder.setPiece(new Sorciere(9,Camps.SORCIERE,"Stormy"));
		builder.setPiece(new Sorciere(10,Camps.SORCIERE,"Stormy"));
		builder.setPiece(new Sorciere(11,Camps.SORCIERE,"Stormy"));
		builder.setPiece(new Sorciere(12,Camps.SORCIERE,"Icy"));
		builder.setPiece(new Sorciere(13,Camps.SORCIERE,"Icy"));
		builder.setPiece(new Sorciere(14,Camps.SORCIERE,"Icy"));
		builder.setPiece(new Sorciere(15,Camps.SORCIERE,"Icy"));

		/********** Camps Fees **********/
		builder.setPiece(new Fee(48,Camps.FEE,"Stella"));
		builder.setPiece(new Fee(49,Camps.FEE,"Stella"));
		builder.setPiece(new Fee(50,Camps.FEE, "Musa"));
		builder.setPiece(new Fee(51,Camps.FEE,"Musa"));
		builder.setPiece(new Fee(52,Camps.FEE,"Flora"));
		builder.setPiece(new Fee(53,Camps.FEE,"Flora"));
		builder.setPiece(new Fee(54,Camps.FEE,"Bloom"));
		builder.setPiece(new Fee(55,Camps.FEE,"Bloom"));
		builder.setPiece(new Fee(56,Camps.FEE,"Stella"));
		builder.setPiece(new Fee(57,Camps.FEE,"Stella"));
		builder.setPiece(new Fee(58,Camps.FEE,"Musa"));
		builder.setPiece(new Fee(59,Camps.FEE,"Musa"));
		builder.setPiece(new Fee(60,Camps.FEE,"Flora"));
		builder.setPiece(new Fee(61,Camps.FEE,"Flora"));
		builder.setPiece(new Fee(62,Camps.FEE,"Bloom"));
		builder.setPiece(new Fee(63,Camps.FEE,"Bloom"));
		return builder.build();
	}
	

/* ************************* Classe BUILDER ********************** */
	public static class Builder {
		Map<Integer, Piece> boardConfig;
		Camps prochainTour= Camps.FEE;//TODO
        Move transitionMove;
		
		public Builder() {
			this.boardConfig= new HashMap<>();
		}
		
		public Builder setPiece (final Piece piece) {
			this.boardConfig.put(piece.getPiecePosition(), piece);
			return this;
		}
		
		public Builder setProchainTour(final Camps prochainTour) {
			this.prochainTour= prochainTour;
			return this;
		}
		public Echec build() {
			return new Echec(this);
		}
	}

}


