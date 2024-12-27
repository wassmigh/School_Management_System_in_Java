package VIEW;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import VIEW.AdminView;
import DAO.Auth;
import DAO.DB;
import DAO.Enseignant_dao;
import VIEW.EnseignantView;
import VIEW.EtudiantView;
import MODEL.Enseignant;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class UserView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DB.loadConnection();
					UserView frame = new UserView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public UserView() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(447, 349);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 255));
		contentPane.setLayout(null);
		
		JLabel userLabel = new JLabel("Username");
		userLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		userLabel.setForeground(Color.WHITE);
		userLabel.setBounds(63,58,102,53);
        contentPane.add(userLabel);
        
        JTextField userText = new JTextField(20);
        userText.setBounds(167,75,122,20);
        contentPane.add(userText);
        getContentPane().add(contentPane);
        
        
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(63,104,104,53);
        contentPane.add(passwordLabel);
        
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(167,120,122,20);
        contentPane.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.WHITE);
        loginButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
        loginButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String username = userText.getText();
        		String password = passwordText.getText();
        		String role = Auth.login(username, password);
        		switch(role) {
        		case"Administrateur":{
        			AdminView frame = new AdminView();
					frame.setVisible(true);
        			setVisible(false);
        			 break;
        		}
        		case"Etudiant":{
        			EtudiantView frame = new EtudiantView();
					frame.setVisible(true);
					setVisible(false);
					 break;
        		}
        		case"Enseignant":{
        			Enseignant es= Enseignant_dao.getEnseignant(username,password);
        			EnseignantView frame = new EnseignantView(es);
					frame.setVisible(true);
					setVisible(false);
					 break;
        			
        		}
        		case"invalid password or username":JOptionPane.showMessageDialog(null,role);
        		 break;
        		}
        		
        		
        		
        		
        		
        	}
        });
        loginButton.setBounds(120, 184, 166, 47);
        contentPane.add(loginButton);
        
        JLabel label_6 = new JLabel("");
        label_6.setBounds(250, 107, 83, 53);
        contentPane.add(label_6);
		 
	}
}
