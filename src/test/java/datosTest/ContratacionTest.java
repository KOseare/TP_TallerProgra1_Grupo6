package datosTest;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Contratacion;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import util.Constantes;

public class ContratacionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testContratacion() {
		try {
			Empleador empleador = new Empleador("neron","fire","Grupo LAH","0223 43332221",Constantes.COMERCIO_LOCAL,Constantes.FISICA);
			EmpleadoPretenso empleado = new EmpleadoPretenso("watafilin","isbilivin","Juana","0223 1523412312","Morales",25);
			Calendar fecha = new GregorianCalendar();
			Contratacion c = new Contratacion(empleador,empleado);
			assertEquals("Error en el parámetro Empleador", empleador, c.getEmpleador());
			assertEquals("Error en el parámetro EmpleadoPretenso", empleado, c.getEmpleado());
			assertTrue("Error en el año del atributo fecha",fecha.get(Calendar.YEAR)==c.getFecha().get(Calendar.YEAR));
			assertTrue("Error en el mes del atributo fecha",fecha.get(Calendar.MONTH)==c.getFecha().get(Calendar.MONTH));
			assertTrue("Error en el día del atributo fecha",fecha.get(Calendar.DATE)==c.getFecha().get(Calendar.DATE));
			
		}
		catch (Exception e) {
			fail("No debería lanzar excepción");
		}
		
	}

}
