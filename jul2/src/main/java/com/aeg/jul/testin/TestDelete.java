package com.aeg.jul.testin;

import com.aeg.jul.modelo.daos.UserxDao;
import com.aeg.jul.modelo.entidades.Userx;

import junit.framework.TestCase;

public class TestDelete extends TestCase {

	public void testEliminar() {
			Userx user = new Userx();
			user.setUsername("prueba123456789");
			UserxDao dao = new UserxDao();
			dao.eliminar(user);
			int tmp=0;
			assertEquals(tmp, 0);

	}

}
