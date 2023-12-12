import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ModeleMorpion {
	
	private static int ecranLargeur, ecranHauteur; // Dimensions de l'écran
	private static Joueur joueur = Joueur.O;	   // Joueur actif
	
	
	/// JEU \\\
	// Check si le joueur a gagné en fonction du bouton qu'il vient de cliquer
	public static boolean checkVictoire(BoutonMorpion[] grille, int boutonPos) {
	    boolean win = false;

	    // En fonction de quel bouton vient d'être cliqué, check les possibilités des wins possibles
	    switch(boutonPos) {
	        case 0:
	            	 if (checkLigne(1, 2, grille, ModeleMorpion.getJoueur())) win = true; //top lane
	            else if (checkLigne(3, 6, grille, ModeleMorpion.getJoueur())) win = true; //left col
	            else if (checkLigne(4, 8, grille, ModeleMorpion.getJoueur())) win = true; //antislash
	            break;

	        case 1:
	            	 if (checkLigne(0, 2, grille, ModeleMorpion.getJoueur())) win = true; //top lane
	            else if (checkLigne(4, 7, grille, ModeleMorpion.getJoueur())) win = true; //mid col
	            break;

	        case 2:
	            	 if (checkLigne(0, 1, grille, ModeleMorpion.getJoueur())) win = true; //top lane
	            else if (checkLigne(4, 6, grille, ModeleMorpion.getJoueur())) win = true; //slash
	            else if (checkLigne(5, 8, grille, ModeleMorpion.getJoueur())) win = true; //right col
	            break;

	        case 3:
	            	 if (checkLigne(4, 5, grille, ModeleMorpion.getJoueur())) win = true; //mid lane
	            else if (checkLigne(0, 6, grille, ModeleMorpion.getJoueur())) win = true; //left col
	            break;

	        case 4:
	            	 if (checkLigne(3, 5, grille, ModeleMorpion.getJoueur())) win = true; //mid lane
	            else if (checkLigne(1, 7, grille, ModeleMorpion.getJoueur())) win = true; //mid col
	            else if (checkLigne(0, 8, grille, ModeleMorpion.getJoueur())) win = true; //antislash
	            else if (checkLigne(2, 6, grille, ModeleMorpion.getJoueur())) win = true; //slash
	            break;

	        case 5:
	            	 if (checkLigne(3, 4, grille, ModeleMorpion.getJoueur())) win = true; //mid lane
	            else if (checkLigne(2, 8, grille, ModeleMorpion.getJoueur())) win = true; //right col
	            break;

	        case 6:
	            	 if (checkLigne(7, 8, grille, ModeleMorpion.getJoueur())) win = true; //bot lane
	            else if (checkLigne(0, 3, grille, ModeleMorpion.getJoueur())) win = true; //left col
	            else if (checkLigne(4, 2, grille, ModeleMorpion.getJoueur())) win = true; //slash
	            break;

	        case 7:
	            	 if (checkLigne(6, 8, grille, ModeleMorpion.getJoueur())) win = true; //bot lane
	            else if (checkLigne(1, 4, grille, ModeleMorpion.getJoueur())) win = true; //mid col
	            break;

	        case 8:
	            	 if (checkLigne(6, 7, grille, ModeleMorpion.getJoueur())) win = true; //bot lane
	            else if (checkLigne(2, 5, grille, ModeleMorpion.getJoueur())) win = true; //right col
	            else if (checkLigne(4, 0, grille, ModeleMorpion.getJoueur())) win = true; //antislash
	            break;
	    }
	    return win;
	}

	// Regarde si le joueur à 3 symboles alignés
	private static boolean checkLigne(int x, int y, BoutonMorpion[] grille, Joueur j) {
	    return grille[x].getJoueur() == j && grille[y].getJoueur() == j;
	}
	
	
	
	/// JOUEUR \\\
	// Renvoie le joueur
	public static Joueur getJoueur() {
		return joueur;
	}
	
	// Passe au joueur suivant
	public static void nextJoueur() {
		joueur = (joueur == Joueur.O) ? Joueur.X: Joueur.O; // Si le joueur actuel est O, on passe à X et inversement
	}
	
	// Renvoie l'icon correspondant au joueur j
	public static ImageIcon getIconJoueur(Joueur j) {
		switch(j) {
			case O:
				return new ImageIcon(ModeleMorpion.class.getResource("/icons/player_o.png"));
				
			case X:
				return new ImageIcon(ModeleMorpion.class.getResource("/icons/player_x.png"));
				
			default:
				return null;
		}
	}
	
	
	
	/// ECRAN \\\
	// Renvoie les dimensions de l'écran
	public static void getTailleEcran() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
	    
		ModeleMorpion.ecranLargeur = (int)size.getWidth(); 
		ModeleMorpion.ecranHauteur = (int)size.getHeight(); 
	}
	
	// Renvoie les positions des fenêtre ainsi que leur titre
	public static Object[] getInfos(int pos) {
		Object[] infos = new Object[3];
		
		switch(pos) {
			case -1:
				infos[0] = ecranLargeur/2 - 950;
				infos[1] = ecranHauteur/2 - 456;
			
				infos[2] = "SUPER TIC-TAC-TOE!";
				break;
				
			case 0:
				infos[0] = ecranLargeur/2 - 450;
				infos[1] = ecranHauteur/2 - 456;
				
				infos[2] = "T";
				break;
				
			case 1:
				infos[0] = ecranLargeur/2 - 150;
				infos[1] = ecranHauteur/2 - 456;
				
				infos[2] = "I";
				break;
				
			case 2:
				infos[0] = ecranLargeur/2 + 150;
				infos[1] = ecranHauteur/2 - 456;
				
				infos[2] = "C";
				break;
				
			case 3:
				infos[0] = ecranLargeur/2 - 450;
				infos[1] = ecranHauteur/2 - 150;
				
				infos[2] = "T";
				break;
				
			case 4:
				infos[0] = ecranLargeur/2 - 150;
				infos[1] = ecranHauteur/2 - 150;
				
				infos[2] = "A";
				break;
				
			case 5:
				infos[0] = ecranLargeur/2 + 150;
				infos[1] = ecranHauteur/2 - 150;
				
				infos[2] = "C";
				break;
				
			case 6:
				infos[0] = ecranLargeur/2 - 450;
				infos[1] = ecranHauteur/2 + 156;
				
				infos[2] = "T";
				break;
				
			case 7:
				infos[0] = ecranLargeur/2 - 150;
				infos[1] = ecranHauteur/2 + 156;
				
				infos[2] = "O";
				break;
				
			case 8:
				infos[0] = ecranLargeur/2 + 150;
				infos[1] = ecranHauteur/2 + 156;
				
				infos[2] = "E";
				break;
				
			default:
				infos[0] = 0;
				infos[1] = 0;
				
				infos[2] = "X";
		}
		
		return infos;
	}
}
