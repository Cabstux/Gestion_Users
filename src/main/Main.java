
package main;
import java.util.Scanner;
import dao.IUtilisateurs;
import dao.UtilisateursImpl;
import entities.Utilisateurs;

public class Main {
    public static void main(String[] args) {

        boolean rep=false;
        String email,password;
        int id, get;
        IUtilisateurs dao=new UtilisateursImpl();
        System.out.println("Bienvenue dans gestion-users application");

        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1. Ajouter  Utilisateurs\n" +
                    "2. Montrer Utilisateurs\n" +
                    "3. Delete the Utilisateurs\n");

            System.out.println("Saisir votre choix: ");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    Utilisateurs ut=new Utilisateurs();
                    System.out.println("Saisir ID : ");
                    id=sc.nextInt();
                    System.out.println("Saisir email ");
                    email=sc.nextLine();
                    System.out.println("Saisir  password");
                    password=sc.nextLine();
                    ut.setId(id);
                    ut.setEmail(email);
                    ut.setPassword(password);
                    dao.createUtilisateurs(ut);
                    break;
                case 2:
                    dao.showAllUtilisateurs();
                    break;

                case 3:
                    System.out.println("Saisir the id to delete");
                    id=sc.nextInt();
                    dao.deleteUtilisateurs(id);
                    break;

                case 4:
                    System.out.println("Merci et a la prochaine :) !!!");
                    System.exit(0);
                default:
                    System.out.println("Erreur. Veuillez verifier votre choix !");
                    break;

            }

            System.out.println("TAPPER 1 POUR CONTINUER");
            get = sc.nextInt();
            rep=get==1? true : false;

        }while (rep);


    }
}