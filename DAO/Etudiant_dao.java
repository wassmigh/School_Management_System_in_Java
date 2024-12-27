package DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import javax.swing.JOptionPane;


import MODEL.Etudiant;

public class Etudiant_dao {

	public static ArrayList<Etudiant> getAllEtudiants() {
        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();

        try {
            
            Statement stmt = DB.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM etudiant");

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nom = rs.getString("Nom");
                String prenom = rs.getString("Prenom");
                String dateDeNaissance = rs.getString("Date_de_naissance");
                String adresse = rs.getString("Adresse");
                String email = rs.getString("Email");
                String numeroDeTelephone = rs.getString("Numero_de_telephone");
                String nomUtilisateur = rs.getString("Nom_utilisateur");
                String motDePasse = rs.getString("Mot_de_passe");

                Etudiant etudiant = new Etudiant(id, nom, prenom, dateDeNaissance, adresse,
                                                  email, numeroDeTelephone, nomUtilisateur, motDePasse);
                etudiants.add(etudiant);
            }

         
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage());
        }

        return etudiants;
    }
	public static Etudiant getEtudiantById(int id) {
	    Etudiant etudiant = null;
	    try {
	       
	        String query = "SELECT * FROM Etudiant WHERE ID = ?";
	        PreparedStatement stmt = DB.con.prepareStatement(query);
	        stmt.setInt(1, id);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            etudiant = new Etudiant(
	                rs.getInt("ID"),
	                rs.getString("Nom"),
	                rs.getString("Prenom"),
	                rs.getString("Date_de_naissance"),
	                rs.getString("Adresse"),
	                rs.getString("Email"),
	                rs.getString("Numero_de_telephone"),
	                rs.getString("Nom_utilisateur"),
	                rs.getString("Mot_de_passe")
	                
	            );
	        }
	      
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return etudiant;
	}
	public static void deleteEtudiant(int id) {
	    try {
	        
	        String sql = "DELETE FROM Etudiant WHERE ID = ?";
	        PreparedStatement statement = DB.con.prepareStatement(sql);
	        statement.setInt(1, id);
	        statement.executeUpdate();
	        //conn.close();
	        System.out.println("Etudiant with ID " + id + " deleted successfully.");
	    } catch (SQLException e) {
	        System.out.println("Error deleting Enseignant with ID " + id + ": " + e.getMessage());
	    }
	}
	public static void addEtudiant(Etudiant etudiant) {
	    try {
	       
	        String query = "INSERT INTO Etudiant (id,Nom, Prenom, Date_de_naissance, Adresse, Email, Numero_de_telephone, Nom_utilisateur, Mot_de_passe) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement statement = DB.con.prepareStatement(query);
	        statement.setInt(1, etudiant.getId());
	        statement.setString(2, etudiant.getNom());
	        statement.setString(3, etudiant.getPrenom());
	        statement.setString(4, etudiant.getDateDeNaissance());
	        statement.setString(5, etudiant.getAdresse());
	        statement.setString(6, etudiant.getEmail());
	        statement.setString(7, etudiant.getNumeroDeTelephone());
	        statement.setString(8, etudiant.getNomUtilisateur());
	        statement.setString(9, etudiant.getMotDePasse());
	        statement.executeUpdate();
	        //conn.close();
	    } catch (SQLException ex) {
	        System.out.println("Error: " + ex.getMessage());
	    }
	}
	public static void modifyEtudiant(Etudiant etudiant) {
	    try {
	        
	        PreparedStatement stmt = DB.con.prepareStatement("UPDATE Etudiant SET Nom = ?, Prenom = ?, Date_de_naissance = ?, Adresse = ?, Email = ?, Numero_de_telephone = ?, Nom_utilisateur = ?, Mot_de_passe = ? WHERE ID = ?");
	        stmt.setString(1, etudiant.getNom());
	        stmt.setString(2, etudiant.getPrenom());
	        stmt.setString(3, etudiant.getDateDeNaissance());
	        stmt.setString(4, etudiant.getAdresse());
	        stmt.setString(5, etudiant.getEmail());
	        stmt.setString(6, etudiant.getNumeroDeTelephone());
	        stmt.setString(7, etudiant.getNomUtilisateur());
	        stmt.setString(8, etudiant.getMotDePasse());
	        stmt.setInt(9, etudiant.getId());
	        stmt.executeUpdate();
	      
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
}
