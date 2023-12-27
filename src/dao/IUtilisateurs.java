package dao;

import entities.Utilisateurs;

public interface IUtilisateurs {
    //creer un utilisateurs
    public void createUtilisateurs(Utilisateurs ut);
    //Montrer tous les Utilisateurs
    public void showAllUtilisateurs();
    //delete Utilisateurs
    public void deleteUtilisateurs(int id);
}
