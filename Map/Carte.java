package Map;

public class Carte{
/*Taille de carte 8 cases sur 8 */
private Case[][] cases = new Case[8][8];

public Carte(Case[][] cases) {
	super();
	this.cases = cases;
}

/* fonction qui retourne si la case[x][y] est occup�e*/
public boolean case_ocupee(int x,int y) {
	return cases[x][y].occupant();
}

/* fonction qui retourne si sous la case, [x][y], il y a un tresor */
public boolean case_tresor(int x,int y) {
	return cases[x][y].tresor();
}
}
