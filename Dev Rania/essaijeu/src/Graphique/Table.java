package Graphique;

import javax.swing.*;
import java.awt.*;


public class Table {
	private final JFrame gameFrame;
	
	public Table() {
		this.gameFrame= new JFrame("JChess");
		
		this.gameFrame.setSize(600,600);
		this.gameFrame.setVisible(true);
	}
}
