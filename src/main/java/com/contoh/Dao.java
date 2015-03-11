/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contoh;

/**
 *
 * @author 1110100890
 */
import java.sql.*;

public class Dao {
	private Connection con;
    private Statement stat;
	private final String dbDriver = "com.mysql.jdbc.Driver";
	private final String dbUrl = "jdbc:mysql://localhost/rm";
	private final String dbUsername = "root";
	private final String dbPassword = "admin";
	
	
        public void connect() {
	try {
		Class.forName(dbDriver);
		con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
	} catch (Exception err) {
	   err.printStackTrace(); 
            }
	}   
	
	public void disconnect () {
	try {
		if(con != null) {
			con.close();
			}
	} catch (Exception err) {
	}
	}
        
        public void simpan(identitasPasien ip) {
            try {
				connect();
				
                String sql = "insert into identitaspasien"
                        + "(noRM, nmPasien, tmpLahir, tglLahir, jk, goldar, usia, noKTP, alamat, pekerjaan, sttsNikah, agama, noTelp, keluarga, nmKeluarga, pnd)"
                        + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, ip.getNoRM());
				ps.setString(2, ip.getNmPasien());
				ps.setString(3, ip.getTmpLahir());
				ps.setDate(4, new java.sql.Date(ip.getTglLahir().getTime()));
				ps.setString(5, ip.getJk().toString());
				ps.setString(6, ip.getGoldar().toString());
                ps.setString(7, ip.getUsia());
				ps.setString(8, ip.getNoKTP());
				ps.setString(9, ip.getAlamat());
				ps.setString(10, ip.getPekerjaan());
				ps.setString(11, ip.getSttsNikah().toString());
				ps.setString(12, ip.getAgama());
                ps.setString(13, ip.getNoTelp());
				ps.setString(14, ip.getKeluarga().toString());
				ps.setString(15, ip.getNmKeluarga());
				ps.setString(16, ip.getPnd().toString());
                ps.executeUpdate();
                
		disconnect();
	} catch (Exception err) {
	   err.printStackTrace(); 
            }
        }
        
/**        public void hapus(){
        Class.forName(dbDriver);
		con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                String sql = "delete from identitaspasien where"
                        + ""
                        + "(noRM, nmPasien, tmpLahir, tglLahir, jk, goldar, usia, noKTP, alamat, pekerjaan, sttsNikah, agama, noTelp, keluarga, nmkeluarga, pnd)"
                        + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                
        }
        **/
}
