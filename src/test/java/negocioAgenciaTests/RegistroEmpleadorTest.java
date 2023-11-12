package negocioAgenciaTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utils.MockUtils;
import excepciones.ImposibleCrearEmpleadorException;
import excepciones.NewRegisterException;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;

public class RegistroEmpleadorTest {

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
	public void registroEmpleado_Escenario1_1() {
		try {
			Empleador empDev = (Empleador) ag.registroEmpleador("nicod", "123456", "Nicolas Diaz", "+542236012345", Constantes.FISICA, Constantes.SALUD);
			Empleador emp = ag.getEmpleadores().get("nicod");
			
			assertEquals("nicod", emp.getUsserName());
			assertEquals("123456", emp.getPassword());
			assertEquals("Nicolas Diaz", emp.getRealName());
			assertEquals("+5492236012345", emp.getTelefono());
			assertEquals(Constantes.FISICA, emp.getTipoPersona());
			assertEquals(Constantes.SALUD, emp.getRubro());
			assertEquals(emp, empDev);
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario1_2() {
		try {
			ag.registroEmpleador(null, "123456", "Nicolas Diaz", "+542236012345", Constantes.FISICA, Constantes.SALUD);
		} catch (ImposibleCrearEmpleadorException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario1_3() {
		try {
			ag.registroEmpleador("nicod", null, "Nicolas Diaz", "+542236012345", Constantes.FISICA, Constantes.SALUD);
		} catch (ImposibleCrearEmpleadorException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario1_4() {
		try {
			ag.registroEmpleador("nicod", "123456", null, "+542236012345", Constantes.FISICA, Constantes.SALUD);
		} catch (ImposibleCrearEmpleadorException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario1_5() {
		try {
			ag.registroEmpleador("nicod", "123456", "Nicolas Diaz", null, Constantes.FISICA, Constantes.SALUD);
		} catch (ImposibleCrearEmpleadorException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario1_6() {
		try {
			ag.registroEmpleador("nicod", "123456", "Nicolas Diaz", "+542236012345", "Persona", Constantes.SALUD);
		} catch (ImposibleCrearEmpleadorException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario1_7() {
		try {
			ag.registroEmpleador("nicod", "123456", "Nicolas Diaz", "+542236012345", null, Constantes.SALUD);
		} catch (ImposibleCrearEmpleadorException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario1_8() {
		try {
			ag.registroEmpleador("nicod", "123456", "Nicolas Diaz", "+542236012345", Constantes.FISICA, "Tecnologia");
		} catch (ImposibleCrearEmpleadorException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario1_9() {
		try {
			ag.registroEmpleador("nicod", "123456", "Nicolas Diaz", "+542236012345", Constantes.FISICA, null);
		} catch (ImposibleCrearEmpleadorException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario2_1() {
		try {
			ag.registroEmpleador("nicod", "123456", "Nicolasio Dante", "+542236012345", Constantes.FISICA, Constantes.SALUD);
			ag.registroEmpleador("nicod", "123456", "Nicolas Diaz", "+542236012345", Constantes.FISICA, Constantes.SALUD);
		} catch (NewRegisterException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario2_2() {
		try {
			ag.registroEmpleador("nicod", "123456", "Nicolasio Dante", "+542236012345", Constantes.FISICA, Constantes.SALUD);
			
			Empleador empDev = (Empleador) ag.registroEmpleador("nicod2", "123456", "Nicolas Diaz", "+542236012345", Constantes.FISICA, Constantes.SALUD);
			Empleador emp = ag.getEmpleadores().get("nicod2");
			
			assertEquals("nicod2", emp.getUsserName());
			assertEquals("123456", emp.getPassword());
			assertEquals("Nicolas Diaz", emp.getRealName());
			assertEquals("+5492236012345", emp.getTelefono());
			assertEquals(Constantes.FISICA, emp.getTipoPersona());
			assertEquals(Constantes.SALUD, emp.getRubro());
			assertEquals(emp, empDev);
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}

}
