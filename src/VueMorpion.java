import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class VueMorpion extends JFrame {
	
	private BoutonMorpion[] boutons = new BoutonMorpion[9];

	public VueMorpion(int posX, int posY, String title) {
		
		// Création de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(posX, posY, 300, 300);
		setTitle(title);
		setResizable(false);
		
		ControleurMorpion controleur = new ControleurMorpion(this);
		
		// Pannel principal (grid 3x3)
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(3, 3, 0, 0));
		setContentPane(contentPane);
		
		// Ajout des boutons
		for (int i = 0; i < 9; i++) {
		    boutons[i] = new BoutonMorpion(i);
		    boutons[i].addActionListener(controleur);
		    contentPane.add(boutons[i]);
		}
		
		focus();
	}
	
	public void noFocus() {
		for(int i = 0; i < 9; i++) {
			this.boutons[i].setBackground(Color.LIGHT_GRAY);
		}
	}
	
	public void focus() {
		for(int i = 0; i < 9; i++) {
			this.boutons[i].setBackground(Color.WHITE);
		}
	}
	
	public void finPartie(Joueur j) {
		String path = String.format("/icons/%s_win/", j.toString().toLowerCase());
		for(int i = 0; i < 9; i++) {
			boutons[i].setIcon(new ImageIcon(ModeleMorpion.class.getResource(path+i+".png")));
		}
	}

	public boolean estVide(JButton bouton) {
		if(bouton.getIcon() == null) {
			return true;
		} else {
			return false;
		}
	}
	
	public BoutonMorpion[] getButtons() {
		return this.boutons;
	}
	
	public void setButton(BoutonMorpion bouton) {
		this.boutons[bouton.getPos()] = bouton;
	}
}
