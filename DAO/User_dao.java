package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import MODEL.Utilisateur;

public class User_dao {
	public static int addUtilisateur(Utilisateur utilisateur) {
	    try {
	        
	        String query = "INSERT INTO Utilisateur(Nom_utilisateur, Mot_de_passe, Role) VALUES (?, ?, ?)";
	        PreparedStatement statement = DB.con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        statement.setString(1, utilisateur.getNomUtilisateur());
	        statement.setString(2, utilisateur.getMotDePasse());
	        statement.setString(3, utilisateur.getRole().toString());
	        int rowsInserted = statement.executeUpdate();
	        if (rowsInserted == 0) {
	            throw new SQLException("Creating utilisateur failed, no rows inserted.");
	        }
	        ResultSet generatedKeys = statement.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            int id = generatedKeys.getInt(1);
	            utilisateur.setId(id);
	            return id;
	        } else {
	            throw new SQLException("Creating utilisateur failed, no ID obtained.");
	        }
	    } catch (SQLException ex) {
	        System.out.println(ex.getMessage());
	        return -1;
	    }
	}
	public static void deleteUtilisateur(int id) {
	    try {
	        
	        PreparedStatement stmt = DB.con.prepareStatement("DELETE FROM Utilisateur WHERE ID = ?");
	        stmt.setInt(1, id);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public static void modifierUtilisateur(Utilisateur utilisateur) {
	    try {
	       

	        String query = "UPDATE Utilisateur SET Nom_utilisateur=?, Mot_de_passe=? WHERE ID=?";
	        PreparedStatement statement = DB.con.prepareStatement(query);
	        statement.setString(1, utilisateur.getNomUtilisateur());
	        statement.setString(2, utilisateur.getMotDePasse());
	        
	        statement.setInt(3, utilisateur.getId());

	        int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Utilisateur modifié avec succès !");
	        } else {
	            System.out.println("La modification de l'utilisateur a échoué.");
	        }

	        statement.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
}
