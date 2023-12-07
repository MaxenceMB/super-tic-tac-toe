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
				     if(grille[1].getJoueur() == ModeleMorpion.joueur && grille[2].getJoueur() == ModeleMorpion.joueur) win = true; //top lane
				else if(grille[3].getJoueur() == ModeleMorpion.joueur && grille[6].getJoueur() == ModeleMorpion.joueur) win = true; //left col
				else if(grille[4].getJoueur() == ModeleMorpion.joueur && grille[8].getJoueur() == ModeleMorpion.joueur) win = true; //antislash				     
				break;
				
			case 1:
			    	 if(grille[0].getJoueur() == ModeleMorpion.joueur && grille[2].getJoueur() == ModeleMorpion.joueur) win = true; //top lane
				else if(grille[4].getJoueur() == ModeleMorpion.joueur && grille[7].getJoueur() == ModeleMorpion.joueur) win = true; //mid col   
				break;
				
			case 2:
				     if(grille[0].getJoueur() == ModeleMorpion.joueur && grille[1].getJoueur() == ModeleMorpion.joueur) win = true; //top lane
				else if(grille[4].getJoueur() == ModeleMorpion.joueur && grille[6].getJoueur() == ModeleMorpion.joueur) win = true; //slash
				else if(grille[5].getJoueur() == ModeleMorpion.joueur && grille[8].getJoueur() == ModeleMorpion.joueur) win = true; //right col
				break;
				
			case 3:
				     if(grille[4].getJoueur() == ModeleMorpion.joueur && grille[5].getJoueur() == ModeleMorpion.joueur) win = true; //mid lane
				else if(grille[0].getJoueur() == ModeleMorpion.joueur && grille[6].getJoueur() == ModeleMorpion.joueur) win = true; //left col
			    break;
				
			case 4:
					 if(grille[3].getJoueur() == ModeleMorpion.joueur && grille[5].getJoueur() == ModeleMorpion.joueur) win = true; //mid lane
				else if(grille[1].getJoueur() == ModeleMorpion.joueur && grille[7].getJoueur() == ModeleMorpion.joueur) win = true; //mid col
				else if(grille[0].getJoueur() == ModeleMorpion.joueur && grille[8].getJoueur() == ModeleMorpion.joueur) win = true; //antislash
				else if(grille[2].getJoueur() == ModeleMorpion.joueur && grille[6].getJoueur() == ModeleMorpion.joueur) win = true; //slash
				break;
				
			case 5:
					 if(grille[3].getJoueur() == ModeleMorpion.joueur && grille[4].getJoueur() == ModeleMorpion.joueur) win = true; //mid lane
				else if(grille[2].getJoueur() == ModeleMorpion.joueur && grille[8].getJoueur() == ModeleMorpion.joueur) win = true; //right col
				break;
				
			case 6:
				     if(grille[7].getJoueur() == ModeleMorpion.joueur && grille[8].getJoueur() == ModeleMorpion.joueur) win = true; //bot lane
			    else if(grille[0].getJoueur() == ModeleMorpion.joueur && grille[3].getJoueur() == ModeleMorpion.joueur) win = true; //left col
			    else if(grille[4].getJoueur() == ModeleMorpion.joueur && grille[2].getJoueur() == ModeleMorpion.joueur) win = true; //slash
				break;
				
			case 7:
			         if(grille[6].getJoueur() == ModeleMorpion.joueur && grille[8].getJoueur() == ModeleMorpion.joueur) win = true; //bot lane
				else if(grille[1].getJoueur() == ModeleMorpion.joueur && grille[4].getJoueur() == ModeleMorpion.joueur) win = true; //mid col
				break;
				
			case 8:     
					 if(grille[6].getJoueur() == ModeleMorpion.joueur && grille[7].getJoueur() == ModeleMorpion.joueur) win = true; //bot lane
				else if(grille[2].getJoueur() == ModeleMorpion.joueur && grille[5].getJoueur() == ModeleMorpion.joueur) win = true; //right col
				else if(grille[4].getJoueur() == ModeleMorpion.joueur && grille[0].getJoueur() == ModeleMorpion.joueur) win = true; //antislash
				break;
		}
		return win;
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
				infos[0] = 10;
				infos[1] = 10;
				
				infos[2] = "X";
		}
		
		return infos;
	}
}
