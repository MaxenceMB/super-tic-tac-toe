
public class MegaControleur {
	
	private ControleurMorpion[] jeux = new ControleurMorpion[9]; // Liste des fenêtres
	private VueGameMaster master;								 // VueGameMaster
	private int vueCourante = -1;                                // Fenêtre courante
	
	private static MegaControleur instance;
	
	
	private MegaControleur() {}
	
	public static void setup(ControleurMorpion[] controleurs, VueGameMaster vueMaster) {
		instance = new MegaControleur();
		
		instance.jeux   = controleurs;
		instance.master = vueMaster;
	}
	
	// Singleton
	public static MegaControleur getInstance() {
		if(instance == null) {
			System.out.println("L'instance n'existe pas, le setup n'a probablement pas été fait.");
		}
		return instance;
	}
	
	// Update le joueur actif du jeu dans la fenetre GameMaster
	public void updateMasterJoueur(Joueur j) {
		master.setJoueurActif(j);
	}
	
	// Force le focus sur la fenêtre souhaitée, si on peut pas, permet de jouer partout
	public void forceFocus(int index) {
		if(jeux[index].estLibre()) {
			jeux[index].focus();
			for(int i = 0; i < 9; i++) {
				if(i != index) {
					jeux[i].unfocus();
				}
			}
		} else {
			for(int i = 0; i < 9; i++) {
				if(jeux[i].estLibre()) {
					jeux[i].focus();
				}
			}
		}
	}

	// Check si le joueur a gagné en fonction de la partie qu'il vient de gagner
	public boolean checkVictoire(int indexVue) {
	    boolean win = false;

	    // En fonction de quelle partie vient d'être gagnée, check les possibilités des wins possibles
	    switch(indexVue) {
	        case 0:
	                 if (checkLigne(1, 2, ModeleMorpion.getInstance().getJoueur())) win = true; //top lane
	            else if (checkLigne(3, 6, ModeleMorpion.getInstance().getJoueur())) win = true; //left col
	            else if (checkLigne(4, 8, ModeleMorpion.getInstance().getJoueur())) win = true; //antislash
	            break;

	        case 1:
	            	 if (checkLigne(0, 2, ModeleMorpion.getInstance().getJoueur())) win = true; //top lane
	            else if (checkLigne(4, 7, ModeleMorpion.getInstance().getJoueur())) win = true; //mid col
	            break;

	        case 2:
	            	 if (checkLigne(0, 1, ModeleMorpion.getInstance().getJoueur())) win = true; //top lane
	            else if (checkLigne(4, 6, ModeleMorpion.getInstance().getJoueur())) win = true; //slash
	            else if (checkLigne(5, 8, ModeleMorpion.getInstance().getJoueur())) win = true; //right col
	            break;

	        case 3:
	            	 if (checkLigne(4, 5, ModeleMorpion.getInstance().getJoueur())) win = true; //mid lane
	            else if (checkLigne(0, 6, ModeleMorpion.getInstance().getJoueur())) win = true; //left col
	            break;

	        case 4:
	            	 if (checkLigne(3, 5, ModeleMorpion.getInstance().getJoueur())) win = true; //mid lane
	            else if (checkLigne(1, 7, ModeleMorpion.getInstance().getJoueur())) win = true; //mid col
	            else if (checkLigne(0, 8, ModeleMorpion.getInstance().getJoueur())) win = true; //antislash
	            else if (checkLigne(2, 6, ModeleMorpion.getInstance().getJoueur())) win = true; //slash
	            break;

	        case 5:
	            	 if (checkLigne(3, 4, ModeleMorpion.getInstance().getJoueur())) win = true; //mid lane
	            else if (checkLigne(2, 8, ModeleMorpion.getInstance().getJoueur())) win = true; //right col
	            break;

	        case 6:
	            	 if (checkLigne(7, 8, ModeleMorpion.getInstance().getJoueur())) win = true; //bot lane
	            else if (checkLigne(0, 3, ModeleMorpion.getInstance().getJoueur())) win = true; //left col
	            else if (checkLigne(4, 2, ModeleMorpion.getInstance().getJoueur())) win = true; //slash
	            break;

	        case 7:
	            	 if (checkLigne(6, 8, ModeleMorpion.getInstance().getJoueur())) win = true; //bot lane
	            else if (checkLigne(1, 4, ModeleMorpion.getInstance().getJoueur())) win = true; //mid col
	            break;

	        case 8:
	            	 if (checkLigne(6, 7, ModeleMorpion.getInstance().getJoueur())) win = true; //bot lane
	            else if (checkLigne(2, 5, ModeleMorpion.getInstance().getJoueur())) win = true; //right col
	            else if (checkLigne(4, 0, ModeleMorpion.getInstance().getJoueur())) win = true; //antislash
	            break;
	    }
	    return win;
	}
	
	// Regarde si le joueur à 3 parties gagnées alignées
	private boolean checkLigne(int case1, int case2, Joueur j) {
		return jeux[case1].getVainqueur() == j && jeux[case2].getVainqueur() == j;
	}
	
	// La vrai win sa mère
	public void bigWin() {
		for(int i = 0; i < 9; i++) {
			jeux[i].unfocus();
		}
	}

	// Renvoie l'id de la fenêtre courante
	public int getCourant() {
		return vueCourante;
	}
	
	// Enregistre la fenêtre courante
	public void setCourant(int id) {
		vueCourante = id;
	}


}
