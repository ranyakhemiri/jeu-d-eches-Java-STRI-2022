package graphique;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import maps.Grille;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

import javax.swing.JTextArea;



public class Windows extends JFrame{
	private static final long serialVersionUID = 4207783445510444454L;
	public String TOUR_JEU = "Fee";
	public Color selected = new Color(100,100,0);
	public void setTOUR_JEU(String tOUR_JEU) {
		TOUR_JEU = tOUR_JEU;
	}

	public Windows() {
		setTitle("JWinx");
		setSize(800,800);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 784, 16);
		getContentPane().add(toolBar);

		/* Partie adaptative */
		/* Affichage du tour en cour */
		JTextField textField_tourdejeu = new JTextField("C'est au tour de l'�quipe "+TOUR_JEU);
		textField_tourdejeu.setBounds(10, 27, 185, 20);
		textField_tourdejeu.setEditable(false);
		getContentPane().add(textField_tourdejeu);
		
		/* Affichage de la console */
		JTextArea textField_event = new JTextArea();
		textField_event.setToolTipText("");
		textField_event.setBounds(10, 58, 764, 29);
		textField_event.setEditable(false);
		getContentPane().add(textField_event);
		
		/* Cr�ation de la grille */
		Grille grille = new Grille(); 
		grille.init_map();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9,7));
		panel.setBounds(10, 98, 764, 652);
		JToggleButton[] Jcase = new JToggleButton[64];
		for (int i = 0;i<64;i++) {
			ImageIcon icon = new ImageIcon("art/"+grille.getMap(i).getOccupant().getSymbole()+".png");
			JToggleButton Case = new JToggleButton();
			Case.setIcon(icon);
			if (switch_int()%2==0)
			{
				Case.setBackground(new Color(0,86,27));
			}
			else Case.setBackground(new Color(253,108,158));
			
			panel.add(Case);
			Jcase[i] = Case;
			Case.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int count = 0;
					for (int y = 0;y<64;y++) {
						if (Jcase[y].isSelected()) {
							count++;
							System.out.println(grille.getMap(y).getPosition());
						}
						if (count > 2) {
							for (int z = 0;z<64;z++) {
								Jcase[y].setSelected(false);
							}
						}
					}
					}
				}
			);
		}
		getContentPane().add(panel);
	}
	public int integer = 0;
	public int switch_int() {
		integer++;
		for (int i=0;i<64;i+=9) {
			if (integer == i) {
				integer++;
			}
		}
		return integer;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				UIManager.put("swing.blodMetal", Boolean.FALSE);
				new Windows().setVisible(true);
			}
		});
	}
}