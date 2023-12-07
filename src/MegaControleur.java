
public class MegaControleur {
	
	private static VueMorpion[] vues = new VueMorpion[9]; // Liste des fenêtres
	private static int vueCourante = -1;                  // Fenêtre courante
	
	public MegaControleur(VueMorpion[] fenetres) {
		vues = fenetres;
	}
	
	// Force le focus sur la fenêtre souhaitée, si on peut pas, permet de jouer partout
	public static void forceFocus(int index) {
		if(vues[index].estLibre()) {
			vues[index].focus();
			for(int i = 0; i < 9; i++) {
				if(i != index) {
					vues[i].unfocus();
				}
			}
		} else {
			for(int i = 0; i < 9; i++) {
				if(vues[i].estLibre()) {
					vues[i].focus();
				}
			}
		}
	}

	// Check si le joueur a gagné en fonction de la partie qu'il vient de gagner
	public static boolean checkVictoire(int indexVue) {
	    boolean win = false;

	    // En fonction de quelle partie vient d'être gagnée, check les possibilités des wins possibles
	    switch(indexVue) {
	        case 0:
	                 if (checkLigne(1, 2, ModeleMorpion.getJoueur())) win = true; //top lane
	            else if (checkLigne(3, 6, ModeleMorpion.getJoueur())) win = true; //left col
	            else if (checkLigne(4, 8, ModeleMorpion.getJoueur())) win = true; //antislash
	            break;

	        case 1:
	            	 if (checkLigne(0, 2, ModeleMorpion.getJoueur())) win = true; //top lane
	            else if (checkLigne(4, 7, ModeleMorpion.getJoueur())) win = true; //mid col
	            break;

	        case 2:
	            	 if (checkLigne(0, 1, ModeleMorpion.getJoueur())) win = true; //top lane
	            else if (checkLigne(4, 6, ModeleMorpion.getJoueur())) win = true; //slash
	            else if (checkLigne(5, 8, ModeleMorpion.getJoueur())) win = true; //right col
	            break;

	        case 3:
	            	 if (checkLigne(4, 5, ModeleMorpion.getJoueur())) win = true; //mid lane
	            else if (checkLigne(0, 6, ModeleMorpion.getJoueur())) win = true; //left col
	            break;

	        case 4:
	            	 if (checkLigne(3, 5, ModeleMorpion.getJoueur())) win = true; //mid lane
	            else if (checkLigne(1, 7, ModeleMorpion.getJoueur())) win = true; //mid col
	            else if (checkLigne(0, 8, ModeleMorpion.getJoueur())) win = true; //antislash
	            else if (checkLigne(2, 6, ModeleMorpion.getJoueur())) win = true; //slash
	            break;

	        case 5:
	            	 if (checkLigne(3, 4, ModeleMorpion.getJoueur())) win = true; //mid lane
	            else if (checkLigne(2, 8, ModeleMorpion.getJoueur())) win = true; //right col
	            break;

	        case 6:
	            	 if (checkLigne(7, 8, ModeleMorpion.getJoueur())) win = true; //bot lane
	            else if (checkLigne(0, 3, ModeleMorpion.getJoueur())) win = true; //left col
	            else if (checkLigne(4, 2, ModeleMorpion.getJoueur())) win = true; //slash
	            break;

	        case 7:
	            	 if (checkLigne(6, 8, ModeleMorpion.getJoueur())) win = true; //bot lane
	            else if (checkLigne(1, 4, ModeleMorpion.getJoueur())) win = true; //mid col
	            break;

	        case 8:
	            	 if (checkLigne(6, 7, ModeleMorpion.getJoueur())) win = true; //bot lane
	            else if (checkLigne(2, 5, ModeleMorpion.getJoueur())) win = true; //right col
	            else if (checkLigne(4, 0, ModeleMorpion.getJoueur())) win = true; //antislash
	            break;
	    }
	    return win;
	}
	
	// Regarde si le joueur à 3 parties gagnées alignées
	private static boolean checkLigne(int case1, int case2, Joueur j) {
		return vues[case1].getVainqueur() == j && vues[case2].getVainqueur() == j;
	}
	
	// La vrai win sa mère
	public static void bigWin() {
		for(int i = 0; i < 9; i++) {
			vues[i].dispose();
		}
	}

	// Renvoie l'id de la fenêtre courante
	public static int getCourant() {
		return vueCourante;
	}
	
	// Enregistre la fenêtre courante
	public static void setCourant(int id) {
		vueCourante = id;
	}


}
