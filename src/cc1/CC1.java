/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cc1;

    import cc1.model.Model;
    import cc1.service.Service;
    import java.util.Scanner;
    import java.util.*;
/**
 *
 * @author EPF
 */
public class CC1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
            Model etd1,etd2;
            Model etd;

            String matricule_etudiant,nom_etudiant,filiere_etudiant;
            int niveau;

           Service service;
            service = new Service();

           // Menu

          int choix;

          do{
            System.out.println(" ----------------MENU------------------------- ");
            System.out.println(" 1. Enregistrer un nouvel étudiant");
            System.out.println(" 2. Liste de tous les étudiants");
            System.out.println(" 3. Liste de tous les étudiants d'une filière donnée");
            System.out.println(" 4. Recherche et affiche les informations d'un étudiant par son matricule");
            System.out.println(" 5. Suppression d'un étudiant à partir de son matricule"); 
            System.out.println(" 6. Modification du niveau d'un étudiant donné");
            System.out.println(" 7. Quiter");
            System.out.println(" Veuillez entrer votre choix(1-7): ");
             choix=sc.nextInt();          

          switch(choix)
          { 
              // Méthode d'enregistrement d'un nouvel étudiant
              case 1:
             System.out.print(" Entrer le matricule: ");
             matricule_etudiant = sc.next();
            
             System.out.print(" Entrer le nom : ");
             nom_etudiant = sc.next();
             
             System.out.print(" Entrer la filiere : ");
             filiere_etudiant = sc.next();
             
             System.out.print(" Entrer le niveau : ");
             niveau = sc.nextInt(); 
            
             etd = new Model(matricule_etudiant,nom_etudiant,filiere_etudiant,niveau);
             service.ajout_nouveau_etudiant (etd);
              System.out.println(" Enregistrement  effectué ");

                  break;
                  
                // Méthode d'affichage de tous les étudiant
                    case 2: 
                      service.afficher_liste_etudiant(); 

                  break;
                      
                // Méthode d'affichage des étudiant par filiere
                    case 3: 
                    System.out.print(" Entrer la filière: "); 
                    filiere_etudiant = sc.next();
                    service.afficher_liste_etudiant_par_filiere(filiere_etudiant);

                  break;
                    
                // Méthode de recherche d'un étudiant par filière
                    case 4:
                    System.out.print(" Entrer le matricule de l'étudiant à rechercher : ");
                    matricule_etudiant = sc.next();
                    System.out.print(" L'étudiant rechercher est: ");
                    service.rechercher_etudiant_a_partir_du_matricule(matricule_etudiant);

                  break;
                
                // Méthode de suppression
                    case 5:
                    System.out.print(" Entrer le matricule de l'etudiant à supprimer : ");
                    matricule_etudiant = sc.next();
                    service.supprime_matricule(matricule_etudiant);
                    service.afficher_liste_etudiant();
                    System.out.println(" Suppression reussie. ");

                  break;
                
                // Méthode de modification du niveau d'un étudiant
                    case 6:
                    System.out.print("Entrer le matricule  de l'etudiant : ");
                    matricule_etudiant = sc.next();
                    System.out.print("Modifier le niveau de l'etudiant : ");
                    niveau = sc.nextInt();
                    service.modifier_niveau_etudiant(matricule_etudiant,niveau);
                    service.afficher_liste_etudiant();
                    System.out.println("Mise à jour effectuée"); 
                    
                    break;
                     
                    default:System.out.println("veuillez rester l'ordre");
        } 
          }while(choix!=7);

    }
}
    

