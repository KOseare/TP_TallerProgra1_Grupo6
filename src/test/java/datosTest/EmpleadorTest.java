package datosTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modeloDatos.Empleador;
import util.Constantes;

public class EmpleadorTest {

	@Test
	public void testCalculaComision() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetRubro() {
		Empleador e = new Empleador("pablo_r", "123456", "Pablo Rosas", "+5492236012345", Constantes.COMERCIO_LOCAL, Constantes.EMPLEADOR);
		String resultado = e.getRubro();
		assertEquals(resultado, Constantes.COMERCIO_LOCAL);
	}

	@Test
	public void testEmpleador() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetTipoPersona() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetRubro() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetTipoPersona() {
		//fail("Not yet implemented");
	}

	@Test
	public void testEmpleadorStringStringStringStringStringString() {
		//fail("Not yet implemented");
	}

}
