package Protagonistes;

import Joueurs.Joueur;
import Joueurs.JoueurFee;
import Joueurs.JoueurSorciere;

public enum Camps {
	SORCIERE{
		public boolean isSorciere() {
			return true;
		}
		public boolean isFee() {
			return false;
		}
		@Override
		public Joueur choisirJoueur(JoueurFee joueurFee, JoueurSorciere joueurSorciere) {
			return joueurSorciere;
		}
	},
	FEE{
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
	};

	public abstract boolean isFee();
	public abstract boolean isSorciere();

	public abstract Joueur choisirJoueur(JoueurFee joueurFee, JoueurSorciere joueurSorciere);
	
}
