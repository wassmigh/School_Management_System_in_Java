package MODEL;

public class Utilisateur {
    private int id;
    private String nomUtilisateur;
    private String motDePasse;
    private String role;

    public Utilisateur( String nomUtilisateur, String motDePasse, String role) {
        
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.role = role;
    }
public Utilisateur( String nomUtilisateur, String motDePasse) {
        
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        
    }
public Utilisateur(int id ,String nomUtilisateur, String motDePasse) {
    this.id=id;
    this.nomUtilisateur = nomUtilisateur;
    this.motDePasse = motDePasse;
    
}
    public int getId() {
        return id;
    }
    public void setId(int id) {
         this.id=id;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getRole() {
        return role;
    }
}
