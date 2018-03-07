package com.aeg.jul.modelo.daos;

import com.aeg.jul.modelo.utils.ConexionBd;
import com.aeg.jul.modelo.entidades.Userx;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserxDao extends ConexionBd {

	public void insertar(Userx user) {
  try {
      conectarBd();
      String stmnt = "insert into userx(	" +
      		"username, "+	
      		"firstName, "+
      		"lastName, "+	
      		"email, "+		
      		"password, "+	
      		"phone, "+		
      		"userStatus" +
      		") "+
      		"values (?,?,?,?,?,?,?)";
      
      PreparedStatement st = getCon().prepareStatement(stmnt);
          st.setString(1, user.getUsername());
          st.setString(2, user.getFirstName());
          st.setString(3, user.getLastName());
          st.setString(4, user.getEmail());
          st.setString(5, user.getPassword());
          st.setString(6, user.getPhone());
          st.setString(7, user.getUserStatus());
      st.executeUpdate();
  } catch (Exception e) {
      Logger.getLogger(ConexionBd.class.getName()).log(Level.SEVERE, null, e);
  } finally {
      desconectarBd();
  }
    }

	public List<Userx> listar() throws Exception {
		List lista = new ArrayList<Userx>();
		ResultSet rs;
		try {
			conectarBd();
			String sntc="select username,firstName," +
					"lastName,email,password,phone,userStatus from Userx" ; 
			PreparedStatement st = getCon().prepareStatement(sntc);
			rs = st.executeQuery();
			while (rs.next()) {
				Userx user = new Userx();
				user.setUsername(rs.getString("username"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setUserStatus(rs.getString("userstatus"));
				lista.add(user);
			}

		} catch (Exception e) {
			throw e;
		} finally {
			desconectarBd();
		}
		return lista;
	}

	public Userx cargar(Userx user) throws Exception {
		Userx Userx = new Userx();
		try {
			conectarBd();
			String sntc="select username,firstName," +
					"lastName,email,password,phone,userStatus from Userx where username=?" ; 
			PreparedStatement st = getCon().prepareStatement(sntc);
			ResultSet rs;
			st.setString(1, user.getUsername());
			rs = st.executeQuery();
			while (rs.next()) {
				Userx.setUsername(rs.getString("username"));
				Userx.setFirstName(rs.getString("firstName"));
				Userx.setLastName(rs.getString("lastName"));
				Userx.setEmail(rs.getString("email"));
				Userx.setPassword(rs.getString("password"));
				Userx.setPhone(rs.getString("phone"));
				Userx.setUserStatus(rs.getString("userStatus"));
			}

		} catch (Exception e) {
			throw e;
		} finally {
			desconectarBd();
		}
		return Userx;
	}

	public void modificar(Userx user) {
		try {
			conectarBd();
			String sntc = "update Userx set firstname=?,lastname=?,email=?,password=?,phone=?,userstatus=? where username=? ";
			PreparedStatement st = getCon().prepareStatement(sntc);
			st.setString(1, user.getFirstName());
			st.setString(2, user.getLastName());
			st.setString(3, user.getEmail());
			st.setString(4, user.getPassword());
			st.setString(5, user.getPhone());
			st.setString(6, user.getUserStatus());
			st.setString(7, user.getUsername());
			st.executeUpdate();
		} catch (Exception e) {
			Logger.getLogger(ConexionBd.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			desconectarBd();
		}
	}

	public void eliminar(Userx user) {
		try {
			conectarBd();
			PreparedStatement st = getCon().prepareStatement("delete from Userx where username =?");
			st.setString(1, user.getUsername());
			st.executeUpdate();
		} catch (Exception e) {
			Logger.getLogger(ConexionBd.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			desconectarBd();
		}
	}

}
