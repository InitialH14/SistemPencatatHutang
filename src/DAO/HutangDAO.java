/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import iDAO.IHutangDAO;
import java.util.List;
import model.User;
import model.Hutang;
import view.Login;
import Session.SessionManager;
import helper.koneksiDB;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Victus 16
 */
public class HutangDAO implements IHutangDAO{
    Connection con;
    User usr;
    String nik;
    String coba;
//    Login loginfrm;
    
    private String strInsert = "INSERT INTO hutang (kode_hutang, tggl_mulai_hutang, tenggat_hutang, jumlah_hutang, keterangan_hutang, id_kreditur, id_debitur) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private String strReadByUser = "SELECT h.kode_hutang, h.tggl_mulai_hutang, h.tenggat_hutang, h.jumlah_hutang, h.keterangan_hutang, d.nama_debitur \n" +
                                    "FROM hutang h \n" +
                                    "JOIN debitur d ON h.id_debitur = d.nik_debitur \n" +
                                    "WHERE h.id_kreditur = ? \n" +
                                    "GROUP BY h.kode_hutang, h.tggl_mulai_hutang, h.tenggat_hutang, h.jumlah_hutang, h.keterangan_hutang, d.nama_debitur;";
    private String strUpdate = "UPDATE hutang SET tggl_mulai_hutang = ?, tenggat_hutang = ?, jumlah_hutang = ?, keterangan_hutang = ?, id_debitur = ? WHERE kode_hutang = ?;";
    private String strDelete = "DELETE FROM hutang WHERE kode_hutang = ?;";
    private String strLogin = "SELECT * FROM user WHERE Nama = ? AND Password = ?;";
   
    
    public HutangDAO(){
        con = koneksiDB.getConnection();
        usr = new User();
    }

    @Override
    public String login(SessionManager session) {
        this.coba = "item";
        String result = null;
        PreparedStatement statement;
        System.out.println(session.getNama());
        try{
            statement = con.prepareStatement(strLogin);
            statement.setString(1, session.getNama());
            statement.setString(2, session.getPassword());
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()){
                session.saveNik(rs.getString("Nik"));
                result =  session.getNik();
                this.nik = result;
                System.out.println(nik);
            }
            
        }catch (SQLException e){
            System.out.println(e); 
            result = null;
        }
        return result;
    }
    
    @Override
    public List<Hutang> getHutangsByKreditur() {
        List<Hutang> hutangList = new ArrayList<>();
        try{
            System.out.println(coba);
            PreparedStatement statement = con.prepareStatement(strReadByUser);
            statement.setString(1, usr.getNik());
            statement.execute();
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Hutang hutang = new Hutang();
                hutang.setKode_hutang(rs.getString("h.kode_hutang"));
                hutang.setTggl_mulai_hutang(rs.getDate("h.tggl_mulai_hutang"));
                hutang.setTenggat_hutang(rs.getDate("h.tenggat_hutang"));
                hutang.setJumlah_hutang(rs.getDouble("h.jumlah_hutang"));
                hutang.setKeterangan_hutang(rs.getString("h.keterangan_hutang"));
                hutang.setId_kreditur(rs.getString("h.id_kreditur"));
                hutang.setId_debitur(rs.getString("h.id_debitur"));
                hutangList.add(hutang);                
            }
        }catch (SQLException e){
            System.out.println("Error"+ e);
        }
        return hutangList;
    }

    @Override
    public boolean insert(Hutang htg) {
        boolean result = true;
        PreparedStatement statement  = null;
        try{
            statement = con.prepareStatement(strInsert);
            statement.setString(1, htg.getKode_hutang());
            statement.setDate(2, new java.sql.Date(htg.getTggl_mulai_hutang().getTime()));
            statement.setDate(3, new java.sql.Date(htg.getTenggat_hutang().getTime()));
            statement.setDouble(4, htg.getJumlah_hutang());
            statement.setString(5, htg.getKeterangan_hutang());
            statement.setString(6, htg.getId_kreditur());
            statement.setString(7, htg.getId_debitur());
            statement.execute(); 
            
        }catch (SQLException e){
            System.out.println("Inset failed");
            result = false;
        }finally{
            try{
                if (statement != null){
                    statement.close();
                }
            }catch (SQLException ex){
                System.out.println("Insert Failed");
                result = false;
            }
        }
        return result;
    }

    @Override
    public void update(Hutang htg) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int kodeHutang) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
