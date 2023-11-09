package testIntegracion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import excepciones.ContraException;
import excepciones.NombreUsuarioException;
import modeloNegocio.Agencia;

public class TestCaso1_Admin {
	
	private Agencia ag;
	
	@Before
	public void setUp() {
		this.ag = Agencia.getInstance();
	}
	
	@After
	public void tearDown() {
		this.ag.cerrarSesion();
	}
	
	@Test
	public void casoDePruebaA () {
		try {
			ag.login("adm", "admin");
			
			fail("La creación de usuario deberia haber fallado");
		} catch(NombreUsuarioException e) {
			// Error esperado
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void casoDePruebaB () {
		try {
			ag.login("admin", "adm");
			
			fail("La creación de usuario deberia haber fallado");
		} catch(ContraException e) {
			// Error esperado
		} catch (Exception e) {
			System.out.println(e);
			fail("Se lanzo un error inesperado");
		}
	}
	
	@Test
	public void casoDePruebaC () {
		try {
			ag.login("admin", "admin");

			assertEquals(2, ag.getTipoUsuario());
		} catch (Exception e) {
			fail("Se lanzo un error inesperado");
		}
	}

}

