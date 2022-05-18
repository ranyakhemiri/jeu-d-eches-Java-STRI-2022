package Echiquier;

import java.util.HashMap;
import java.util.Map;

import Protagonistes.Camps;
import Protagonistes.Piece;

public abstract class Case {
	/* la classe Case représente une case dans notre échiquier.
	 Elle sera occupée par une sorcière ou une fée, 
	 ou bien elle sera libre
	  */
	
	//les coordonées d'une case ne changeront jamais 
	//c'est pour cela que cet attribut est "final"
	protected final int coordonneeCase;
	
	private static final Map <Integer, CaseVide> CASES_VIDES= creerToutesCasesVides();
	
	private static Map<Integer, CaseVide> creerToutesCasesVides() {	
		final Map <Integer, CaseVide> caseVideMap= new HashMap<>();		
		/* initialisation de l'echiquier vide*/ 
		for (int i=0; i<64; i++) {
			caseVideMap.put(i,  new CaseVide(i));
			//génere des cases vides de tailles 8*8 grace a la méthode put
			//on passe à chaque fois i en paramètres au constructeur de la classe CaseVide 
		}		
		//pour accéder à une case: CASES_VIDES.get(coordonnee) entre 0 et 63
		return caseVideMap;
	}
	
	
	
	public static Case creerCase( final int coordonneeCase, final Piece piece) {
		if (piece!=null) {
			return new CaseOccupee(coordonneeCase,piece);
		}
		else {
			return CASES_VIDES.get(coordonneeCase);
		}
	}
	
	
	Case (int coordCase){
		/* chaque case a une coordonée entre [0--63]*/
		this.coordonneeCase= coordCase;
	}
	


	public abstract boolean isCaseOccupee(); 
	//renvoie si la case est libre où occupée
	
	public abstract Piece getPiece();
	
	
	// *************** case vide *************************
	public static final class CaseVide extends Case{
		
		private CaseVide (final int coordonnee){
			super(coordonnee);
		}
		
		@Override
		public String toString() {
			return "-";
		}
		
		public Piece getPiece() {
			return null; //car la case n'est pas occupée par un joueur
		}

		@Override
		public boolean isCaseOccupee() {
			return false;
		}
	}
	
	// ************* case occupée **********************
	public static final class CaseOccupee extends Case{
		private Piece pieceSurCase;
		
		private CaseOccupee(int coordonneeCase, Piece pieceSurCase){
			super(coordonneeCase);
			this.pieceSurCase= pieceSurCase;
		}
		
		@Override
		public String toString() {
			Camps team= getPiece().getCamp(); //retourne le camp de la pièce qui occupe la case 
			if (team== Camps.SORCIERE) {
				return getPiece().toString().toLowerCase();
				}
			else {//si c'est une fée:
				return getPiece().toString();
				}
			}
		
		@Override
		public boolean isCaseOccupee() {
			return true;
		}

		@Override
		public Piece getPiece() {
			return pieceSurCase;
		}
	}
}
