package Protagonistes;

import java.util.Collection;

import Echiquier.Echec;
import Echiquier.Move;
import Protagonistes.Piece.typePiece;

public class Fee extends Piece{
	
	public Fee(final int positionPiece, final Camps campsPiece) {
		super(positionPiece, campsPiece);
	}

	
	@Override
	public String toString () {
		return typePiece.Fee.toString();
	}


	@Override
	public Piece bougerPiece(Move deplacement) {
		return new Fee(deplacement.getDestination(),deplacement.getPieceBougee().getCamp());
	}
}
