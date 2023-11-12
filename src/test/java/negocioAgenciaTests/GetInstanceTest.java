package negocioAgenciaTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import Utils.MockUtils;
import modeloNegocio.Agencia;

public class GetInstanceTest {

	@After
	public void tearDown() {
		MockUtils.resetSingleton(Agencia.class);
	}
	
	@Test
	public void testGetInstance1() {
		Agencia ag = Agencia.getInstance();
		assertTrue(ag.getEmpleados() != null);
		assertTrue(ag.getEmpleadores() != null);
		assertTrue(ag.getContrataciones() != null);
		assertTrue(ag.getComisionesUsuarios() != null);
		assertEquals(ag.getLimiteInferior(), 1000);
		assertEquals(ag.getLimiteSuperior(), 2000);
	}
	
	@Test
	public void testGetInstance2 () {
		Agencia ag = Agencia.getInstance();
		assertEquals(ag, Agencia.getInstance());
	}

}
