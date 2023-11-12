package negocioAgenciaTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utils.MockUtils;
import modeloDatos.Cliente;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;

public class MatchTest {

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
	public void testMatch() {
		try {
			Cliente emp = ag.registroEmpleado("nicod1", "123456", "Nicolas", "Diaz", "+542236012345", 21);
			Cliente empr = ag.registroEmpleador("nicod4", "123456", "Nicolas", "+542236012345", Constantes.FISICA, Constantes.COMERCIO_INTERNACIONAL);
			ag.crearTicketEmpleado(Constantes.HOME_OFFICE, 1000, Constantes.JORNADA_MEDIA, Constantes.SENIOR, Constantes.EXP_MUCHA, Constantes.TERCIARIOS, emp);
			ag.crearTicketEmpleador(Constantes.HOME_OFFICE, 1000, Constantes.JORNADA_MEDIA, Constantes.SENIOR, Constantes.EXP_MUCHA, Constantes.TERCIARIOS, empr);
			emp.setCandidato(empr);
			empr.setCandidato(emp);
			
			ag.match((Empleador) empr, (EmpleadoPretenso) emp);
			
			assertEquals(1, ag.getContrataciones().size());
			assertEquals(10, emp.getPuntaje());
			assertEquals(50, empr.getPuntaje());
			assertEquals(800.0, ag.getComisionUsuario(emp), 0.001);
			assertEquals(800.0, ag.getComisionUsuario(empr), 0.001);
			assertEquals(null, emp.getTicket());
			assertEquals(null, empr.getTicket());
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}

}
