import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

@SuppressWarnings("serial")
public class VueMorpion extends JFrame {
	
	private BoutonMorpion[] boutons = new BoutonMorpion[9];
	private ControleurMorpion controleur;
	
	public VueMorpion(int posX, int posY, String title, int id) {
		
		// Création de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(posX, posY, 300, 300);
		setTitle(title);
		setResizable(false);
		
		this.controleur = new ControleurMorpion(this, id);
		
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
		
		this.controleur.focus(); // Pour que par défaut on puis jouer partout
	}

	// Renvoie vrai si le bouton cliqué n'est associé à aucun joueur
	public boolean estVide(BoutonMorpion bouton) {
		return (bouton.getJoueur() == Joueur.NONE);
	}
	
	// Renvoie une liste contenant tous les boutons
	public BoutonMorpion[] getBoutons() {
		return this.boutons;
	}
	
	// Raffraichit un bouton dans la liste
	public void setBouton(BoutonMorpion bouton) {
		this.boutons[bouton.getPos()] = bouton;
	}
	
	// Renvoie le controleur
	public ControleurMorpion getControleur() {
		return this.controleur;
	}
	
	// Remet tout à 0
	public void reset() {
		for(int i = 0; i < 9; i++) {
			this.boutons[i].setJoueur(Joueur.NONE);
			this.boutons[i].setIcon(null);
		}
	}
}
