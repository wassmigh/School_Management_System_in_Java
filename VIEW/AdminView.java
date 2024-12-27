package VIEW;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DAO.DB;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class AdminView extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DB.loadConnection();
					AdminView frame = new AdminView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdminView() {
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 484);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Gérer les enseignants");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionEnseignant frame = new GestionEnseignant();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(152, 158, 248, 52);
		contentPane.add(btnNewButton);
		
		JButton btnGrerLestudiants = new JButton("Gérer les étudiants");
		btnGrerLestudiants.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGrerLestudiants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionEtudiant frame = new GestionEtudiant();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnGrerLestudiants.setBounds(152, 92, 248, 52);
		contentPane.add(btnGrerLestudiants);
		
		JButton btnAffecterLesMatires = new JButton("Affecter les matières ");
		btnAffecterLesMatires.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAffecterLesMatires.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionMatiere frame = new GestionMatiere();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnAffecterLesMatires.setBounds(152, 222, 248, 52);
		contentPane.add(btnAffecterLesMatires);
		
		JButton btnNewButton_1 = new JButton("Se déconnecter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserView frame = new UserView();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(412, 411, 127, 23);
		contentPane.add(btnNewButton_1);
	}
}
