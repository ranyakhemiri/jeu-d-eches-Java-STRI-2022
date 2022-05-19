package Protagonistes;

import Joueurs.Joueur;
import Joueurs.JoueurFee;
import Joueurs.JoueurSorciere;

public enum Camps {
	SORCIERE(){
		public boolean isSorciere() {
			return true;
		}
		public boolean isFee() {
			return false;
		}
		@Override
		public Joueur choisirJoueur(JoueurFee joueurFee, JoueurSorciere joueurSorciere) {
			return joueurSorciere;}
		
		@Override
		public String toString() {
		    return "Sorciere";
		     }
	},
	FEE(){
		public boolean isFee() {
			return false;
		}
		public boolean isSorciere() {
			return false;
		}
		@Override
		public Joueur choisirJoueur(JoueurFee joueurFee, JoueurSorciere joueurSorciere) {
			return joueurFee;
		}
		@Override
		public String toString() {
		    return "Fee";
		   }
	};

	public abstract boolean isFee();
	public abstract boolean isSorciere();

	public abstract Joueur choisirJoueur(JoueurFee joueurFee, JoueurSorciere joueurSorciere);
	
}
