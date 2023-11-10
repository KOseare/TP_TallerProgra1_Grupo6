package testIntegracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import excepciones.ContraException;
import excepciones.NombreUsuarioException;
import modeloDatos.Cliente;
import modeloDatos.ClientePuntaje;
import modeloNegocio.Agencia;
import util.Constantes;

public class TestCaso3 {

	private Agencia ag;
	private static boolean isAgInit = false;
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>(); // Primeros 3 empleados y ultimos 3 empleadores
	
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
			
			auxCliente = ag.registroEmpleado("emp3", "123456", "Empleado", "3", "+54223600003", 23);
			clientes.add(auxCliente);
			
			auxCliente = ag.registroEmpleador("empr1", "123456", "Empleador1", "+54223610000", Constantes.FISICA, Constantes.COMERCIO_LOCAL);
			ag.crearTicketEmpleador(Constantes.PRESENCIAL, 1500, Constantes.JORNADA_COMPLETA, Constantes.JUNIOR, Constantes.EXP_MEDIA, Constantes.SECUNDARIOS, auxCliente);
			clientes.add(auxCliente);
			
			auxCliente = ag.registroEmpleador("empr2", "123456", "Empleador2", "+54223620000", Constantes.JURIDICA, Constantes.COMERCIO_INTERNACIONAL);
			ag.crearTicketEmpleador(Constantes.INDISTINTO, 1500, Constantes.JORNADA_MEDIA, Constantes.MANAGMENT, Constantes.EXP_MUCHA, Constantes.TERCIARIOS, auxCliente);
			clientes.add(auxCliente);
			
			auxCliente = ag.registroEmpleador("empr3", "123456", "Empleador3", "+54223630000", Constantes.JURIDICA, Constantes.COMERCIO_INTERNACIONAL);
			clientes.add(auxCliente);
			
			ag.gatillarRonda();
		}
	}

	@Test
	public void casoDePruebaEmpleado1() {
		try {
			Cliente cl = (Cliente) this.ag.login("emp1", "123456");
			ArrayList<ClientePuntaje> postulantes = cl.getListaDePostulantes();
			cl.setCandidato(postulantes.get(0).getCliente());
			
			assertEquals(2, postulantes.size());
			assertEquals(clientes.get(4), postulantes.get(0).getCliente());
			assertEquals(clientes.get(3), postulantes.get(1).getCliente());
			assertEquals(postulantes.get(0).getCliente(), cl.getCandidato());
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
			ArrayList<ClientePuntaje> postulantes = cl.getListaDePostulantes();
			cl.setCandidato(postulantes.get(0).getCliente());
			
			assertEquals(2, postulantes.size());
			assertEquals(clientes.get(3), postulantes.get(0).getCliente());
			assertEquals(clientes.get(4), postulantes.get(1).getCliente());
			assertEquals(postulantes.get(0).getCliente(), cl.getCandidato());
		} catch (ContraException | NombreUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void casoDePruebaEmpleado3() {
		try {
			Cliente cl = (Cliente) this.ag.login("emp3", "123456");
			ArrayList<ClientePuntaje> postulantes = cl.getListaDePostulantes();
			assertEquals(null, postulantes);
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
			ArrayList<ClientePuntaje> postulantes = cl.getListaDePostulantes();
			cl.setCandidato(postulantes.get(0).getCliente());
			
			assertEquals(2, postulantes.size());
			assertEquals(clientes.get(1), postulantes.get(0).getCliente());
			assertEquals(clientes.get(0), postulantes.get(1).getCliente());
			assertEquals(postulantes.get(0).getCliente(), cl.getCandidato());
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
			ArrayList<ClientePuntaje> postulantes = cl.getListaDePostulantes();
			cl.setCandidato(postulantes.get(0).getCliente());
			
			assertEquals(2, postulantes.size());
			assertEquals(clientes.get(0), postulantes.get(0).getCliente());
			assertEquals(clientes.get(1), postulantes.get(1).getCliente());
			assertEquals(postulantes.get(0).getCliente(), cl.getCandidato());
		} catch (ContraException | NombreUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void casoDePruebaEmpleador3() {
		try {
			Cliente cl = (Cliente) this.ag.login("empr3", "123456");
			ArrayList<ClientePuntaje> postulantes = cl.getListaDePostulantes();
			assertEquals(null, postulantes);
		} catch (ContraException | NombreUsuarioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Se lanzo un error inesperado");
		}
	}
}
