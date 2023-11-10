package testIntegracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.ContraException;
import excepciones.ImposibleCrearEmpleadorException;
import excepciones.NewRegisterException;
import excepciones.NombreUsuarioException;
import modeloNegocio.Agencia;
import util.Constantes;

public class TestCaso1_Empleador {
	
	private Agencia ag;
	
	@Before
	public void setUp() {
		this.ag = Agencia.getInstance();
	}
	
	@After
	public void tearDown() {
		MockUtils.resetSingleton(Agencia.class);
	}

	@Test
	public void casoDePruebaA () {
		try {
			ag.registroEmpleador("nicod", "123456", "Nicolas", "+542236012345", null, Constantes.COMERCIO_INTERNACIONAL);
			fail("La creación de usuario deberia haber fallado");
		} catch(ImposibleCrearEmpleadorException e) {
			// Error esperado
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void casoDePruebaB () {
		try {
			ag.registroEmpleador("nicod", "123456", "Nicolas", "+542236012345", Constantes.FISICA, Constantes.COMERCIO_INTERNACIONAL); // Usuario previamente creado
			
			ag.registroEmpleador("nicod", "654321", "Nicolasio", "+542236012345", Constantes.FISICA, Constantes.COMERCIO_INTERNACIONAL); // Otro usuario intenta registrarse con el mismo nombre
			
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
			ag.registroEmpleador("nicod", "123456", "Nicolas", "+542236012345", Constantes.FISICA, Constantes.COMERCIO_INTERNACIONAL);
			
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
			ag.registroEmpleador("nicod", "123456", "Nicolas", "+542236012345", Constantes.FISICA, Constantes.COMERCIO_INTERNACIONAL);
			
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
			ag.registroEmpleador("nicod", "123456", "Nicolas", "+542236012345", Constantes.FISICA, Constantes.COMERCIO_INTERNACIONAL);
			
			ag.login("nicod", "123456");

			assertEquals(1, ag.getTipoUsuario());
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}

}
