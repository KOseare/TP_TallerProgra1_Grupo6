package negocioAgenciaTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Utils.MockUtils;
import excepciones.ImposibleCrearEmpleadoException;
import excepciones.NewRegisterException;
import modeloDatos.EmpleadoPretenso;
import modeloNegocio.Agencia;

public class RegistroEmpleadoTest {

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
			EmpleadoPretenso empDev = (EmpleadoPretenso) ag.registroEmpleado("nicod", "123456", "Nicolas", "+5492236012345", "Diaz", 28);
			EmpleadoPretenso emp = ag.getEmpleados().get("nicod");
			
			assertEquals("nicod", emp.getUsserName());
			assertEquals("123456", emp.getPassword());
			assertEquals("Nicolas", emp.getRealName());
			assertEquals("+5492236012345", emp.getTelefono());
			assertEquals("Diaz", emp.getApellido());
			assertEquals(28, emp.getEdad());
			assertEquals(emp, empDev);
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario1_2() {
		try {
			ag.registroEmpleado(null, "123456", "Nicolas", "+5492236012345", "Diaz", 28);
		} catch (ImposibleCrearEmpleadoException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario1_3() {
		try {
			ag.registroEmpleado("nicod", null, "Nicolas", "+5492236012345", "Diaz", 28);
		} catch (ImposibleCrearEmpleadoException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario1_4() {
		try {
			ag.registroEmpleado("nicod", "123456", null, "+5492236012345", "Diaz", 28);
		} catch (ImposibleCrearEmpleadoException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario1_5() {
		try {
			ag.registroEmpleado("nicod", "123456", "Nicolas", null, "Diaz", 28);
		} catch (ImposibleCrearEmpleadoException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario1_6() {
		try {
			ag.registroEmpleado("nicod", "123456", "Nicolas", "+5492236012345", null, 28);
		} catch (ImposibleCrearEmpleadoException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario2_1() {
		try {
			ag.registroEmpleado("nicod", "123567", "Nicolasio", "+5492236543210", "Dante", 45);
			ag.registroEmpleado("nicod", "123456", "Nicolas", "+5492236012345", "Diaz", 28);
		} catch (NewRegisterException e) {
			// Excepcion esperada
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}
	
	@Test
	public void registroEmpleado_Escenario2_2() {
		try {
			ag.registroEmpleado("nicod", "123567", "Nicolasio", "+5492236543210", "Dante", 45);
			
			EmpleadoPretenso empDev = (EmpleadoPretenso) ag.registroEmpleado("nicod2", "123456", "Nicolas", "+5492236012345", "Diaz", 28);
			EmpleadoPretenso emp = ag.getEmpleados().get("nicod2");
			
			assertEquals("nicod2", emp.getUsserName());
			assertEquals("123456", emp.getPassword());
			assertEquals("Nicolas", emp.getRealName());
			assertEquals("+5492236012345", emp.getTelefono());
			assertEquals("Diaz", emp.getApellido());
			assertEquals(28, emp.getEdad());
			assertEquals(emp, empDev);
		} catch (Exception e) {
			fail("Se lanzo una excepcion invalida: " + e.getMessage());
		}
	}

}
