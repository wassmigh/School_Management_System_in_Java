package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MODEL.Matieres;

public class Matiere_dao {

	public static List<Matieres> getListematiers() {
	    List<Matieres> listeCours = new ArrayList<Matieres>();
	    try {
	       
	        PreparedStatement stmt = DB.con.prepareStatement("SELECT * FROM Cours ");
	        
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int idCours = rs.getInt("id");
	            String nomCours = rs.getString("Nom_du_cours");
	            String descriptionCours = rs.getString("Description_du_cours");
	            Matieres cours = new Matieres(idCours, nomCours, descriptionCours);
	            listeCours.add(cours);
	        }

	    
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return listeCours;
	}
	public static void deleteCourse(int courseId) {
	    String query = "DELETE FROM Cours WHERE ID = ?";
	    try {
	        PreparedStatement statement = DB.con.prepareStatement(query);
	        statement.setInt(1, courseId);
	        statement.executeUpdate();
	        System.out.println("Course with ID " + courseId + " has been deleted.");
	    } catch (SQLException e) {
	        System.out.println("Error deleting course with ID " + courseId + ": " + e.getMessage());
	    }
	}
}
