package negocioAgenciaTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utils.MockPersistencia;
import Utils.MockUtils;
import modeloNegocio.Agencia;

public class GuardarAgenciaTest {

	Agencia ag;
	
	@Before
	public void setUp() throws Exception {
		this.ag = Agencia.getInstance();
	}

	@After
	public void tearDown() {
		MockUtils.resetSingleton(Agencia.class);
	}

	@Test
	public void guardarAgencia1() {
		try {
			boolean result = ag.guardarAgencia("test.xml");
			assertEquals(false, result);
		} catch (Exception e) {
			System.out.println(e);
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void guardarAgencia2() {
		try {
			ag.setPersistencia(new MockPersistencia<Object>(false));
			boolean result = ag.guardarAgencia("test.xml");
			assertEquals(true, result);
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void guardarAgencia3() {
		try {
			ag.setPersistencia(new MockPersistencia<Object>(true));
			ag.guardarAgencia("test.xml");
		} catch (IOException e) {
			// Error esperado
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}

}
