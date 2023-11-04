package datosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modeloDatos.Admin;

public class AdminTest {

	@Test
	public void testAdmin() {
		Admin a = new Admin();
		assertEquals("Administrador", a.getRealName());
	}
	
	@Test
	public void testToString() {
		Admin a = new Admin();
		assertEquals("Administrador", a.toString());
	}

}
