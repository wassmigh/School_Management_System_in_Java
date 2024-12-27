package VIEW;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.DB;
import DAO.Enseignant_dao;
import DAO.Matiere_dao;
import MODEL.Enseignant;
import MODEL.Matieres;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class GestionMatiere extends JFrame {

	private JPanel contentPane;
	private JTextField textnom;
	private JTextField textdescription;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTable table;
	int id ;
	int row;
	DefaultTableModel tableMode2;
	JTable table2 ;
	JScrollPane scrollPane2;
	int idcour;
	int rowcour;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DB.loadConnection();
					GestionMatiere frame = new GestionMatiere();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GestionMatiere() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 621);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom_du_cours");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(37, 7, 136, 31);
		contentPane.add(lblNewLabel);
		
		textnom = new JTextField();
		textnom.setBounds(20, 49, 153, 50);
		contentPane.add(textnom);
		textnom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Description du cours");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(228, 7, 217, 43);
		contentPane.add(lblNewLabel_1);
		
		textdescription = new JTextField();
		textdescription.setBounds(238, 49, 153, 50);
		contentPane.add(textdescription);
		textdescription.setColumns(10);
		
		JButton btnNewButton = new JButton("accueil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminView frame = new AdminView();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(744, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Ajouter");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(id!=0) {
					String nom = textnom.getText();
					String de = textdescription.getText();
					Enseignant es = Enseignant_dao.getEnseignantbyid(id);
					es.ajouterCours(nom, de);
					List<Matieres> listeCours = es.getListeCours();
					Matieres m = listeCours.get(listeCours.size() - 1);
					Vector v = new Vector();
					v.add(m.getId());
					v.add(m.getNom());
					v.add(m.getDescription());
					tableMode2.addRow(v);
				}
			}
		});
		btnNewButton_1.setBounds(20, 127, 153, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idcour!=0) {
					Matiere_dao.deleteCourse(idcour);
					tableMode2.removeRow(rowcour);
				}
			}
		});
		btnNewButton_2.setBounds(238, 127, 153, 23);
		contentPane.add(btnNewButton_2);
		String[] columnNames = { "ID","Nom", "Prenom","Email"};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		contentPane.setLayout(null);
		List<MODEL.Enseignant> enseignant = Enseignant_dao.getEnseignants();
		 for(MODEL.Enseignant et : enseignant) {
			 Vector v = new Vector();
			 v.add(et.getId());
			 v.add(et.getNom());
			 v.add(et.getPrenom());
			 v.add(et.getEmail());
			 
			 tableModel.addRow(v);
		 }
		 table = new JTable(tableModel);
		 
		table.setBounds(10, 174, 503, 281);
		JScrollPane scrollPane = new JScrollPane(table);
		
		String[] columnNames2 = { "ID","Nom", "description"};
		tableMode2 = new DefaultTableModel(columnNames2, 0);
		 table2 = new JTable(tableMode2);
		  scrollPane2 = new JScrollPane(table2);
		  
		  table2.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseClicked(MouseEvent e) {
		  		rowcour = table2.getSelectedRow();
				if(rowcour<0)
					JOptionPane.showMessageDialog(null,"please select row");
				else {
					
				 idcour = (int) table2.getModel().getValueAt(rowcour, 0);}
				
		  		
		  	}
		  });
         scrollPane2.setBounds(436,174, 359, 386);
         contentPane.add(scrollPane2);
         
         
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 row = table.getSelectedRow();
					if(row<0)
						JOptionPane.showMessageDialog(null,"please select row");
					else {
						tableMode2.setRowCount(0);
					 id = (int) table.getModel().getValueAt(row, 0);
					 Enseignant es = Enseignant_dao.getEnseignantbyid(id);
				List<Matieres> listeCours = es.getListeCours();
		        
				for(Matieres m : listeCours) {
					Vector v = new Vector();
					v.add(m.getId());
					v.add(m.getNom());
					v.add(m.getDescription());
					tableMode2.addRow(v);
				}
				  
					}
			}
		});
		scrollPane.setBounds(10,174, 372, 386);

		
		contentPane.add(scrollPane);
		 
	        
	}
}
