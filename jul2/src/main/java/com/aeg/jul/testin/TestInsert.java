package com.aeg.jul.testin;

import com.aeg.jul.modelo.daos.UserxDao;
import com.aeg.jul.modelo.entidades.Userx;

import junit.framework.TestCase;

public class TestInsert extends TestCase {

	public void testInsertar() {

			Userx user = new Userx();
			user.setUsername("prueba123456789");
			user.setFirstName("fisrt123456789");
			user.setLastName("Last123456789");
			user.setEmail("email123456789");
			user.setPassword("password123456789");
			user.setPhone("fisrt123456789");
			user.setUserStatus("status123456789");
			UserxDao dao = new UserxDao();
			dao.insertar(user);
			
			int tmp=0;
			assertEquals(tmp, 1);
		
	}

}
