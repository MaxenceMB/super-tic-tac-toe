
// Classe principale du jeu, si on veut jouer: c'est ça qu'il faut lancer.
public class SuperTicTacToe {
	
	/* L'algorithme est le suivant:
	 * getTailleEcran get la taille de l'écran du joueur
	 * Ensuit ça créé les 9 fenêtre des jeux
	 * puis la fenêtre master
	 * Ensuite ça lance le setup du controleur principale et le jeux peux commencer
	 */
	public static void main(String[] args) {
		ModeleMorpion.getTailleEcran(); // Récupère les infos de l'écran pour tout placer correctement

		// Créé la fenêtre master
		VueGameMaster gm = new VueGameMaster((int)ModeleMorpion.getInfos(-1)[0], (int)ModeleMorpion.getInfos(-1)[1], (String)ModeleMorpion.getInfos(-1)[2]);
		gm.setVisible(true);
		
		// Créé les 9 fenêtres du jeu et les envoie au MegaControleur
		ControleurMorpion[] controleurs = new ControleurMorpion[9];
		for(int i = 0; i < 9; i++) {
			Object[] infos = ModeleMorpion.getInfos(i);
			
			VueMorpion frame = new VueMorpion((int)infos[0], (int)infos[1], (String)infos[2], i);
			frame.setVisible(true);
			
			controleurs[i] = frame.getControleur();
		}
		
		// Lance le setup du controleur
		MegaControleur.setup(controleurs, gm);
	}
}
