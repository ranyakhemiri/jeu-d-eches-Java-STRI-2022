package Joueurs;

import java.util.Collection;

import Echiquier.Echec;
import Echiquier.Move;
import Protagonistes.Camps;
import Protagonistes.Piece;

public class JoueurSorciere extends Joueur {
	public JoueurSorciere (Echec echec,
			Collection <Move> deplacementsSorciere,
			Collection <Move> deplacementsFee) {
		super(echec,deplacementsSorciere,deplacementsFee);
	
	}
	
	@Override
	public Collection<Piece> getPiecesPresentes() {
		return this.echec.getPiecesSorcieres();
	}

	@Override
	public Camps getCamp() {
		return Camps.SORCIERE;
	}

	@Override
	public Joueur getEnnemi() {
		return this.echec.getJoueurFee();
	}
	
}
