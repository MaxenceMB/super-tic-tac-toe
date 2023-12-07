
public class MegaControleur {
	
	private static VueMorpion[] vues = new VueMorpion[9];
	
	public MegaControleur(VueMorpion[] fenetres) {
		vues = fenetres;
	}
	
	public static void forceFocus(int index) {
		if(vues[index].estLibre()) {
			vues[index].setEnabled(true);
			vues[index].focus();
			for(int i = 0; i < 9; i++) {
				if(i != index) {
					vues[i].setEnabled(false);
					vues[i].unfocus();
				}
			}
		} else {
			for(int i = 0; i < 9; i++) {
				if(vues[i].estLibre()) {
					vues[i].setEnabled(true);
					vues[i].focus();
				}
			}
		}
		
	}

}
