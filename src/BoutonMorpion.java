import javax.swing.JButton;

public class BoutonMorpion extends JButton {
	
	private int pos;
	private Joueur joueur;
	
	public BoutonMorpion(int pos) {
		super();
		
		this.pos = pos;
		this.joueur = Joueur.NONE;
	}
	
	public int getPos() {
		return this.pos;
	}
	
	public Joueur getJoueur() {
		return this.joueur;
	}
	
	public void setJoueur(Joueur j) {
		this.joueur = j;
	}
	
	@Override
	public String toString() {
		return String.format("[BOUTON MORPION] id = %d | Joueur = %s", this.pos, this.joueur.toString());
	}

}
