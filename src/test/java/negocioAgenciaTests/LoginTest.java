package negocioAgenciaTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utils.MockUtils;
import excepciones.ContraException;
import excepciones.NombreUsuarioException;
import modeloNegocio.Agencia;
import util.Constantes;

public class LoginTest {

	Agencia ag;
	
	@Before
	public void setUp() throws Exception {
		this.ag = Agencia.getInstance();
		ag.registroEmpleado("empleado1", "123", "Nicolas", "+5492236012345", "Diaz", 28);
		ag.registroEmpleador("empleador1", "456", "Nicolas Diaz", "+542236012345", Constantes.FISICA, Constantes.SALUD);
	}

	@After
	public void tearDown() {
		MockUtils.resetSingleton(Agencia.class);
	}

	@Test
	public void loginTest1() {
		try {
			ag.login("user", "124");
		} catch (NombreUsuarioException e) {
			// Error esperado
		} catch (Exception e) {
			fail("Lanza error inesperado");
		}
	}
	
	@Test
	public void loginTest2() {
		try {
			ag.login("empleado1", "124");
		} catch (ContraException e) {
			// Error esperado
		} catch (Exception e) {
			fail("Lanza error inesperado");
		}
	}
	
	@Test
	public void loginTest3() {
		try {
			ag.login("empleado1", "123");
			assertEquals(0, ag.getTipoUsuario());
		} catch (Exception e) {
			fail("Lanza error inesperado");
		}
	}
	
	@Test
	public void loginTest4() {
		try {
			ag.login("empleador1", "456");
			assertEquals(1, ag.getTipoUsuario());
		} catch (Exception e) {
			fail("Lanza error inesperado");
		}
	}
	
	@Test
	public void loginTest5() {
		try {
			ag.login("admin", "admin");
			assertEquals(2, ag.getTipoUsuario());
		} catch (Exception e) {
			fail("Lanza error inesperado");
		}
	}
	
	

}
