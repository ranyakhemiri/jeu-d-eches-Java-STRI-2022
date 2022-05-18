package Echiquier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	private Echec (Builder builder) {
		this.echiquier= creerEchiquier(builder);
		this.joueursFees=calculerPieces(this.echiquier, Camps.FEE);
		this.joueursSorcieres=calculerPieces(this.echiquier, Camps.SORCIERE);
		
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
			//ajouteur le déplacement de chaque joueur:
			deplacements.addAll(piece.calculerDeplacement(this));
		}
		return deplacements;
	}
	
	
	private static Collection<Piece> calculerPieces(List<Case> echiquier, Camps camp) {
		/* méthode qui nous permet de suivre les pièces présentes sur l'échiquier de chaque camp*/
		final List<Piece> piecesPresentes= new ArrayList<>();
		
		//parcours des cases de l'échiquier: 
		for (final Case cases : echiquier) {
			//si la case est occupée:
			if (cases.isCaseOccupee()) {
				final Piece piece= cases.getPiece(); //on récupère la pièce occupant la case
				if (piece.getCamp()==camp) { 
					piecesPresentes.add(piece);// on l'ajoute aux pièces présentes sur l'échiquier selon son camp
				}}
		}
		return piecesPresentes;
	}
	
	
	public Case getCase(int coordonneeCase) {
		/* méthode qui retourne la coordonnée d'une case */
		return echiquier.get(coordonneeCase);
	}
	
	private static List<Case> creerEchiquier(final Builder builder){
		final Case[] cases= new Case[64]; //tableau de cases
		//parcours de toutes les cases de l'échiquier de taille 8*8
		for (int i=0; i<64; i++) {
			//get(i): nous permet de récuperer la pièce associée à cette case depuis notre builder
			//creerCase permet de créer une nouvelle case et l'associer à un joueur
			cases[i]= Case.creerCase(i, builder.configEchec.get(i));
		}
		return Arrays.asList(cases);
	}
	
	public static Echec initialiserEchiquier() {
		/*cette méthode va créer la disposition initial des pièces sur l'échiquier*/
		final Builder builder = new Builder();
		/********** Camps Sorcieres **********/
		builder.setPiece(new Sorciere(0,Camps.SORCIERE));
		builder.setPiece(new Sorciere(1,Camps.SORCIERE));
		builder.setPiece(new Sorciere(2,Camps.SORCIERE));
		builder.setPiece(new Sorciere(3,Camps.SORCIERE));
		builder.setPiece(new Sorciere(4,Camps.SORCIERE));
		builder.setPiece(new Sorciere(5,Camps.SORCIERE));
		builder.setPiece(new Sorciere(6,Camps.SORCIERE));
		builder.setPiece(new Sorciere(7,Camps.SORCIERE));
		builder.setPiece(new Sorciere(8,Camps.SORCIERE));
		builder.setPiece(new Sorciere(9,Camps.SORCIERE));
		builder.setPiece(new Sorciere(10,Camps.SORCIERE));
		builder.setPiece(new Sorciere(11,Camps.SORCIERE));
		builder.setPiece(new Sorciere(12,Camps.SORCIERE));
		builder.setPiece(new Sorciere(13,Camps.SORCIERE));
		builder.setPiece(new Sorciere(14,Camps.SORCIERE));
		builder.setPiece(new Sorciere(15,Camps.SORCIERE));

		/********** Camps Fees **********/
		builder.setPiece(new Fee(48,Camps.FEE));
		builder.setPiece(new Fee(49,Camps.FEE));
		builder.setPiece(new Fee(50,Camps.FEE));
		builder.setPiece(new Fee(51,Camps.FEE));
		builder.setPiece(new Fee(52,Camps.FEE));
		builder.setPiece(new Fee(53,Camps.FEE));
		builder.setPiece(new Fee(54,Camps.FEE));
		builder.setPiece(new Fee(55,Camps.FEE));
		builder.setPiece(new Fee(56,Camps.FEE));
		builder.setPiece(new Fee(57,Camps.FEE));
		builder.setPiece(new Fee(58,Camps.FEE));
		builder.setPiece(new Fee(59,Camps.FEE));
		builder.setPiece(new Fee(60,Camps.FEE));
		builder.setPiece(new Fee(61,Camps.FEE));
		builder.setPiece(new Fee(62,Camps.FEE));
		builder.setPiece(new Fee(63,Camps.FEE));
		return builder.build();
	}
	
	public static class Builder {
		Map<Integer, Piece> configEchec;
		Camps prochainTour= Camps.FEE;
		
		public Builder() {
			this.configEchec= new HashMap<>();
		}
		
		public Builder setPiece (final Piece piece) {
			this.configEchec.put(piece.getPiecePosition(), piece);
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
