package negocioAgenciaTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utils.MockUtils;
import modeloNegocio.Agencia;
import util.Constantes;

public class CerraSesionTest {

	Agencia ag;
	
	@Before
	public void setUp() throws Exception {
		this.ag = Agencia.getInstance();
		ag.registroEmpleado("empleado1", "123", "Nicolas", "+5492236012345", "Diaz", 28);
	}

	@After
	public void tearDown() {
		MockUtils.resetSingleton(Agencia.class);
	}

	@Test
	public void cerrarSesion1() {
		try {
			ag.cerrarSesion();
			assertEquals(-1, ag.getTipoUsuario());
		} catch (Exception e) {
			fail("Se lanza un error inesperado");
		}
	}
	
	@Test
	public void cerrarSesion2() {
		try {
			ag.login("empleado1", "123");
			ag.cerrarSesion();
			assertEquals(-1, ag.getTipoUsuario());
		} catch (Exception e) {
			fail("Se lanza un error inesperado");
		}
	}

}
