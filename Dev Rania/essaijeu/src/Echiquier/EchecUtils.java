package Echiquier;

public class EchecUtils {
	
	/*********** savoir quelle colonne ***********/
	public static final boolean[] FIRST_COLUMN = initColonne(0);
	public static final boolean[] SECOND_COLUMN = initColonne(1);
	public static final boolean[] SEVENTH_COLUMN = initColonne(6);
	package Echiquier;

public class EchecUtils {
	
	/*********** savoir quelle colonne ***********/
	public static final boolean[] FIRST_COLUMN = initColonne(0);
	public static final boolean[] SECOND_COLUMN = initColonne(1);
	public static final boolean[] SEVENTH_COLUMN = initColonne(6);
	public static final boolean[] EIGHTH_COLUMN = initColonne(7);

	/*********** savoir quelle rangée ***********/
	//à chaque rangée, on ajoute +8 (cases) à la précendente:
	public static final boolean[] FIRST_ROW= initRangee(0); //1ere rangée
	public static final boolean[] SECOND_ROW= initRangee(8); //deuxième rangée
	public static final boolean[] THIRD_ROW= initRangee(16); //3ème rangée
	public static final boolean[] FOURTH_ROW= initRangee(24); //4ème rangée
	public static final boolean[] FIFTH_ROW= initRangee(32); //5ème rangée
	public static final boolean[] SIXTH_ROW= initRangee(40); //6ème rangée
	public static final boolean[] SEVENTH_ROW= initRangee(48); //avant dernière rangée
	public static final boolean[] EIGHTH_ROW= initRangee(56); //dernière rangée

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
