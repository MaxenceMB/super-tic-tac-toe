import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ControleurMorpion implements ActionListener {
	
	private VueMorpion vue;
	private Etat etat;

	public ControleurMorpion(VueMorpion vue) {
		this.vue  = vue;
		this.etat = Etat.JEU;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BoutonMorpion bouton = (BoutonMorpion)e.getSource();
		switch(this.etat) {
			case JEU:
				if(vue.estVide(bouton)) {
					bouton.setIcon(ModeleMorpion.getIconJoueur(ModeleMorpion.getJoueur()));
					bouton.setJoueur(ModeleMorpion.getJoueur());
					vue.setBouton(bouton);
					
					MegaControleur.forceFocus(bouton.getPos());
				}
				
				if(ModeleMorpion.checkWin(vue.getBoutons(), bouton.getPos())) {
					this.etat = Etat.FIN;
					ModeleMorpion.victoire(ModeleMorpion.getJoueur());
					vue.finPartie(ModeleMorpion.getJoueur());
				}
				ModeleMorpion.nextJoueur();
				
				break;
				
			case FIN:
				System.out.println("Partie terminée.");
				break;
				
			default:
				break;
		}
	}

}
