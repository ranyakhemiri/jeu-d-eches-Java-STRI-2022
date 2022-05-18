package test_fonctionnels;

import Echiquier.Echec;
import Graphique.Table;

public class JChess {
	public static void main(String[] args) {
		Echec echec= Echec.initialiserEchiquier();
		System.out.println(echec);
	}
	
	Table table= new Table();
}
