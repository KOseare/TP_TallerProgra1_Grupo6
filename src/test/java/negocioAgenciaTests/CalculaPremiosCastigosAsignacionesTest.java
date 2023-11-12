package negocioAgenciaTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utils.MockUtils;
import modeloDatos.Cliente;
import modeloDatos.ClientePuntaje;
import modeloNegocio.Agencia;
import util.Constantes;

public class CalculaPremiosCastigosAsignacionesTest {

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
	public void testCalculaPremiosCastigosAsignaciones1() {
		this.ag.calculaPremiosCastigosAsignaciones();
		assertTrue(this.ag.getEmpleados() != null);
		assertTrue(this.ag.getEmpleadores() != null);
	}
	
	@Test
	public void testCalculaPremiosCastigosAsignaciones2() {
		try {
			Cliente emp1 = ag.registroEmpleado("nicod1", "123456", "Nicolas", "Diaz", "+542236012345", 21);
			Cliente emp2 = ag.registroEmpleado("nicod2", "123456", "Nicolas", "Diaz", "+542236012345", 21);
			Cliente emp3 = ag.registroEmpleado("nicod3", "123456", "Nicolas", "Diaz", "+542236012345", 21);
			Cliente empr = ag.registroEmpleador("nicod4", "123456", "Nicolas", "+542236012345", Constantes.FISICA, Constantes.COMERCIO_INTERNACIONAL);
			
			ArrayList<ClientePuntaje> listaEmpleados = new ArrayList<ClientePuntaje>();
			listaEmpleados.add(new ClientePuntaje(30, emp1));
			listaEmpleados.add(new ClientePuntaje(20, emp2));
			listaEmpleados.add(new ClientePuntaje(10, emp3));
			
			ArrayList<ClientePuntaje> listaEmpleadores = new ArrayList<ClientePuntaje>();
			listaEmpleadores.add(new ClientePuntaje(30, empr));
			
			emp1.setListaDePostulantes(listaEmpleadores);
			emp2.setListaDePostulantes(listaEmpleadores);
			emp3.setListaDePostulantes(listaEmpleadores);
			empr.setListaDePostulantes(listaEmpleados);
			
			this.ag.calculaPremiosCastigosAsignaciones();
			assertEquals(5, emp1.getPuntaje());
			assertEquals(0, emp2.getPuntaje());
			assertEquals(-5, emp3.getPuntaje());
			assertEquals(30, empr.getPuntaje());
		} catch (Exception e) {
			System.out.println(e);
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void testCalculaPremiosCastigosAsignaciones3() {
		try {
			Cliente emp = ag.registroEmpleado("nicod1", "123456", "Nicolas", "Diaz", "+542236012345", 21);
			Cliente empr1 = ag.registroEmpleador("nicod2", "123456", "Nicolas", "+542236012345", Constantes.FISICA, Constantes.COMERCIO_INTERNACIONAL);
			Cliente empr2 = ag.registroEmpleador("nicod3", "123456", "Nicolas", "+542236012345", Constantes.FISICA, Constantes.COMERCIO_INTERNACIONAL);
			
			ArrayList<ClientePuntaje> listaEmpleados = new ArrayList<ClientePuntaje>();
			listaEmpleados.add(new ClientePuntaje(30, emp));
			
			ArrayList<ClientePuntaje> listaEmpleadores = new ArrayList<ClientePuntaje>();
			listaEmpleadores.add(new ClientePuntaje(30, empr1));
			listaEmpleadores.add(new ClientePuntaje(10, empr2));
			
			emp.setListaDePostulantes(listaEmpleadores);
			empr1.setListaDePostulantes(listaEmpleados);
			empr2.setListaDePostulantes(listaEmpleados);
			
			this.ag.calculaPremiosCastigosAsignaciones();
			assertEquals(0, emp.getPuntaje());
			assertEquals(10, empr1.getPuntaje());
			assertEquals(0, empr2.getPuntaje());
		} catch (Exception e) {
			System.out.println(e);
			fail("Se lanzo un error inesperado");
		}
	}

}
