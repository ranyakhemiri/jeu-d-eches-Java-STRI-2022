package Joueurs;

import Echiquier.Echec;
import Echiquier.Move;

public class Transition {
	/* marque les informations � r�cup�rer lors d'une transition d'un echiquier � un autre
	 * suite � un d�placement d'une pi�ce.
	 */
	private final Echec echiquierIntermediaire;
	private final Move deplacement;
	
	public Transition( final Echec echiquierIntermediaire , final Move deplacement ) {
		this.echiquierIntermediaire= echiquierIntermediaire;
		this.deplacement= deplacement;
	}
}
