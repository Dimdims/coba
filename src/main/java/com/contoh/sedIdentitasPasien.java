/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contoh;

import com.contoh.dataEnum.JenisKelamin;
import com.contoh.dataEnum.goldar;
import com.contoh.dataEnum.keluarga;
import com.contoh.dataEnum.pnd;
import com.contoh.dataEnum.sttsNikah;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 1110100890
 */
public class sedIdentitasPasien extends HttpServlet {
	private Dao dao = new Dao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
	
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res){
		try {
		identitasPasien ip = new identitasPasien();
                ip.setNoRM(req.getParameter("noRM"));
                ip.setNmPasien(req.getParameter("nmPasien"));
                ip.setTmpLahir(req.getParameter("tmpLahir"));
                
				String strTglLahir = req.getParameter("tglLahir");
                SimpleDateFormat formatterTanggal = new SimpleDateFormat("yyyy-MM-dd");
				ip.setTglLahir(formatterTanggal.parse(strTglLahir));
				
				ip.setJk(JenisKelamin.valueOf(req.getParameter("jk").toUpperCase()));
                ip.setGoldar(goldar.valueOf(req.getParameter("goldar").toUpperCase()));
                ip.setUsia(req.getParameter("usia"));
                ip.setNoKTP(req.getParameter("noKTP"));
                ip.setAlamat(req.getParameter("alamat"));
                ip.setPekerjaan(req.getParameter("pekerjaan"));
                ip.setSttsNikah(sttsNikah.valueOf(req.getParameter("sttsNikah").toUpperCase()));
                ip.setAgama(req.getParameter("agama"));
                ip.setNoTelp(req.getParameter("noTelp"));
                ip.setKeluarga(keluarga.valueOf(req.getParameter("keluarga").toUpperCase()));
                ip.setNmKeluarga(req.getParameter("nmKeluarga"));
                ip.setPnd(pnd.valueOf(req.getParameter("pnd").toUpperCase()));
	
			dao.simpan(ip);
			
			res.sendRedirect("index.jsp");
	} catch (Exception err) {
		err.printStackTrace();
	}
		
    }	
}
	