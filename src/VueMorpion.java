import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class VueMorpion extends JFrame {
	
	private BoutonMorpion[] boutons = new BoutonMorpion[9];
	
	private boolean libre;
	private Joueur  vainqueur;
	private int     id;

	
	public VueMorpion(int posX, int posY, String title, int id) {
		
		// Création de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(posX, posY, 300, 300);
		setTitle(title);
		setResizable(false);
		
		ControleurMorpion controleur = new ControleurMorpion(this);
		this.libre     = true;
		this.vainqueur = Joueur.NONE;
		this.id        = id;
		
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
		
		focus(); // Pour que par défaut on puis jouer partout
	}
	
	// Empêche le joueur d'intéragir avec la fenêtre (grise les boutons et désactive la fenêtre)
	public void unfocus() {
		for(int i = 0; i < 9; i++) {
			this.boutons[i].setBackground(Color.LIGHT_GRAY);
		}
		this.setEnabled(false);
	}
	
	// Permet au joueur d'intéragir avec la fenêtre (les boutons deviennent clair et active la fenêtre)
	public void focus() {
		for(int i = 0; i < 9; i++) {
			this.boutons[i].setBackground(Color.WHITE);
		}
		this.setEnabled(true);
	}
	
	// Affiche en gros le vainqueur
	public void finPartie(Joueur j) {
		String path = String.format("/icons/%s_win/", j.toString().toLowerCase());
		for(int i = 0; i < 9; i++) {
			boutons[i].setIcon(new ImageIcon(ModeleMorpion.class.getResource(path+i+".png")));
		}
		
		this.libre = false; // La fenêtre n'est plus jouable
		this.vainqueur = j; // Associe le vainqueur
		unfocus();
	}

	// Renvoie vrai si le bouton cliqué n'est associé à aucun joueur
	public boolean estVide(BoutonMorpion bouton) {
		return (bouton.getJoueur() == Joueur.NONE);
	}
	
	// Renvoie vrai si la fenêtre est jouable
	public boolean estLibre() {
		return this.libre;
	}
	
	// Renvoie le vainqueur de la partie
	public Joueur getVainqueur() {
		return this.vainqueur;
	}
	
	// Renvoie l'id de la fenêtre (l'emplacement)
	public int getId() {
		return this.id;
	}
	
	// Renvoie une liste contenant tous les boutons
	public BoutonMorpion[] getBoutons() {
		return this.boutons;
	}
	
	// Raffraichit un bouton dans la liste
	public void setBouton(BoutonMorpion bouton) {
		this.boutons[bouton.getPos()] = bouton;
	}
}
