package MODEL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DB;

public class Enseignant {
    private int id;
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private String adresse;
    private String email;
    private String numeroDeTelephone;
    private String nomUtilisateur;
    private String motDePasse;

    public Enseignant(int id, String nom, String prenom, String dateDeNaissance, String adresse, String email, String numeroDeTelephone, String nomUtilisateur, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.adresse = adresse;
        this.email = email;
        this.numeroDeTelephone = numeroDeTelephone;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
    }
    public Enseignant( String nom, String prenom, String dateDeNaissance, String adresse, String email, String numeroDeTelephone, String nomUtilisateur, String motDePasse) {
        
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.adresse = adresse;
        this.email = email;
        this.numeroDeTelephone = numeroDeTelephone;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getDateDeNaissance() { return dateDeNaissance; }
    public void setDateDeNaissance(String dateDeNaissance) { this.dateDeNaissance = dateDeNaissance; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNumeroDeTelephone() { return numeroDeTelephone; }
    public void setNumeroDeTelephone(String numeroDeTelephone) { this.numeroDeTelephone = numeroDeTelephone; }
    public String getNomUtilisateur() { return nomUtilisateur; }
    public void setNomUtilisateur(String nomUtilisateur) { this.nomUtilisateur = nomUtilisateur; }
    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
    
    public List<Matieres> getListeCours() {
        List<Matieres> listeCours = new ArrayList<>();
        try {
            
            PreparedStatement stmt = DB.con.prepareStatement("SELECT * FROM Cours WHERE Enseignant = ?");
            stmt.setInt(1, this.id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int idCours = rs.getInt("id");
                String nomCours = rs.getString("Nom_du_cours");
                String descriptionCours = rs.getString("Description_du_cours");
                Matieres cours = new Matieres(idCours, nomCours, descriptionCours);
                listeCours.add(cours);
            }

            //con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listeCours;
    }
    public void ajouterCours(String nomCours, String descriptionCours) {
        try {
            
            PreparedStatement stmt = DB.con.prepareStatement("INSERT INTO Cours (Nom_du_cours, Description_du_cours, Enseignant) VALUES (?, ?, ?)");
            stmt.setString(1, nomCours);
            stmt.setString(2, descriptionCours);
            stmt.setInt(3, this.id);
            stmt.executeUpdate();

            //con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}