package Protagonistes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Echiquier.Echec;
import Echiquier.Move;

public class Sorciere extends Piece {
	public String nomSorciere;
	
	public Sorciere(final int positionPiece, final Camps campsPiece, String nomSorciere) {
		super(positionPiece, campsPiece);
		this.nomSorciere=nomSorciere;
	}


	@Override
	public String toString () {
		if (nomSorciere=="Stormy") {
			return "S";
		}
		if (nomSorciere=="Icy") {
			return "I";
		}
		return nomSorciere;
	}


	@Override
	public Sorciere bougerPiece(Move deplacement) {
		return new Sorciere(deplacement.getDestination(),deplacement.getPieceBougee().getCamp(), nomSorciere);
	}


}

