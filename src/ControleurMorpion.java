import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class ControleurMorpion implements ActionListener {
	
	private VueMorpion vue;
	
	private boolean libre;
	private Joueur  vainqueur;
	private int     id;
	
	public ControleurMorpion(VueMorpion vue, int id) {
		this.vue  = vue;

		this.libre     = true;
		this.vainqueur = Joueur.NONE;
		this.id        = id;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MegaControleur.setCourant(getId());				         // Assigne la fenêtre courante à celle qu'on vient de cliquer
		BoutonMorpion bouton    = (BoutonMorpion)e.getSource();  // Récupère le bouton source de l'action
		boolean       peutJouer = true;						     // Permet de controler la fin du jeu
		Joueur        joueur    = ModeleMorpion.getJoueur();     // Récupère le joueur qui vient de jouer
		
		// Si le bouton est vide (pas encore joué ici)
		if(vue.estVide(bouton)) {
			bouton.setJoueur(joueur);  // On associe le joueur à la case
			vue.setBouton(bouton);	   // On raffraichit la liste des boutons de la fenêtre
		}
		
		// On check si le joueur vient de gagner
		if(ModeleMorpion.checkVictoire(vue.getBoutons(), bouton.getPos())) {
			finPartie(joueur);       // Si c'est le cas, gg, on affiche sa victoire
			this.libre = false;      // La fenêtre n'est plus jouable
			this.vainqueur = joueur; // Associe le vainqueur
			
			// On check si sa victoire lui a fait gagner le jeu entier
			if(MegaControleur.checkVictoire(getId())) {
				peutJouer = false;        // Si c'est le cas, on stop tout
				MegaControleur.bigWin();  // Big big win, gros gg
			} else {
				peutJouer = true;         // Sinon on peut continuer
			}
		}
		
		// Si on peut jouer
		if (peutJouer) {
			MegaControleur.forceFocus(bouton.getPos());  // On force le jeu dans la fenêtre correspondante
			ModeleMorpion.nextJoueur();                  // On passe au joueur suivant
		}
	}
	
	// Empêche le joueur d'intéragir avec la fenêtre (grise les boutons et désactive la fenêtre)
	public void unfocus() {
		for(int i = 0; i < 9; i++) {
			this.vue.getBoutons()[i].setBackground(Color.LIGHT_GRAY);
		}
		this.vue.setEnabled(false);
	}
	
	// Permet au joueur d'intéragir avec la fenêtre (les boutons deviennent clair et active la fenêtre)
	public void focus() {
		for(int i = 0; i < 9; i++) {
			this.vue.getBoutons()[i].setBackground(Color.WHITE);
		}
		this.vue.setEnabled(true);
	}
	
	// Affiche en gros le vainqueur
	public void finPartie(Joueur j) {
		String path = String.format("/icons/%s_win/", j.toString().toLowerCase());
		for(int i = 0; i < 9; i++) {
			this.vue.getBoutons()[i].setIcon(new ImageIcon(ModeleMorpion.class.getResource(path+i+".png")));
		}
		unfocus();
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
}
