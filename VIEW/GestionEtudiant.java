package VIEW;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.DB;
import DAO.Enseignant_dao;
import DAO.Etudiant_dao;
import DAO.User_dao;
import MODEL.Enseignant;
import MODEL.Etudiant;
import MODEL.Utilisateur;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.Font;

public class GestionEtudiant extends JFrame {

	private JPanel contentPane;
	private JTextField nomtext;
	private JTextField prenomtext;
	private JTextField datetext;
	private JTextField adressetext;
	private JTextField emailtext;
	private JTextField teltext;
	private JTextField nomutext;
	private JTextField mdptext;
	private JTextField idtext;
	private JTable table;
	int id ;
	DefaultTableModel tableModel;
	List<Etudiant> etudiantsnoterigistred = new ArrayList<>();
	int row;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DB.loadConnection();
					GestionEtudiant frame = new GestionEtudiant();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GestionEtudiant() {
		setTitle("Gérer les étudiants");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 636);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = nomtext.getText();
				String prenom = prenomtext.getText();
				String date = datetext.getText() ;
				String email = emailtext.getText();
				String adr = adressetext.getText();
				String tel = teltext.getText();
				String username = nomutext.getText(); 
				String mdp = mdptext.getText();
				Etudiant es = new Etudiant(nom,prenom,date,adr,email,tel,username,mdp);
				etudiantsnoterigistred.add(es);
				Vector v = new Vector();
					 v.add(es.getId());
					 v.add(es.getNom());
					 v.add(es.getPrenom());
					 v.add(es.getDateDeNaissance());
					 v.add(es.getAdresse());
					 v.add(es.getEmail());
					 v.add(es.getNumeroDeTelephone());
					 v.add(es.getNomUtilisateur());
					 v.add(es.getMotDePasse());
					 tableModel.addRow(v);
				
			}
		});
		btnNewButton.setBounds(24, 205, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nom = nomtext.getText();
				String prenom = prenomtext.getText();
				String date = datetext.getText() ;
				String email = emailtext.getText();
				String adr = adressetext.getText();
				String tel = teltext.getText();
				String username = nomutext.getText(); 
				String mdp = mdptext.getText();
				if(id !=0) {
					Etudiant es = new Etudiant(id,nom,prenom,date,adr,email,tel,username,mdp);
					Etudiant_dao.modifyEtudiant(es);
					Utilisateur u = new Utilisateur(id,username,mdp);
					User_dao.modifierUtilisateur(u);
					tableModel.setValueAt(es.getNom(), row, 1);
					tableModel.setValueAt(es.getPrenom(), row, 2);
					tableModel.setValueAt(es.getDateDeNaissance(), row, 3);
					tableModel.setValueAt(es.getAdresse(), row, 4);
					tableModel.setValueAt(es.getEmail(), row, 5);
					tableModel.setValueAt(es.getNumeroDeTelephone(), row, 6);
					tableModel.setValueAt(es.getNomUtilisateur(), row, 7);
					tableModel.setValueAt(es.getMotDePasse(), row, 8);
					Component[] components = getContentPane().getComponents();
					 for (Component component : components) {
					     if (component instanceof JTextField) {
					         JTextField textField = (JTextField) component;
					         textField.setText("");
					     }
					 }
					 id=0;
				}
			}
		});
		btnNewButton_1.setBounds(157, 205, 104, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Etudiant_dao.deleteEtudiant(id);
				User_dao.deleteUtilisateur(id);
				tableModel.removeRow(row);
				 Component[] components = getContentPane().getComponents();
			}
		});
		btnNewButton_2.setBounds(324, 205, 104, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Enregistrer");
		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int lastRowIndex = tableModel.getRowCount() - 1;
				int rowstart = lastRowIndex - etudiantsnoterigistred.size() +1;
				for(Etudiant es :etudiantsnoterigistred ) {
					Utilisateur u = new Utilisateur(es.getNomUtilisateur(),es.getMotDePasse(),"Etudiant");
					int ide = User_dao.addUtilisateur(u);
					es.setId(ide);
					Etudiant_dao.addEtudiant(es);
					tableModel.setValueAt(ide, rowstart, 0);
					rowstart++;
					
				}
				etudiantsnoterigistred.clear();
			}
		});
		btnNewButton_3.setBounds(503, 205, 118, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Fermer");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_4.setBounds(685, 205, 104, 23);
		contentPane.add(btnNewButton_4);
		
		nomtext = new JTextField();
		nomtext.setBounds(75, 31, 139, 20);
		contentPane.add(nomtext);
		nomtext.setColumns(10);
		
		prenomtext = new JTextField();
		prenomtext.setBounds(75, 80, 139, 20);
		contentPane.add(prenomtext);
		prenomtext.setColumns(10);
		
		datetext = new JTextField();
		datetext.setBounds(149, 125, 139, 20);
		contentPane.add(datetext);
		datetext.setColumns(10);
		
		adressetext = new JTextField();
		adressetext.setBounds(324, 31, 123, 20);
		contentPane.add(adressetext);
		adressetext.setColumns(10);
		
		emailtext = new JTextField();
		emailtext.setBounds(324, 80, 123, 20);
		contentPane.add(emailtext);
		emailtext.setColumns(10);
		
		teltext = new JTextField();
		teltext.setBounds(488, 125, 123, 20);
		contentPane.add(teltext);
		teltext.setColumns(10);
		
		nomutext = new JTextField();
		nomutext.setBounds(630, 31, 119, 20);
		contentPane.add(nomutext);
		nomutext.setColumns(10);
		
		mdptext = new JTextField();
		mdptext.setBounds(630, 80, 119, 20);
		contentPane.add(mdptext);
		mdptext.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(19, 34, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(19, 83, 60, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Date_de_naissance");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(19, 128, 137, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Adresse");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(271, 34, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(271, 83, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Numero_de_telephone");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(332, 128, 173, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nom_utilisateur");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(517, 34, 104, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Mot_de_passe");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(517, 83, 97, 14);
		contentPane.add(lblNewLabel_7);
		String[] columnNames = { "ID","Nom", "Prenom", "Date de naissance", "Adresse", "Email", "Numero de telephone","Nom_utilisateur","Mot_de_passe"};
		 tableModel = new DefaultTableModel(columnNames, 0);
		contentPane.setLayout(null);
		 table = new JTable(tableModel);

		List<MODEL.Etudiant> etudiants = Etudiant_dao.getAllEtudiants();
		 for(MODEL.Etudiant et : etudiants) {
			 Vector v = new Vector();
			 v.add(et.getId());
			 v.add(et.getNom());
			 v.add(et.getPrenom());
			 v.add(et.getDateDeNaissance());
			 v.add(et.getAdresse());
			 v.add(et.getEmail());
			 v.add(et.getNumeroDeTelephone());
			 v.add(et.getNomUtilisateur());
			 v.add(et.getMotDePasse());
			 tableModel.addRow(v);
		 }		 
		table.setBounds(10, 174, 503, 281);
		JScrollPane scrollPane = new JScrollPane(table);
		table.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				 row = table.getSelectedRow();
				if(row<0)
					JOptionPane.showMessageDialog(null,"please select row");
				else {
				 id = (int) table.getModel().getValueAt(row, 0);
				 Etudiant es = Etudiant_dao.getEtudiantById(id);
				    nomtext.setText(es.getNom());
					prenomtext.setText(es.getPrenom());
					datetext.setText(es.getDateDeNaissance().toString()) ;
					emailtext.setText(es.getEmail());
					adressetext.setText(es.getAdresse());
					teltext.setText(es.getNumeroDeTelephone());
					nomutext.setText(es.getNomUtilisateur()); 
					mdptext.setText(es.getMotDePasse());
				}
				 
				 
			}
			
		});
		scrollPane.setBounds(10,242, 925, 344);

		
		contentPane.add(scrollPane);
		JButton btnNewButton_5 = new JButton("accueil");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminView frame = new AdminView();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_5.setBounds(856, 0, 89, 23);
		contentPane.add(btnNewButton_5);
	}
}
