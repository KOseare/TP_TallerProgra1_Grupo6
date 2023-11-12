package negocioAgenciaTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utils.MockUtils;
import excepciones.LimiteInferiorRemuneracionInvalidaException;
import excepciones.LimiteSuperiorRemuneracionInvalidaException;
import modeloNegocio.Agencia;

public class SetLimitesRemuneracionTest {

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
	public void setLimitesRemuneracion1() {
		try {
			this.ag.setLimitesRemuneracion(-100, 200);
		} catch (LimiteInferiorRemuneracionInvalidaException e) {
			// Error esperado
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void setLimitesRemuneracion2() {
		try {
			this.ag.setLimitesRemuneracion(100, 200);
			assertEquals(this.ag.getLimiteInferior(), 100);
			assertEquals(this.ag.getLimiteSuperior(), 200);
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void setLimitesRemuneracion3() {
		try {
			this.ag.setLimitesRemuneracion(300, 200);
		} catch (LimiteSuperiorRemuneracionInvalidaException e) {
			// Error esperado
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void setLimitesRemuneracion4() {
		try {
			this.ag.setLimitesRemuneracion(-100, -50);
		} catch (LimiteInferiorRemuneracionInvalidaException e) {
			// Error esperado
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}

}
