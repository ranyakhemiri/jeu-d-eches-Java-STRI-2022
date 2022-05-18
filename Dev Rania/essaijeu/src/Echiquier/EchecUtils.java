package Echiquier;

public class EchecUtils {
	
	/*********** savoir quelle colonne ***********/
	public static final boolean[] FIRST_COLUMN = initColonne(0);
	public static final boolean[] SECOND_COLUMN = initColonne(1);
	public static final boolean[] SEVENTH_COLUMN = initColonne(6);
	public static final boolean[] EIGHTH_COLUMN = initColonne(7);

	/*********** savoir quelle rangée ***********/
	public static final boolean[] SECOND_ROW= initRangee(8); //deuxième rangée
	public static final boolean[] SEVENTH_ROW= initRangee(48); //avant dernière rangée

	private EchecUtils(){
		throw new RuntimeException("Impossible d'initier cette classe.");
	}
	
	public static boolean isValid(int coordonnee) {
		return coordonnee>=0 && coordonnee<64;
	}
	
	private static boolean[] initColonne(int numeroColonne) {
		final boolean[] col = new boolean[64];
		do {
			col[numeroColonne]=true;
			numeroColonne+= 8;
		} while (numeroColonne<64);
		return col;
	}

	private static boolean[] initRangee(int numeroRangee) {
		final boolean[] rang = new boolean[64];
		do {
			rang[numeroRangee] = true;
			numeroRangee ++;
		}
		while (numeroRangee%8 !=0);
		return rang;
	}

}
