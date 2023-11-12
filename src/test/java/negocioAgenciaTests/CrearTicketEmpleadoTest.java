package negocioAgenciaTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utils.MockUtils;
import modeloDatos.Cliente;
import modeloDatos.Ticket;
import modeloNegocio.Agencia;
import util.Constantes;

public class CrearTicketEmpleadoTest {

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
	public void testCrearTicketEmpleado1() {
		try {
			Cliente emp = ag.registroEmpleado("nicod1", "123456", "Nicolas", "Diaz", "+542236012345", 21);
			ag.crearTicketEmpleado(Constantes.HOME_OFFICE, 1500, Constantes.JORNADA_COMPLETA, Constantes.SENIOR, Constantes.EXP_MEDIA, Constantes.TERCIARIOS, emp);
			
			Ticket ticket = emp.getTicket();
			assertEquals(Constantes.HOME_OFFICE, ticket.getLocacion());
			assertEquals(1500, ticket.getRemuneracion());
			assertEquals(Constantes.JORNADA_COMPLETA, ticket.getJornada());
			assertEquals(Constantes.SENIOR, ticket.getPuesto());
			assertEquals(Constantes.EXP_MEDIA, ticket.getExperiencia());
			assertEquals(Constantes.TERCIARIOS, ticket.getEstudios());
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void testCrearTicketEmpleado2() {
		try {
			Cliente emp = ag.registroEmpleado("nicod1", "123456", "Nicolas", "Diaz", "+542236012345", 21);
			ag.crearTicketEmpleado(Constantes.INDISTINTO, 2000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_MUCHA, Constantes.SECUNDARIOS, emp);
			Ticket oldTicket = emp.getTicket();
			
			ag.crearTicketEmpleado(Constantes.HOME_OFFICE, 1500, Constantes.JORNADA_COMPLETA, Constantes.SENIOR, Constantes.EXP_MEDIA, Constantes.TERCIARIOS, emp);
			Ticket ticket = emp.getTicket();
			
			assertEquals(Constantes.HOME_OFFICE, ticket.getLocacion());
			assertEquals(1500, ticket.getRemuneracion());
			assertEquals(Constantes.JORNADA_COMPLETA, ticket.getJornada());
			assertEquals(Constantes.SENIOR, ticket.getPuesto());
			assertEquals(Constantes.EXP_MEDIA, ticket.getExperiencia());
			assertEquals(Constantes.TERCIARIOS, ticket.getEstudios());
			assertEquals(ticket, oldTicket);
		} catch (Exception e) {
			fail("Se lanzo un error inesperado " + e.getMessage());
		}
	}

}
