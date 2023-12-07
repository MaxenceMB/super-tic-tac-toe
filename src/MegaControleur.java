
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
	                 if(vues[1].getVainqueur() == ModeleMorpion.getJoueur() && vues[2].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //top lane
	            else if(vues[3].getVainqueur() == ModeleMorpion.getJoueur() && vues[6].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //left col
	            else if(vues[4].getVainqueur() == ModeleMorpion.getJoueur() && vues[8].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //antislash
	            break;

	        case 1:
	                 if(vues[0].getVainqueur() == ModeleMorpion.getJoueur() && vues[2].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //top lane
	            else if(vues[4].getVainqueur() == ModeleMorpion.getJoueur() && vues[7].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //mid col
	            break;

	        case 2:
	                 if(vues[0].getVainqueur() == ModeleMorpion.getJoueur() && vues[1].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //top lane
	            else if(vues[4].getVainqueur() == ModeleMorpion.getJoueur() && vues[6].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //slash
	            else if(vues[5].getVainqueur() == ModeleMorpion.getJoueur() && vues[8].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //right col
	            break;

	        case 3:
	                 if(vues[4].getVainqueur() == ModeleMorpion.getJoueur() && vues[5].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //mid lane
	            else if(vues[0].getVainqueur() == ModeleMorpion.getJoueur() && vues[6].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //left col
	            break;

	        case 4:
	                 if(vues[3].getVainqueur() == ModeleMorpion.getJoueur() && vues[5].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //mid lane
	            else if(vues[1].getVainqueur() == ModeleMorpion.getJoueur() && vues[7].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //mid col
	            else if(vues[0].getVainqueur() == ModeleMorpion.getJoueur() && vues[8].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //antislash
	            else if(vues[2].getVainqueur() == ModeleMorpion.getJoueur() && vues[6].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //slash
	            break;

	        case 5:
	                 if(vues[3].getVainqueur() == ModeleMorpion.getJoueur() && vues[4].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //mid lane
	            else if(vues[2].getVainqueur() == ModeleMorpion.getJoueur() && vues[8].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //right col
	            break;

	        case 6:
	                 if(vues[7].getVainqueur() == ModeleMorpion.getJoueur() && vues[8].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //bot lane
	            else if(vues[0].getVainqueur() == ModeleMorpion.getJoueur() && vues[3].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //left col
	            else if(vues[4].getVainqueur() == ModeleMorpion.getJoueur() && vues[2].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //slash
	            break;

	        case 7:
	                 if(vues[6].getVainqueur() == ModeleMorpion.getJoueur() && vues[8].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //bot lane
	            else if(vues[1].getVainqueur() == ModeleMorpion.getJoueur() && vues[4].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //mid col
	            break;

	        case 8:
	                 if(vues[6].getVainqueur() == ModeleMorpion.getJoueur() && vues[7].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //bot lane
	            else if(vues[2].getVainqueur() == ModeleMorpion.getJoueur() && vues[5].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //right col
	            else if(vues[4].getVainqueur() == ModeleMorpion.getJoueur() && vues[0].getVainqueur() == ModeleMorpion.getJoueur()) win = true; //antislash
	            break;
	    }
	    return win;
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
