package negocioAgenciaTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utils.MockUtils;
import modeloDatos.EmpleadoPretenso;
import modeloNegocio.Agencia;
import util.Constantes;

public class EliminarTicketTest {

Agencia ag;
	
	@Before
	public void setUp() throws Exception {
		try {
			this.ag = Agencia.getInstance();
			ag.registroEmpleado("empleado1", "123", "Nicolas", "+5492236012345", "Diaz", 28);
			ag.login("empledo1", "123");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@After
	public void tearDown() {
		MockUtils.resetSingleton(Agencia.class);
	}

	@Test
	public void eliminarTicket1() {
		try {
			ag.eliminarTicket();
			EmpleadoPretenso emp = ag.getEmpleados().get("empleado1");
			assertEquals(null, emp.getTicket());
		} catch (Exception e) {
			System.out.println(e);
			fail("Lanzo un error inesperado");
		}
	}
	
	@Test
	public void eliminarTicket2() {
		try {
			EmpleadoPretenso emp = ag.getEmpleados().get("empleado1");
			ag.crearTicketEmpleado(Constantes.INDISTINTO, 2000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_MUCHA, Constantes.SECUNDARIOS, emp);
			ag.eliminarTicket();
			assertEquals(null, emp.getTicket());
		} catch (Exception e) {
			System.out.println(e);
			fail("Lanzo un error inesperado");
		}
	}

}
