package VIEW;

import java.awt.Component;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.DB;
import DAO.Etudiant_dao;
import DAO.Matiere_dao;
import VIEW.UserView;
import MODEL.Enseignant;
import MODEL.Matieres;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class EnseignantView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DB.loadConnection();
					//Enseignantview frame = new Enseignantview();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/


	public EnseignantView(Enseignant enseignant) {
		setTitle("Enseignant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 535);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
		JButton btnNewButton = new JButton("list edudiant");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] columnNames = { "Nom", "Prenom", "Date de naissance", "Adresse", "Email", "Numero de telephone"};
				DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
				contentPane.setLayout(null);
				ArrayList<MODEL.Etudiant> etudiants = Etudiant_dao.getAllEtudiants();
				 for(MODEL.Etudiant et : etudiants) {
					 Vector v = new Vector();
					 v.add(et.getNom());
					 v.add(et.getPrenom());
					 v.add(et.getDateDeNaissance());
					 v.add(et.getAdresse());
					 v.add(et.getEmail());
					 v.add(et.getNumeroDeTelephone());
					 tableModel.addRow(v);
				 }
				 table = new JTable(tableModel);
				 
				table.setBounds(10, 174, 503, 281);
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10,174, 503, 291);

				
				contentPane.add(scrollPane);
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setBounds(10, 27, 232, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("liste matières");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        List<Matieres> listeCours = enseignant.getListeCours();
		        String[] columnNames = { "Nom", "description"};
				DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
				for(Matieres m : listeCours) {
					Vector v = new Vector();
					v.add(m.getNom());
					v.add(m.getDescription());
					tableModel.addRow(v);
				}
				 JTable table = new JTable(tableModel);
				 
             JScrollPane scrollPane = new JScrollPane(table);
             scrollPane.setBounds(10,174, 503, 291);
             contentPane.add(scrollPane);
			}
		});
		btnNewButton_1.setBounds(281, 27, 232, 28);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Se déconnecter");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserView frame = new UserView();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(190, 91, 188, 23);
		contentPane.add(btnNewButton_2);
		
		
	}
}
