import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ControleurMaster implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		if(b.getText().equals("Recommencer")) {
			MegaControleur.getInstance().recommencer();
		} else if(b.getText().equals("Quitter")) {
			MegaControleur.getInstance().quitter();
		}
	}

}
