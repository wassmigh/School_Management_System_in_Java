package DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import DAO.DB;
import MODEL.Enseignant;
import MODEL.Matieres;

public class Enseignant_dao {

	public static List<Enseignant> getEnseignants() {
	    List<Enseignant> enseignants = new ArrayList<>();

	    try {
	        
	        Statement stmt = DB.con.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM Enseignant");

	        while (rs.next()) {
	            int id = rs.getInt("ID");
	            String nom = rs.getString("Nom");
	            String prenom = rs.getString("Prenom");
	            String dateNaissance = rs.getString("Date_de_naissance");
	            String adresse = rs.getString("Adresse");
	            String email = rs.getString("Email");
	            String numeroTelephone = rs.getString("Numero_de_telephone");
	            String nomUtilisateur = rs.getString("Nom_utilisateur");
	            String motDePasse = rs.getString("Mot_de_passe");

	            Enseignant enseignant = new Enseignant(id, nom, prenom, dateNaissance, adresse, email, numeroTelephone, nomUtilisateur, motDePasse);
	            enseignants.add(enseignant);
	        }


	    } catch (SQLException e) {
	        System.err.println("Error: " + e.getMessage());
	    }

	    return enseignants;
	}
	public static Enseignant getEnseignant(String nomUtilisateur, String motDePasse) {
	    Enseignant enseignant = null;
	    try {
	        
	        PreparedStatement stmt = DB.con.prepareStatement("SELECT * FROM Enseignant WHERE nom_utilisateur=? AND mot_de_passe=?");
	        stmt.setString(1, nomUtilisateur);
	        stmt.setString(2, motDePasse);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            int id = rs.getInt("ID");
	            String nom = rs.getString("Nom");
	            String prenom = rs.getString("Prenom");
	            String dateDeNaissance = rs.getString("Date_de_naissance");
	            String adresse = rs.getString("Adresse");
	            String email = rs.getString("Email");
	            String numeroDeTelephone = rs.getString("Numero_de_telephone");
	            String nomUtilisateurDB = rs.getString("Nom_utilisateur");
	            String motDePasseDB = rs.getString("Mot_de_passe");
	            enseignant = new Enseignant(id, nom, prenom, dateDeNaissance, adresse, email, numeroDeTelephone, nomUtilisateurDB, motDePasseDB);
	        }
	      
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return enseignant;
	}
	public static void addEnseignant(Enseignant enseignant) {
	    try {
	        
	        String query = "INSERT INTO Enseignant (id,Nom, Prenom, Date_de_naissance, Adresse, Email, Numero_de_telephone, Nom_utilisateur, Mot_de_passe) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement statement = DB.con.prepareStatement(query);
	        
	        statement.setInt(1, enseignant.getId());
	        statement.setString(2, enseignant.getNom());
	        statement.setString(3, enseignant.getPrenom());
	        statement.setString(4, enseignant.getDateDeNaissance());
	        statement.setString(5, enseignant.getAdresse());
	        statement.setString(6, enseignant.getEmail());
	        statement.setString(7, enseignant.getNumeroDeTelephone());
	        statement.setString(8, enseignant.getNomUtilisateur());
	        statement.setString(9, enseignant.getMotDePasse());
	        statement.executeUpdate();
	        
	    } catch (SQLException ex) {
	        System.out.println("Error while adding enseignant: " + ex.getMessage());
	    }
	}
	public static void deleteEnseignant(int id) {
	    try {
	        
	        String sql = "DELETE FROM Enseignant WHERE ID = ?";
	        PreparedStatement statement = DB.con.prepareStatement(sql);
	        statement.setInt(1, id);
	        statement.executeUpdate();
	      
	        System.out.println("Enseignant with ID " + id + " deleted successfully.");
	    } catch (SQLException e) {
	        System.out.println("Error deleting Enseignant with ID " + id + ": " + e.getMessage());
	    }
	}
	public static void modifyEnseignant(Enseignant enseignant) {
	    try {
	        
	        PreparedStatement stmt = DB.con.prepareStatement("UPDATE Enseignant SET Nom = ?, Prenom = ?, Date_de_naissance = ?, Adresse = ?, Email = ?, Numero_de_telephone = ?, Nom_utilisateur = ?, Mot_de_passe = ? WHERE ID = ?");
	        stmt.setString(1, enseignant.getNom());
	        stmt.setString(2, enseignant.getPrenom());
	        stmt.setString(3, enseignant.getDateDeNaissance());
	        stmt.setString(4, enseignant.getAdresse());
	        stmt.setString(5, enseignant.getEmail());
	        stmt.setString(6, enseignant.getNumeroDeTelephone());
	        stmt.setString(7, enseignant.getNomUtilisateur());
	        stmt.setString(8, enseignant.getMotDePasse());
	        stmt.setInt(9, enseignant.getId());
	        stmt.executeUpdate();
	     
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public static Enseignant getEnseignantbyid(int id) {
	    Enseignant enseignant = null;
	    try {
	        
	        PreparedStatement stmt = DB.con.prepareStatement("SELECT * FROM Enseignant WHERE ID=?");
	        stmt.setInt(1, id);
	        
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            int ide = rs.getInt("ID");
	            String nom = rs.getString("Nom");
	            String prenom = rs.getString("Prenom");
	            String dateDeNaissance = rs.getString("Date_de_naissance");
	            String adresse = rs.getString("Adresse");
	            String email = rs.getString("Email");
	            String numeroDeTelephone = rs.getString("Numero_de_telephone");
	            String nomUtilisateurDB = rs.getString("Nom_utilisateur");
	            String motDePasseDB = rs.getString("Mot_de_passe");
	            enseignant = new Enseignant(ide, nom, prenom, dateDeNaissance, adresse, email, numeroDeTelephone, nomUtilisateurDB, motDePasseDB);
	        }
	       
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return enseignant;
	    }
	
}