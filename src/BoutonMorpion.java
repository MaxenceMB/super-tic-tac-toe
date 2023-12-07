import javax.swing.JButton;

@SuppressWarnings("serial")
public class BoutonMorpion extends JButton {
	
	private int pos;       // id du bouton
	private Joueur joueur; // joueur associé
	
	public BoutonMorpion(int pos) {
		super();
		
		this.pos = pos;
		this.joueur = Joueur.NONE;
	}
	
	// Renvoie la position du bouton
	public int getPos() {
		return this.pos;
	}
	
	// Renvoie le joueur associé
	public Joueur getJoueur() {
		return this.joueur;
	}
	
	// Associe un joueur (icon + joueur)
	public void setJoueur(Joueur j) {
		this.setIcon(ModeleMorpion.getIconJoueur(j)); 
		this.joueur = j;
	}
	
	@Override
	public String toString() {
		return String.format("[BOUTON MORPION] id = %d | Joueur = %s", this.pos, this.joueur.toString());
	}

}
