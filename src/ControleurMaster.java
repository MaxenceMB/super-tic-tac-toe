import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ControleurMaster implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		
		if(b.getText().equals("Recommencer")) {
			System.out.println("Recommencer");
		} else if(b.getText().equals("Quitter")) {
			System.out.println("Quitter");
		}
	}

}
