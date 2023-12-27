package dao;
import entities.DBConnexion;
import entities.Utilisateurs;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class UtilisateursImpl implements IUtilisateurs{
    Connection con;

    @Override
    public void createUtilisateurs(Utilisateurs ut) {
        DBConnexion DBConnection = new DBConnexion();
        con =DBConnection.createDBConnection();
        String query="insert into Utilisateurs(email, password, passwordHashed, idRole) values(?,?,?,?)";
        try{
            String hashedPassword = hashPasswordSHA256(ut.getPassword());
            PreparedStatement tmp=con.prepareStatement(query);
            tmp.setString(1,ut.getEmail());
            tmp.setString(2,ut.getPassword());
            tmp.setString(3,hashedPassword);
            tmp.setString(4,ut.getIdRole() );
            int cnt= tmp.executeUpdate();
            if(cnt!=0)
                System.out.println("Nice  !!!");


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }


    @Override
    public void showAllUtilisateurs() {
        DBConnexion DBConnection = new DBConnexion();
        con=DBConnection.createDBConnection();
        String query="select * from Utilisateurs";
        System.out.println("Utilisateurs Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\n","ID","Email","PasswordHashed");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(4));
                System.out.println("---------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteUtilisateurs(int id) {
        DBConnexion DBConnection = new DBConnexion();
        con=DBConnection.createDBConnection();
        String query="delete from Utilisateurs where id=?";
        try{
            PreparedStatement tmp=con.prepareStatement(query);
            tmp.setInt(1,id);
            int cnt= tmp.executeUpdate();
            if(cnt!=0)
                System.out.println("Utilisateurs Deleted Successfully!!! "+id);

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }

    private String hashPasswordSHA256(String password) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes());

        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
