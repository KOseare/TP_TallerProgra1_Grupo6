package testIntegracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.ContraException;
import excepciones.ImposibleCrearEmpleadoException;
import excepciones.NewRegisterException;
import excepciones.NombreUsuarioException;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;

public class TestCaso1_Empleado {
	
	private Agencia ag;
	
	@Before
	public void setUp() {
		this.ag = Agencia.getInstance();
	}
	
	@After
	public void tearDown() {
		this.ag.setEmpleadores(new HashMap<String, Empleador>());
		this.ag.setEmpleados(new HashMap<String, EmpleadoPretenso>());
		this.ag.cerrarSesion();
	}

	@Test
	public void casoDePruebaA () {
		try {
			ag.registroEmpleado("nicod", "123456", null, "Diaz", "+542236012345", 21);
			fail("La creación de usuario deberia haber fallado");
		} catch(ImposibleCrearEmpleadoException e) {
			// Error esperado
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void casoDePruebaB () {
		try {
			ag.registroEmpleado("nicod", "123456", "Nicolas", "Diaz", "+542236012345", 21); // Usuario previamente creado
			
			ag.registroEmpleado("nicod", "654321", "Nicolasio", "Dominguez", "+542236543210", 45); // Otro usuario intenta registrarse con el mismo nombre
			
			fail("La creación de usuario deberia haber fallado");
		} catch(NewRegisterException e) {
			// Error esperado
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void casoDePruebaC () {
		try {
			ag.registroEmpleado("nicod", "123456", "Nicolas", "Diaz", "+542236012345", 21);
			
			ag.login("nico", "123456");
			
			fail("La creación de usuario deberia haber fallado");
		} catch(NombreUsuarioException e) {
			// Error esperado
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void casoDePruebaD () {
		try {
			ag.registroEmpleado("nicod", "123456", "Nicolas", "Diaz", "+542236012345", 21);
			
			ag.login("nicod", "1234567");
			
			fail("La creación de usuario deberia haber fallado");
		} catch(ContraException e) {
			// Error esperado
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void casoDePruebaE () {
		try {
			ag.registroEmpleado("nicod", "123456", "Nicolas", "Diaz", "+542236012345", 21);
			
			ag.login("nicod", "123456");

			assertEquals(0, ag.getTipoUsuario());
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}

}
