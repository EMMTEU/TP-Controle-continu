/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cc1.model;

/**
 *
 * @author EPF
 */
public class Model {
    
    
    private String matricule_etudiant;
    private String nom_etudiant;
    private String filiere_etudiant;
    private int niveau;
    
        // Déclaration du Constructeur de la Classe par défaut, sans Paramètres.
        public Model(){
    }
        // Déclaration du Constructeur de la Classe avec des paramètres
        public Model(String matricule_etudiant, String nom_etudiant, String filiere_etudiant, int niveau){
            this.matricule_etudiant = matricule_etudiant;
            this.nom_etudiant = nom_etudiant;
            this.filiere_etudiant = filiere_etudiant;
            this.niveau = niveau;
            
        }

    public String getMatricule_etudiant() {
        return matricule_etudiant;
    }

    public void setMatricule_etudiant(String matricule_etudiant) {
        this.matricule_etudiant = matricule_etudiant;
    }

    public String getNom_etudiant() {
        return nom_etudiant;
    }

    public void setNom_etudiant(String nom_etudiant) {
        this.nom_etudiant = nom_etudiant;
    }

    public String getFiliere_etudiant() {
        return filiere_etudiant;
    }

    public void setFiliere_etudiant(String filiere_etudiant) {
        this.filiere_etudiant = filiere_etudiant;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
}
