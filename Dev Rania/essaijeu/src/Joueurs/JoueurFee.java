package Joueurs;

import java.util.Collection;

import Echiquier.Echec;
import Echiquier.Move;
import Protagonistes.Camps;
import Protagonistes.Piece;

public class JoueurFee extends Joueur{
	public JoueurFee (Echec echec,
			Collection <Move> deplacementsFee,
			Collection <Move> deplacementsSorciere) {
		super(echec,deplacementsFee,deplacementsSorciere);
		
	}

	@Override
	public Collection<Piece> getPiecesPresentes() {
		return this.echec.getPiecesFees();
	}

	@Override
	public Camps getCamp() {
		return Camps.FEE;
	}

	@Override
	public Joueur getEnnemi() {
		return this.echec.getJoueurSociere();
	}
}
