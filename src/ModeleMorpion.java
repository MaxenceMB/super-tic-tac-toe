import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ModeleMorpion {
	
	private static int screenWidth, screenHeight;
	private static Joueur joueur = Joueur.O;
	
	
	// Jeu
	public static boolean checkWin(BoutonMorpion[] grille, int boutonPos) {
		boolean win = false;
		
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
	
	
	public static void victoire(Joueur j) {
		System.out.println("PARTIE GAGNÉE PAR LE JOUEUR " + j.toString());
	}
	
	
	
	// Joueur
	public static Joueur getJoueur() {
		return joueur;
	}
	
	public static void nextJoueur() {
		if(joueur == Joueur.O) {
			joueur = Joueur.X;
		} else {
			joueur = Joueur.O;
		}
	}
	
	
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
	
	
	
	// Ecran
	public static void getScreenSize() {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); 
	    
		ModeleMorpion.screenWidth  = (int)size.getWidth(); 
		ModeleMorpion.screenHeight = (int)size.getHeight(); 
	}
	
	public static Object[] getInfos(int pos) {
		Object[] infos = new Object[3];
		
		switch(pos) {
			case 0:
				infos[0] = screenWidth/2  - 450;
				infos[1] = screenHeight/2 - 456;
				
				infos[2] = "T";
				break;
				
			case 1:
				infos[0] = screenWidth/2  - 150;
				infos[1] = screenHeight/2 - 456;
				
				infos[2] = "I";
				break;
				
			case 2:
				infos[0] = screenWidth/2  + 150;
				infos[1] = screenHeight/2 - 456;
				
				infos[2] = "C";
				break;
				
			case 3:
				infos[0] = screenWidth/2  - 450;
				infos[1] = screenHeight/2 - 150;
				
				infos[2] = "T";
				break;
				
			case 4:
				infos[0] = screenWidth/2  - 150;
				infos[1] = screenHeight/2 - 150;
				
				infos[2] = "A";
				break;
				
			case 5:
				infos[0] = screenWidth/2  + 150;
				infos[1] = screenHeight/2 - 150;
				
				infos[2] = "C";
				break;
				
			case 6:
				infos[0] = screenWidth/2  - 450;
				infos[1] = screenHeight/2 + 156;
				
				infos[2] = "T";
				break;
				
			case 7:
				infos[0] = screenWidth/2  - 150;
				infos[1] = screenHeight/2 + 156;
				
				infos[2] = "O";
				break;
				
			case 8:
				infos[0] = screenWidth/2  + 150;
				infos[1] = screenHeight/2 + 156;
				
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
