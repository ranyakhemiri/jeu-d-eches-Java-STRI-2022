package Joueurs;

import Echiquier.Echec;
import Echiquier.Move;

public class Transition {
	/* marque les informations à récupérer lors d'une transition d'un echiquier à un autre
	 * suite à un déplacement d'une pièce.
	 */
	private final Echec echiquierIntermediaire;
	private final Move deplacement;
	
	public Transition( final Echec echiquierIntermediaire , final Move deplacement ) {
		this.echiquierIntermediaire= echiquierIntermediaire;
		this.deplacement= deplacement;
	}
}
