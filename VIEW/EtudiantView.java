package VIEW;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.DB;
import DAO.Enseignant_dao;
import DAO.Etudiant_dao;
import DAO.Matiere_dao;
import VIEW.UserView;
import MODEL.Matieres;
import java.awt.Color;
import java.awt.Font;

public class EtudiantView extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DB.loadConnection();
					Etudiantview frame = new Etudiantview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	public EtudiantView() {
		setTitle("Etudiant");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 535);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		
		JButton btnNewButton = new JButton("list enseignaant");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] columnNames = { "Nom", "Prenom", "Date de naissance", "Adresse", "Email", "Numero de telephone"};
				DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
				contentPane.setLayout(null);
				List<MODEL.Enseignant> enseignant = Enseignant_dao.getEnseignants();
				 for(MODEL.Enseignant et : enseignant) {
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
		btnNewButton.setBounds(265, 24, 248, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("liste matières");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        List<Matieres> listeCours = Matiere_dao.getListematiers();
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
		btnNewButton_1.setBounds(10, 24, 248, 28);
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
		btnNewButton_2.setBounds(188, 80, 173, 23);
		contentPane.add(btnNewButton_2);

	}

}
