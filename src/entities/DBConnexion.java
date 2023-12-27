package entities;

import java.sql.DriverManager;
import java.sql.Connection;

public class DBConnexion {
    static Connection con;
    public static Connection createDBConnection(){

        try{
            //Chargement driver
            Class.forName("com.mysql.jdbc.Driver");
            //Connexion
            String url="jdbc:mysql://localhost:3306/gestionUsers?useSSL=false";
            String username="root";
            String password="root";
            con= DriverManager.getConnection(url,username,password);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return con;

    }


}
