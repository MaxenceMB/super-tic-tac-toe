
public class main {

	public static void main(String[] args) {
		ModeleMorpion.getScreenSize();
		
		
		for(int i = 0; i < 9; i++) {
			Object[] infos = ModeleMorpion.getInfos(i);
			VueMorpion frame = new VueMorpion((int)infos[0], (int)infos[1], (String)infos[2]);
			frame.setVisible(true);
		}
	}
}