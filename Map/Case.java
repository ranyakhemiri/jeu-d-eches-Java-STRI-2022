package Map;
import Personnages.EtreVivant;
import Tresors.Tresor;

public class Case{
	private EtreVivant occupant;
	private Tresor tresor;

/* Constructeur */
	public Case(EtreVivant occupant, Tresor tresor) {
		super();
		this.occupant = occupant;
		this.tresor = tresor;
	}

/* retourne si sous la case il y a un tresor */
	public boolean tresor() {
		if (this.tresor == null){
			return false;
		}
		else
			return true;
	}
/* retourne si sur la case il y a un personnage */
	public boolean occupant() {
		if (this.occupant == null){
			return false;
		}
		else
			return true;
	}

/* si on a une personnage sur un tresor, alors on equipe le tresor au personnage */
	public void recupere_tresor() {
		if (this.occupant() && this.tresor()) {
			occupant.equiper(tresor);
		}
	}
}

