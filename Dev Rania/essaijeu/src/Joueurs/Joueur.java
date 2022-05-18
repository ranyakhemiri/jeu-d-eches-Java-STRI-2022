package Joueurs;

import java.util.Collection;

import Echiquier.Echec;
import Echiquier.Move;
import Protagonistes.Camps;
import Protagonistes.Piece;

public abstract class Joueur {

	protected final Echec echec; //l'echiquier sur lequel le joueur joue
	protected final Collection<Move> deplacements;
	
	Joueur(final Echec echec, final Collection<Move> deplacements,
			final Collection<Move> deplacementsEnnemis){
		this.echec= echec;
		this.deplacements= deplacements;
	}
	
	public Transition seDeplacer(final Move deplacement) {
		/*la transition d'un echiquier � un autre suite � un d�placement*/
		final Echec transitionEchec= deplacement.executer();
		return new Transition(transitionEchec, deplacement);
	}
	
	//retourne les pi�ces du joueurs pr�sentes sur l'�chiquier:
	public abstract Collection<Piece> getPiecesPresentes();
	
	public abstract Camps getCamp();
	public abstract Joueur getEnnemi();
}
