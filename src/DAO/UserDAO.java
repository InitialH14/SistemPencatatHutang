/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import iDAO.IUserDAO;
import model.User;
import helper.koneksiDB;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;


/**
 *
 * @author Victus 16
 */
public class UserDAO implements IUserDAO{
    private Connection con;
    private String strLogin = "SELECT * FROM user WHERE Nama = ?;";
    private String strSignup = "INSERT INTO user (Nik, Nama, Password) VALUES (?, ?, ?);";
    
    public UserDAO(){
        con = koneksiDB.getConnection();
    }

    @Override
    public boolean login(String nama, String password) {
        User usr;
        boolean result = true;
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(strLogin);
            statement.setString(1, nama);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                usr = new User();
                usr.setNik(rs.getString("Nik"));
                usr.setNama(rs.getString("Nama"));
                usr.setPassword(rs.getString("Password"));    
                System.out.println(usr.getNik());
            }
            
        }catch (SQLException e){
            System.out.println(e); 
            result = false;
        }
        return result;
    }

    @Override
    public boolean signup(User usr) {
        boolean result = true;
        PreparedStatement statement = null;
        try{
            statement = con.prepareStatement(strSignup);
            statement.setString(1, usr.getNik());
            statement.setString(2, usr.getNama());
            statement.setString(3, usr.getPassword());
            statement.execute(); 
            
        }catch (SQLException e){
            System.out.println("Signup Failed");
            result = false;
        } finally{
            try{
                if (statement != null){
                    statement.close();
                }
            }catch (SQLException ex){
                System.out.println("Signup Failed");
                result = false;                
            }
        }
        return result;
    }

    @Override
    public String getNikByName(String nama) {
        String nik = null;
        try{
            String query = "SELECT nik FROM user WHERE nama = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nama);
            ResultSet rs = stmt.executeQuery();   
            if(rs.next()){
                nik = rs.getString("nik");
                System.out.println(nik);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return nik;
    }
}
