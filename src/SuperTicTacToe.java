
// Classe principale du jeu, si on veut jouer: c'est ça qu'il faut lancer.
public class SuperTicTacToe {

	public static void main(String[] args) {
		ModeleMorpion.getTailleEcran(); // Récupère les infos de l'écran pour tout placer correctement

		// Créé les 9 fenêtres du jeu et les envoie au MegaControleur
		VueMorpion[] vues = new VueMorpion[9];
		for(int i = 0; i < 9; i++) {
			Object[] infos = ModeleMorpion.getInfos(i);
			
			VueMorpion frame = new VueMorpion((int)infos[0], (int)infos[1], (String)infos[2], i);
			frame.setVisible(true);
			
			vues[i] = frame;
		}
		new MegaControleur(vues);
	}
}
