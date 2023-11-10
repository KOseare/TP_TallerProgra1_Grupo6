package testIntegracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import excepciones.ContraException;
import excepciones.NombreUsuarioException;
import modeloDatos.Cliente;
import modeloDatos.ClientePuntaje;
import modeloDatos.Contratacion;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;

public class TestCaso4 {

	private Agencia ag;
	private static boolean isAgInit = false;
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>(); // Primeros 2 empleados y ultimos 2 empleadores
	
	@Before
	public void setUp() throws Exception {
		this.ag = Agencia.getInstance();
		
		if (!isAgInit) {
			Cliente auxCliente;
			isAgInit = true;
			
			auxCliente = ag.registroEmpleado("emp1", "123456", "Empleado", "1", "+54223600001", 21);
			ag.crearTicketEmpleado(Constantes.HOME_OFFICE, 1100, Constantes.JORNADA_MEDIA, Constantes.SENIOR, Constantes.EXP_MUCHA, Constantes.TERCIARIOS, auxCliente);
			clientes.add(auxCliente);
			
			auxCliente = ag.registroEmpleado("emp2", "123456", "Empleado", "2", "+54223600002", 22);
			ag.crearTicketEmpleado(Constantes.PRESENCIAL, 1900, Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_MEDIA, Constantes.TERCIARIOS, auxCliente);
			clientes.add(auxCliente);
			
			auxCliente = ag.registroEmpleador("empr1", "123456", "Empleador1", "+54223610000", Constantes.FISICA, Constantes.COMERCIO_LOCAL);
			ag.crearTicketEmpleador(Constantes.PRESENCIAL, 1500, Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_MEDIA, Constantes.SECUNDARIOS, auxCliente);
			clientes.add(auxCliente);
			
			auxCliente = ag.registroEmpleador("empr2", "123456", "Empleador2", "+54223620000", Constantes.JURIDICA, Constantes.COMERCIO_INTERNACIONAL);
			ag.crearTicketEmpleador(Constantes.INDISTINTO, 1500, Constantes.JORNADA_MEDIA, Constantes.MANAGMENT, Constantes.EXP_MUCHA, Constantes.TERCIARIOS, auxCliente);
			clientes.add(auxCliente);
			
			clientes.get(0).setCandidato(clientes.get(2)); // Empleado 1 setea como candidato a Empleador 1
			clientes.get(1).setCandidato(clientes.get(2)); // Empleado 2 setea como candidato a Empleador 1
			clientes.get(2).setCandidato(clientes.get(0)); // Empleador 1 setea como candidato a Empleado 1

			ag.setEstadoContratacion(true);
			ag.gatillarRonda();
		}
	}
	
	@AfterClass
	public static void classTearDown () {
		MockUtils.resetSingleton(Agencia.class);
	}

	@Test
	public void casoDePruebaEmpleado1() {
		try {
			Cliente cl = (Cliente) this.ag.login("emp1", "123456");
			Cliente contratacion = ag.getContratacionEmpleadoPretenso((EmpleadoPretenso) cl);
			
			assertEquals(clientes.get(2), contratacion);
			assertEquals(10, cl.getPuntaje());
			assertEquals(1100.0 * 0.9, this.ag.getComisionUsuario(cl), 0.001);
		} catch (ContraException | NombreUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void casoDePruebaEmpleado2() {
		try {
			Cliente cl = (Cliente) this.ag.login("emp2", "123456");
			Cliente contratacion = ag.getContratacionEmpleadoPretenso((EmpleadoPretenso) cl);
			
			assertEquals(null, contratacion);
			assertEquals(0, cl.getPuntaje());
		} catch (ContraException | NombreUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void casoDePruebaEmpleador1() {
		try {
			Cliente cl = (Cliente) this.ag.login("empr1", "123456");
			Cliente contratacion = ag.getContratacionEmpleador((Empleador) cl);
			
			assertEquals(clientes.get(0), contratacion);
			assertEquals(50, cl.getPuntaje());
			assertEquals(1500.0 * 0.7, this.ag.getComisionUsuario(cl), 0.001);
		} catch (ContraException | NombreUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void casoDePruebaEmpleador2() {
		try {
			Cliente cl = (Cliente) this.ag.login("empr2", "123456");
			Cliente contratacion = ag.getContratacionEmpleador((Empleador) cl);
			
			assertEquals(null, contratacion);
			assertEquals(-20, cl.getPuntaje());
		} catch (ContraException | NombreUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Se lanzo un error inesperado");
		}
	}
	
}
