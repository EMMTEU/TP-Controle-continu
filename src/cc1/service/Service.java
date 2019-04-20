/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cc1.service;

import java.sql.*;
import cc1.model.Model;

/**
 *
 * @author EPF
 */
public class Service {
    
    // Déclaration des paramètres de connexion à la Base de Données
    
    String url;
    String username;
    String password = "";
    
    // Création d'une connexion à la Base de Données fichiers_des_etudiants   
    
    Connection con = null; 
    
    // Création d'une connexion à la Base de Données fichiers_des_etudiants (suite)
    
    public Service(){
        this.url = "jdbc:mysql://localhost:3306/fichiers_des_etudiants";
        this.username = "root";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(" Chargement Pilote OK ");
            
             // Connexion sans informations de sécurité
            
            con = DriverManager.getConnection(url,username,password);
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
    
    // Enregistrement d'un nouveau étudiant avec " etudiant " comme Type et " etd " comme variable;
    public boolean ajout_nouveau_etudiant(Model etd){
        try{
            Statement req = con.createStatement();
            String reqSQL = "INSERT INTO  value (null,'" + etd.getMatricule_etudiant() +"','"+ etd.getNom_etudiant() +"','"+ etd.getFiliere_etudiant() +"','"+ etd.getNiveau() +"')";
            int res = req.executeUpdate(reqSQL);
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    // Méthode pour Afficher la liste de tous les étudiants;
    
    public void afficher_liste_etudiant(){
        try{
            Statement req = con.createStatement();
            String reqSQL = "SELECT * FROM etudiants";
            ResultSet res = req.executeQuery(reqSQL);
            while(res.next()){
                System.out.println(res.getString("matricule_etudiant") + ":" + res.getString("nom_etudiant") + ":" + res.getString("filiere_etudiant") + ":" + res.getInt("niveau"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    // Méthode d'Affichage de la liste de tous les étudiants par filière;
    
    public void afficher_liste_etudiant_par_filiere(String filiere){
        try{
            Statement req = con.createStatement();
            String reqSQL = "SELECT * FROM etudiants WHERE filiere_etudiant = '" +filiere+ "' ";
            ResultSet res = req.executeQuery(reqSQL);
            while(res.next()){
             
                System.out.println(res.getString("matricule_etudiant") + ":" + res.getString("nom_etudiant") + ":" + res.getInt("niveau"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    // Méthode de Recherche pour un étudiant;
  
    public void rechercher_etudiant_a_partir_du_matricule(String matricule){
        try{
            Statement req=con.createStatement();
            String reqSQL="SELECT FROM etudiants WHERE matricule_etudiant = '" +matricule+ "' ";
            ResultSet res=req.executeQuery(reqSQL);
            while(res.next()){

                System.out.println(res.getString("matricule_etudiant") + ":" + res.getString("nom_etudiant") + ":" + res.getInt("niveau"));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    // Suppression d'un étudiant à partir de son matricule
    
    public void supprime_matricule(String matricule){
        try{
            Statement req = con.createStatement();
            String sql = "DELETE FROM etudiants WHERE matricule_etudiant = '" +matricule+ "' ";
            int res = req.executeUpdate(sql);
                System.out.println(" La suppression du matricule a bien été effectuée. ");
                
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    // Modification du niveau d'un étudiant
    
    public void modifier_niveau_etudiant(String matricule,int niveau){
        try{
            Statement req= con.createStatement();
             String sql = "UPDATE etudiants SET niveau = " +niveau+ " WHERE matricule_etudiant = '" +matricule+ "' ";
             int res=req.executeUpdate(sql);
             
             System.out.println(" **************************** ");
             System.out.println(" Après modification : ");
             
           System.out.println(" Le niveau est bien modifier.");
        }
        catch(SQLException e){
            e.printStackTrace();
        } 
    }
    
}
