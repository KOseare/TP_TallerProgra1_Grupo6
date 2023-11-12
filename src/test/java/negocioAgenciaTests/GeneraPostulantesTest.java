package negocioAgenciaTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utils.MockUtils;
import modeloDatos.Cliente;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;

public class GeneraPostulantesTest {

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
	public void testMatch1() {
		try {
			Cliente emp1 = ag.registroEmpleado("nicod1", "123456", "Nicolas", "Diaz", "+542236012345", 21);
			Cliente emp2 = ag.registroEmpleado("nicod2", "123456", "Nicolas", "Diaz", "+542236012345", 21);
			Cliente empr = ag.registroEmpleador("nicod3", "123456", "Nicolas", "+542236012345", Constantes.FISICA, Constantes.COMERCIO_INTERNACIONAL);
			ag.crearTicketEmpleado(Constantes.HOME_OFFICE, 1000, Constantes.JORNADA_MEDIA, Constantes.SENIOR, Constantes.EXP_MUCHA, Constantes.TERCIARIOS, emp1);
			ag.crearTicketEmpleado(Constantes.INDISTINTO, 1000, Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.TERCIARIOS, emp2);
			ag.crearTicketEmpleador(Constantes.HOME_OFFICE, 1000, Constantes.JORNADA_MEDIA, Constantes.SENIOR, Constantes.EXP_MUCHA, Constantes.TERCIARIOS, empr);
			
			ag.generaPostulantes();
			
			assertEquals(emp1, empr.getListaDePostulantes().get(0).getCliente());
			assertEquals(emp2, empr.getListaDePostulantes().get(1).getCliente());
			assertEquals(empr, emp1.getListaDePostulantes().get(0).getCliente());
			assertEquals(empr, emp2.getListaDePostulantes().get(0).getCliente());
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void testMatch2() {
		try {
			Cliente emp = ag.registroEmpleado("nicod1", "123456", "Nicolas", "Diaz", "+542236012345", 21);
			Cliente empr1 = ag.registroEmpleador("nicod2", "123456", "Nicolas", "+542236012345", Constantes.FISICA, Constantes.COMERCIO_INTERNACIONAL);
			Cliente empr2 = ag.registroEmpleador("nicod3", "123456", "Nicolas", "+542236012345", Constantes.FISICA, Constantes.COMERCIO_INTERNACIONAL);
			ag.crearTicketEmpleado(Constantes.HOME_OFFICE, 1000, Constantes.JORNADA_MEDIA, Constantes.SENIOR, Constantes.EXP_MUCHA, Constantes.TERCIARIOS, emp);
			ag.crearTicketEmpleado(Constantes.INDISTINTO, 1000, Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.TERCIARIOS, empr1);
			ag.crearTicketEmpleador(Constantes.HOME_OFFICE, 1000, Constantes.JORNADA_MEDIA, Constantes.SENIOR, Constantes.EXP_MUCHA, Constantes.TERCIARIOS, empr2);
			
			ag.generaPostulantes();
			
			assertEquals(empr2, emp.getListaDePostulantes().get(0).getCliente());
			assertEquals(empr1, emp.getListaDePostulantes().get(1).getCliente());
			assertEquals(emp, empr1.getListaDePostulantes().get(0).getCliente());
			assertEquals(emp, empr2.getListaDePostulantes().get(0).getCliente());
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}

}
