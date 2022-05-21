package maps;
import protagonistes.Personnage;

public class Case{
	private Personnage occupant;
	private int position;
	public Case(int position, Personnage occupant) {
		this.position = position;
		this.occupant = occupant;
	}
	
	public Personnage getOccupant() {
		return occupant;
	}
	
	public int getPosition() {
		return position;
	}

	public void setOccupant(Personnage occupant) {
		this.occupant = occupant;
	}
}
