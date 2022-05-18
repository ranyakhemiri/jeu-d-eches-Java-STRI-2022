package Echiquier;

import java.util.HashMap;
import java.util.Map;

import Protagonistes.Camps;
import Protagonistes.Piece;

public abstract class Case {
	/* la classe Case repr�sente une case dans notre �chiquier.
	 Elle sera occup�e par une sorci�re ou une f�e, 
	 ou bien elle sera libre
	  */
	
	//les coordon�es d'une case ne changeront jamais 
	//c'est pour cela que cet attribut est "final"
	protected final int coordonneeCase;
	
	private static final Map <Integer, CaseVide> CASES_VIDES= creerToutesCasesVides();
	
	private static Map<Integer, CaseVide> creerToutesCasesVides() {	
		final Map <Integer, CaseVide> caseVideMap= new HashMap<>();		
		/* initialisation de l'echiquier vide*/ 
		for (int i=0; i<64; i++) {
			caseVideMap.put(i,  new CaseVide(i));
			//g�nere des cases vides de tailles 8*8 grace a la m�thode put
			//on passe � chaque fois i en param�tres au constructeur de la classe CaseVide 
		}		
		//pour acc�der � une case: CASES_VIDES.get(coordonnee) entre 0 et 63
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
		/* chaque case a une coordon�e entre [0--63]*/
		this.coordonneeCase= coordCase;
	}
	


	public abstract boolean isCaseOccupee(); 
	//renvoie si la case est libre o� occup�e
	
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
			return null; //car la case n'est pas occup�e par un joueur
		}

		@Override
		public boolean isCaseOccupee() {
			return false;
		}
	}
	
	// ************* case occup�e **********************
	public static final class CaseOccupee extends Case{
		private Piece pieceSurCase;
		
		private CaseOccupee(int coordonneeCase, Piece pieceSurCase){
			super(coordonneeCase);
			this.pieceSurCase= pieceSurCase;
		}
		
		@Override
		public String toString() {
			Camps team= getPiece().getCamp(); //retourne le camp de la pi�ce qui occupe la case 
			if (team== Camps.SORCIERE) {
				return getPiece().toString().toLowerCase();
				}
			else {//si c'est une f�e:
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
