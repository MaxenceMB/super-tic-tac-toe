
public class MegaControleur {
	
	private static VueMorpion[] vues = new VueMorpion[9];
	
	public MegaControleur(VueMorpion[] fenetres) {
		vues = fenetres;
	}
	
	public static void forceFocus(int index) {
		vues[index].setEnabled(true);
		vues[index].focus();
		for(int i = 0; i < 9; i++) {
			if(i != index) {
				vues[i].setEnabled(false);
				vues[i].noFocus();
			}
		}
	}

}
