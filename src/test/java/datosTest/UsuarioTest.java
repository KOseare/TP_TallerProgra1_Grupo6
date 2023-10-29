package datosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modeloDatos.Usuario;

public class UsuarioTest {


	@Test
	public void testUsuarioStringStringStringString() {
		Usuario u = new Usuario("nicod", "123456", "Nicolas Diaz", "+542236012345");
		assertEquals("nicod", u.getUsserName());
		assertEquals("123456", u.getPassword());
		assertEquals("Nicolas Diaz", u.getRealName());
		assertEquals("+542236012345", u.getTelefono());
	}

	@Test
	public void testGetSetUsserName() {
		Usuario u = new Usuario();
		u.setUsserName("nicod");
		assertEquals("nicod", u.getUsserName());
	}

	@Test
	public void testGetSetPassword() {
		Usuario u = new Usuario();
		u.setPassword("123456");
		assertEquals("123456", u.getPassword());
	}

	@Test
	public void testGetSetTelefono() {
		Usuario u = new Usuario();
		u.setTelefono("+542236012345");
		assertEquals("+542236012345", u.getTelefono());
	}


	@Test
	public void testGetSetRealName() {
		Usuario u = new Usuario();
		u.setRealName("Nicolas Diaz");
		assertEquals("Nicolas Diaz", u.getRealName());
	}

	@Test
	public void testToString() {
		Usuario u = new Usuario("nicod", "123456", "Nicolas Diaz", "123456");
		assertEquals("nicod, realName=Nicolas Diaz", u.toString());
	}

}
