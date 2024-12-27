package MODEL;

import java.sql.*;
public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private String adresse;
    private String email;
    private String numeroDeTelephone;
    private String nomUtilisateur;
    private String motDePasse;

    public Etudiant(int id, String nom, String prenom, String dateDeNaissance,
                     String adresse, String email, String numeroDeTelephone,
                     String nomUtilisateur, String motDePasse) {
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
    public Etudiant( String nom, String prenom, String dateDeNaissance,
            String adresse, String email, String numeroDeTelephone,
            String nomUtilisateur, String motDePasse) {

this.nom = nom;
this.prenom = prenom;
this.dateDeNaissance = dateDeNaissance;
this.adresse = adresse;
this.email = email;
this.numeroDeTelephone = numeroDeTelephone;
this.nomUtilisateur = nomUtilisateur;
this.motDePasse = motDePasse;
}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroDeTelephone() {
        return numeroDeTelephone;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
}