package testIntegracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utils.MockUtils;
import excepciones.ImposibleModificarTicketsException;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;

public class TestCaso2 {

	Agencia ag;
	EmpleadoPretenso usuario;
	
	@Before
	public void setUp() throws Exception {
		ag = Agencia.getInstance();
		this.usuario = (EmpleadoPretenso) ag.registroEmpleado("nicod", "123456", "Nicolas", "Diaz", "+542236012345", 21);
		ag.login("nicod", "123456");
	}

	@After
	public void tearDown() throws Exception {
		MockUtils.resetSingleton(Agencia.class);
	}

	@Test
	public void casoDePruebaA() {
		try {
			ag.crearTicketEmpleado(Constantes.HOME_OFFICE, 1000, Constantes.JORNADA_MEDIA, Constantes.SENIOR, Constantes.EXP_MUCHA, Constantes.TERCIARIOS, this.usuario);
			Ticket userTicket = this.usuario.getTicket();
			assertEquals(Constantes.HOME_OFFICE, userTicket.getLocacion());
			assertEquals(1000, userTicket.getRemuneracion());
			assertEquals(Constantes.JORNADA_MEDIA, userTicket.getJornada());
			assertEquals(Constantes.SENIOR, userTicket.getPuesto());
			assertEquals(Constantes.EXP_MUCHA, userTicket.getExperiencia());
			assertEquals(Constantes.TERCIARIOS, userTicket.getEstudios());
		} catch (ImposibleModificarTicketsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void casoDePruebaB() {
		try {
			ag.crearTicketEmpleado(Constantes.HOME_OFFICE, 1000, Constantes.JORNADA_MEDIA, Constantes.SENIOR, Constantes.EXP_MUCHA, Constantes.TERCIARIOS, this.usuario);
			ag.eliminarTicket();
			assertEquals(null, this.usuario.getTicket());
		} catch (ImposibleModificarTicketsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Se lanzo un error inesperado");
		}
	}

}
