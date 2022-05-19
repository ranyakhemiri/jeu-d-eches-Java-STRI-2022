package Protagonistes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Echiquier.Move;
import Echiquier.Case;
import Echiquier.Echec;
import Echiquier.EchecUtils;

public abstract class Piece {
	protected final int positionPiece;
	protected final Camps campPiece;
	private final static int[] MOVE_COORDINATES= {-9,-8,-7,-1,1,7,8,9};

	Piece (final int positionPiece, final Camps campPiece){
		this.campPiece= campPiece;
		this.positionPiece= positionPiece;
		//TODO à completer!!!
	}
	
	@Override
	public boolean equals(final Object autre) {
		if (this==autre) { // on n'a pas besoin de comparer, c'est le même objet
			return true;
		}
		if (!(autre instanceof Piece)){
			return false; // on n'a pas besoin de comparer, ne peuvent pas être le même objet
		}
		final Piece autrePiece= (Piece) autre;
		return campPiece==autrePiece.campPiece && positionPiece == autrePiece.positionPiece;
	}
	
	@Override
	public int hashCode() {
		int resultat= campPiece.hashCode();
		resultat = 31* resultat+ positionPiece;
		return resultat;
		
	}
	
	public Camps getCamp() {
		return this.campPiece;
		}
	
	public List<Move> calculerDeplacement(Echec echec) {//à enlever car  calcule deplacements legals
		
		final List<Move> deplacements= new ArrayList<>();
		int destinationCoordonnee;
		
		for (final int pieceOffset: MOVE_COORDINATES) {
			destinationCoordonnee= this.positionPiece+ pieceOffset;
			
			if (isFirstColumnException(this.positionPiece, pieceOffset)
					||isLastColumnException(this.positionPiece,pieceOffset )) {
				continue;
			}
			
			if (EchecUtils.isValid(destinationCoordonnee)){
				final Case destinationFinale = echec.getCase(destinationCoordonnee);
				if (!destinationFinale.isCaseOccupee()) {
					deplacements.add(new Move.Deplacement(echec,this,destinationCoordonnee));
				} else {
					final Piece pieceOccupante = destinationFinale.getPiece();
					final Camps campPieceOccupante= pieceOccupante.getCamp();
					if (campPieceOccupante!=this.campPiece) {
						deplacements.add(new Move.Attaque(echec,this,destinationCoordonnee,pieceOccupante));

					}
				}
			}}
		return deplacements;
		}

	private static boolean isFirstColumnException (final int positionActuelle, int offset) {
		return EchecUtils.FIRST_COLUMN[positionActuelle] && (offset == -9 || offset==-1 ||
				offset == 7);
	}
	
	private static boolean isLastColumnException (final int positionActuelle, int offset) {
		return EchecUtils.EIGHTH_COLUMN[positionActuelle] && (offset == -7 || offset==1 ||
				offset == 9);
	}

	public int getPiecePosition() {
		return this.positionPiece;
	}
	
	
	//méthode qui sert à placer une pièce bougée à sa nouvelle position
	public abstract Piece bougerPiece(Move deplacement);
	//TODO implementer la méthode et enlever "absract"
	
	
	public enum typePiece{
		Sorciere("S"),
		Fee("F");
		private String nomPiece;
		typePiece (final String nomPiece){
			this.nomPiece= nomPiece;
		}
		@Override
		public String toString() {
			return this.nomPiece;
		}
	}
}
