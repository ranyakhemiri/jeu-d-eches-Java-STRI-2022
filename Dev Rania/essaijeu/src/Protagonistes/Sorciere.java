package Protagonistes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Echiquier.Echec;
import Echiquier.Move;

public class Sorciere extends Piece {

	
	public Sorciere(final int positionPiece, final Camps campsPiece) {
		super(positionPiece, campsPiece);
	}


	@Override
	public String toString () {
		return typePiece.Sorciere.toString();
	}


	@Override
	public Piece bougerPiece(Move deplacement) {
		return new Sorciere(deplacement.getDestination(),deplacement.getPieceBougee().getCamp());
	}


}
