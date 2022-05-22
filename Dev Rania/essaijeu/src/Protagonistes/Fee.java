package Protagonistes;

import java.util.Collection;

import Echiquier.Echec;
import Echiquier.Move;
import Protagonistes.Piece.typePiece;

public class Fee extends Piece{
	
	public String nomFee;
	
	public Fee(final int positionPiece, final Camps campsPiece,final String nomFee) {
		super(positionPiece, campsPiece);
		this.nomFee=nomFee;
	}

	
	@Override
	public String toString () {
		if (nomFee=="Stella")
			return "S";
		if (nomFee=="Musa") {
			return "M";
		}
		if (nomFee=="Flora")
			return "F";
		if (nomFee=="Bloom") {
			return "B";
		}
		return nomFee;
	}


	@Override
	public Fee bougerPiece(Move deplacement) {
		return new Fee(deplacement.getDestination(),deplacement.getPieceBougee().getCamp(), nomFee);
	}
}
