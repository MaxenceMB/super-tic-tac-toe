import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurMorpion implements ActionListener {
	
	private VueMorpion vue;
	
	public ControleurMorpion(VueMorpion vue) {
		this.vue  = vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MegaControleur.setCourant(vue.getId());				     // Assigne la fenêtre courante à celle qu'on vient de cliquer
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
			vue.finPartie(joueur);  // Si c'est le cas, gg, on affiche sa victoire
			
			// On check si sa victoire lui a fait gagner le jeu entier
			if(MegaControleur.checkVictoire(vue.getId())) {
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

}
