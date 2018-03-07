package com.aeg.jul.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.aeg.jul.modelo.daos.UserxDao;
import com.aeg.jul.modelo.entidades.Userx;

@ManagedBean
@SessionScoped
public class UserxBean {

  private boolean flagInsertar = false;
  private Userx Userx = new Userx();
  List<Userx> lstUsers;

  public void insertar() {
    //BasicConfigurator.configure();
    //PropertyConfigurator.configure("\\src\\main\\resources\\log4j.properties");

    UserxDao dao = new UserxDao();
    try {
      dao.insertar(Userx);
      //if (!FacesContext.getCurrentInstance().isPostback()) {
      lstUsers = dao.listar();
      //}
    } catch (Exception e) {
    	System.out.println("Exception Userxbean insertar "+e.getMessage());
    }
  }

  public void listar() {
    UserxDao dao = new UserxDao();
    try {
      lstUsers = dao.listar();
    } catch (Exception e) {
    	System.out.println("Exception Userxbean listar "+e.getMessage());
    }
  }

  public void cargar(Userx Userx) {
    flagInsertar = false;
    UserxDao dao = new UserxDao();
    Userx per;
    try {
      per = dao.cargar(Userx);
      if (per != null) {
        this.Userx = per;
      }
    } catch (Exception e) {
    	System.out.println("Exception Userxbean cargar "+e.getMessage());
    }
  }

  public void limpiar() {
    try {
      flagInsertar = true;
      this.Userx.setUsername(null);
      this.Userx.setFirstName(null);
      this.Userx.setLastName(null);
      this.Userx.setEmail(null);
      this.Userx.setPassword(null);
      this.Userx.setPhone(null);
      this.Userx.setUserStatus(null);
    } catch (Exception e) {
    	System.out.println("Exception Userxbean limpiar "+e.getMessage());
    }
  }

  public void modificar() {
    UserxDao dao = new UserxDao();
    try {
      dao.modificar(this.Userx);
      this.listar();
    } catch (Exception e) {
    	System.out.println("Exception Userxbean modificar "+e.getMessage());
    }
  }

  public void eliminar(Userx Userx) {
    UserxDao dao = new UserxDao();
    try {
      dao.eliminar(Userx);
      this.listar();
    } catch (Exception e) {
    	System.out.println("Exception Userxbean eliminar "+e.getMessage());
    }
  }


  //-------------------------------------------------------------------------------
  public Userx getUserx() {
    return Userx;
  }

  public void setUserx(Userx Userx) {
    this.Userx = Userx;
  }

  public List<Userx> getlstUsers() {
    return lstUsers;
  }

  public void setlstUsers(List<Userx> lstUsers) {
    this.lstUsers = lstUsers;
  }

  public boolean isFlagInsertar() {
    return flagInsertar;
  }

  public void setFlagInsertar(boolean flagInsertar) {
    this.flagInsertar = flagInsertar;
  }

}
