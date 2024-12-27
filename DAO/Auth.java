package DAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Auth {
	
	public static String login(String nomUtilisateur, String motDePasse) {
	    String role = null;
	    try {
	        
	        PreparedStatement stmt = DB.con.prepareStatement("SELECT role FROM Utilisateur WHERE nom_utilisateur=? AND mot_de_passe=?");
	        stmt.setString(1, nomUtilisateur);
	        stmt.setString(2, motDePasse);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            role = rs.getString("role");
	        }else
	        	role="invalid password or username";
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return role;
	}

	}