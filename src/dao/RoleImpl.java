package dao;

import entities.DBConnexion;
import entities.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoleImpl implements IRole{
    Connection con;
    @Override
    public void createRole(Role rl) {
        DBConnexion DBConnection = new DBConnexion();
        con =DBConnection.createDBConnection();
        String query="insert into role(name) values(?)";
        try{

            PreparedStatement tmp=con.prepareStatement(query);
            tmp.setString(1,rl.getName());
            int cnt= tmp.executeUpdate();
            if(cnt!=0)
                System.out.println("Role Inserted Successfully !!!");


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void showAllRole() {
        DBConnexion DBConnection = new DBConnexion();
        con=DBConnection.createDBConnection();
        String query="select * from role";
        System.out.println("Role Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\n","ID","Name");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2));
                System.out.println("---------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
