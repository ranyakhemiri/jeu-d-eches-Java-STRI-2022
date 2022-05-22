package Echiquier;

import Echiquier.Echec.Builder;
import Protagonistes.Piece;

public class Move {

	protected final Echec echec; //l'echiquier sur lequel les joueurs bougent
	protected final Piece pieceBougee; 
	protected final int destination; 
	
	Move (Echec echec, Piece piece, int dest){
		this.echec=echec;
		this.pieceBougee=piece;
		this.destination=dest;
	}
	
	@Override
	public int hashCode() {
		int result =1;
		result= 31* result+ this.destination;
		result= 31* result+ this.pieceBougee.hashCode();
		return result;
	}
	
	@Override
	public boolean equals (final Object autre) {
		if (this==autre) {
			return true;
		}
		if (!(autre instanceof Move)) {
			return false;
		}
		final Move autreDeplacement= (Move) autre;
		return this.pieceBougee.equals(autreDeplacement.getPieceBougee()) 
				&& this.destination==autreDeplacement.destination
				&& this.getCoordonneeActuel()==autreDeplacement.getCoordonneeActuel();
	}
	
	public int getCoordonneeActuel() {
		//retourne la coordonnée de la pièce AVANT le déplacement
		return this.pieceBougee.getPiecePosition();
	}
	
	//getter de la pièce bougée 
	public Piece getPieceBougee() {
		return this.pieceBougee;
	}
	
	//getter de la destination de la pièce bougée
	public int getDestination() {
		//retourne la coordonnée de la pièce APRES le déplacement
		return this.destination;
	}
	
	public Echec executer() {
		final Echec.Builder builder= new Builder(); //nouvel echiquier
		//boucle de toutes les pièces du joueurs :
		for (final Piece piece: this.echec.getJoueurActuel().getPiecesPresentes()) {
			if (!this.pieceBougee.equals(piece)) {//sauf la pièce bougée
				builder.setPiece(piece);//on les copie dans le nouveul echiquier
			}
		}
		//aucune pièces de le l'autre joueur ne va bouger à cette étape
		//il suffit de les recopier toutes: 
		for (final Piece piece: this.echec.getJoueurActuel().getEnnemi().getPiecesPresentes()) {
			builder.setPiece(piece);
		}
		//on copie la pièce bougée par le joueur: 
		builder.setPiece(this.pieceBougee.bougerPiece(this));
		//on donne le prochain tour au camp adversaire (à l'autre joueur)
		builder.setProchainTour(this.echec.getJoueurActuel().getEnnemi().getCamp());
		return builder.build();
	}

	Move(Echec echec, int destination){
		this.destination=destination;
		this.echec=echec;
		this.pieceBougee=null;
	}
	
	
	/*********** deplacement normal ***********/
	public static class Deplacement extends Move{
		
		public Deplacement(Echec echec, Piece piece, int dest) {
			super(echec,piece,dest);
		}
		
		 public boolean isAttack() {
	            return false;
	     }
	}
	
	/*********** deplacement attaque ***********/
	public static class Attaque extends Move{
		protected Piece pieceAttaquee;
		
		public Attaque(Echec echec, Piece pieceBougee, int dest, Piece pieceAttaquee){
			super(echec,pieceBougee,dest);
			this.pieceAttaquee= pieceAttaquee;
			}
		
		public Piece getPieceAttaquee() {
			return this.pieceAttaquee;
		}
		
		 public boolean isAttack() {
	            return true;
	     }
		 
		 @Override
		 public Echec executer() {
			 /*à completer*/
			 return null;
		 }
		 
		 @Override
		 public int hashCode() {
			 return this.pieceAttaquee.hashCode()+ super.hashCode();
			 }
		 
		 @Override
		 public boolean equals (final Object autre) {
			 if (this==autre) {
				 return true;
			 }
			 if (!(autre instanceof Move)) {
				 return false;
			 }
			 final Attaque autreAttaque= (Attaque) autre;
			 return super.equals(autre) 
					 && getPieceAttaquee().equals(autreAttaque.getPieceAttaquee());
		 }
	}
	
	/* /*********** classe qui crée les déplacements ***********

	public static class MoveFactory {
		
		private MoveFactory() {
			//cette classe n'est pas instanciable
			throw new RuntimeException ("Vous ne pouvez pas instancier cette classe");
		}
		
		public static Move creerMove (final Echec echec,
									final int coordonneeActuel,
									final int coordonneeDestination) {
			for (final Move deplacement : echec.getMoves()) {
				if (deplacement.getCoordonneeActuel() ==coordonneeActuel &&
					deplacement.getDestination() ==coordonneeDestination){
						return deplacement;
					}
			}
			return null;
		}
	}*/
	
	
	/*********** enum qui retourne l'état des déplacements ***********/
	public enum MoveStatus {

        DONE {
            @Override
            public boolean isDone() {
                return true;
            }
        },        
        FAIL{
            @Override
            public boolean isDone() {
                return false;
            }
        };
        public abstract boolean isDone();
	}
	
}
	

