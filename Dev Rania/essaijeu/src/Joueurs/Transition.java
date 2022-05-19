package Joueurs;

import Echiquier.Echec;
import Echiquier.Move;
import Echiquier.Move.MoveStatus;

public class Transition {
	/* marque les informations à récupérer lors d'une transition d'un echiquier à un autre
	 * suite à un déplacement d'une pièce.
	 */
	private final Echec echiquierInitial;
	private final Echec echiquierFinal;
	private final Move deplacement;
	private final MoveStatus moveStatus;
	
	public Transition( final Echec echiquierInitial ,final Echec echiquierFinal, final Move deplacement, final MoveStatus moveStatus ) {
		this.echiquierInitial= echiquierInitial;
		this.deplacement= deplacement;
		this.moveStatus= moveStatus;
		this.echiquierFinal= echiquierFinal;
	}
	
	public MoveStatus getMoveStatus() {
		return this.moveStatus;
	}
	
	public Move getDeplacement() {
		return this.deplacement;
	}
	
	public Echec getEchiquierInitial() {
		return echiquierInitial;
	}
	
	public Echec getEchiquierFinal() {
		return echiquierFinal;
	}
	
	
}

