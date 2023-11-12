package negocioAgenciaTests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utils.MockUtils;
import modeloDatos.Cliente;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;

public class GatillarRondaTest {

	Agencia ag;
	
	@Before
	public void setUp() throws Exception {
		try {
			Cliente auxCliente;
			this.ag = Agencia.getInstance();
			
			auxCliente = ag.registroEmpleado("emp1", "123456", "Empleado", "1", "+54223600001", 21);
			ag.crearTicketEmpleado(Constantes.HOME_OFFICE, 1100, Constantes.JORNADA_MEDIA, Constantes.SENIOR, Constantes.EXP_MUCHA, Constantes.TERCIARIOS, auxCliente);
			
			auxCliente = ag.registroEmpleado("emp2", "123456", "Empleado", "2", "+54223600002", 22);
			ag.crearTicketEmpleado(Constantes.PRESENCIAL, 1900, Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_MEDIA, Constantes.TERCIARIOS, auxCliente);
			
			auxCliente = ag.registroEmpleador("empr1", "123456", "Empleador1", "+54223610000", Constantes.FISICA, Constantes.COMERCIO_LOCAL);
			ag.crearTicketEmpleador(Constantes.PRESENCIAL, 1500, Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_MEDIA, Constantes.SECUNDARIOS, auxCliente);
			
			auxCliente = ag.registroEmpleador("empr2", "123456", "Empleador2", "+54223620000", Constantes.JURIDICA, Constantes.COMERCIO_INTERNACIONAL);
			ag.crearTicketEmpleador(Constantes.INDISTINTO, 1500, Constantes.JORNADA_MEDIA, Constantes.MANAGMENT, Constantes.EXP_MUCHA, Constantes.TERCIARIOS, auxCliente);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@After
	public void tearDown() {
		MockUtils.resetSingleton(Agencia.class);
	}

	@Test
	public void gatillarRonda1() {
		ag.gatillarRonda();
		
		EmpleadoPretenso emp1 = ag.getEmpleados().get("emp1"), emp2 = ag.getEmpleados().get("emp2");
		Empleador empr1 = ag.getEmpleadores().get("empr1"), empr2 = ag.getEmpleadores().get("empr2");
		
		assertEquals(emp1, empr1.getListaDePostulantes().get(1).getCliente());
		assertEquals(emp2, empr1.getListaDePostulantes().get(0).getCliente());

		assertEquals(emp1, empr2.getListaDePostulantes().get(0).getCliente());
		assertEquals(emp2, empr2.getListaDePostulantes().get(1).getCliente());

		assertEquals(empr1, emp1.getListaDePostulantes().get(1).getCliente());
		assertEquals(empr2, emp1.getListaDePostulantes().get(0).getCliente());

		assertEquals(empr1, emp2.getListaDePostulantes().get(0).getCliente());
		assertEquals(empr2, emp2.getListaDePostulantes().get(1).getCliente());
		
		assertEquals(true, ag.isEstadoContratacion());
	}
	
	@Test
	public void gatillarRonda2() {		
		EmpleadoPretenso emp1 = ag.getEmpleados().get("emp1"), emp2 = ag.getEmpleados().get("emp2");
		Empleador empr1 = ag.getEmpleadores().get("empr1"), empr2 = ag.getEmpleadores().get("empr2");
		emp1.setCandidato(empr1);
		emp2.setCandidato(empr1);
		empr1.setCandidato(emp1);
		empr2.setCandidato(emp2);
		
		ag.setEstadoContratacion(true);
		ag.gatillarRonda();
		
		assertEquals(1, ag.getContrataciones().size());
		assertEquals(emp1, ag.getContrataciones().get(0).getEmpleado());
		assertEquals(empr1, ag.getContrataciones().get(0).getEmpleador());
	
		assertEquals(-20, emp2.getPuntaje());
	
		assertEquals(false, ag.isEstadoContratacion());
	}

}
