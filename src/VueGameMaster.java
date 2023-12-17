import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("serial")
public class VueGameMaster extends JFrame {
	
	public VueGameMaster(int posX, int posY, String title) {
		
		// Création de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(posX, posY, 500, 300);
		setTitle(title);
		setResizable(false);
		
		ControleurMaster controleur = new ControleurMaster();
		
		// Pannel principal (grid 3x3)
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTop = new JPanel();
		contentPane.add(panelTop, BorderLayout.NORTH);
		
		JLabel titre = new JLabel("Super Tic-Tac-Toe!");
		titre.setFont(new Font("HP Simplified", Font.PLAIN, 25));
		panelTop.add(titre);
		
		JPanel panelBot = new JPanel();
		panelBot.setBorder(new EmptyBorder(0, 20, 0, 20));
		panelBot.setLayout(new GridLayout(0, 2, 5, 0));
		contentPane.add(panelBot, BorderLayout.SOUTH);
		
		JButton btnRecommencer = new JButton("Recommencer");
		btnRecommencer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRecommencer.addActionListener(controleur);
		panelBot.add(btnRecommencer);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnQuitter.addActionListener(controleur);
		panelBot.add(btnQuitter);
	}
	
	
	public void setJoueurActif(Joueur j) {
		//à faire
	}
}
