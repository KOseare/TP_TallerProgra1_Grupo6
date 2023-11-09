package persTest;

import static org.junit.Assert.fail;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import modeloDatos.Cliente;
import modeloDatos.Contratacion;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import persistencia.AgenciaDTO;
import persistencia.PersistenciaXML;

public class PersistenciaTest {
	
	PersistenciaXML persistencia;
	@Before
	public void setUp() {
		persistencia = new PersistenciaXML();

	}

	@After
	public void tearDown() {

	}

	
	@Test
    public void testAbrirInput() throws IOException  {
		try {
			persistencia.abrirInput("archivo.xml");
		}
		catch (Exception e1){
			fail("esc 1: no debería lanzar una excepcion");
		}
		try {
			persistencia.abrirInput(null);
			fail("esc 2: deberia lanzar una null pointer excepction");
		}
		catch (Exception e1){
		}
    }
	
	@Test
    public void testAbrirOutput() {
		try {
			persistencia.abrirOutput("archivo.xml");
		} catch (IOException e1) {
			fail("no debería lanzar una excepcion escenario 1");
		}
		try {
			persistencia.abrirOutput(null);
			fail("debería lanzar la excepcion nullpointer escenario2");
		} catch (Exception e) {
		}
	}
	
	@Test
	public void TestCerrarInput() {
		try {
			persistencia.abrirInput("archivo.xml");			
			persistencia.cerrarInput();
		} catch (IOException e) {
			fail("no debería lanzar una excepcion");	
		}
	}
	
	@Test
	public void TestCerrarOutput() {
		try {
			persistencia.abrirOutput("archivo.xml");			
			persistencia.cerrarOutput();
		} catch (IOException e) {
			fail("no debería lanzar una excepcion al primer intento de cerrar");
		}
	}
	
	@Test
	public void testLeer() throws ClassNotFoundException {
		try {
			AgenciaDTO ag;
			ag = (AgenciaDTO) persistencia.leer();
		} catch (IOException e) {
			fail("no debería lanzar una excepcion");
		}
	}

	/*Escenario 1: Recibe un parámetro vacío de tipo AgenciaDTO				
	Escenario 2: Recibe un parámetro no vacío								
	*/
	
	@Test
	public void testEscribir1 (){
		AgenciaDTO ag =  new AgenciaDTO();
		try {
			persistencia.abrirOutput("archivo1.xml");
			persistencia.escribir(ag);
		} catch (IOException e) {
			fail("no debería lanzar una excepcion");
		}
	}
	
	@Test
	public void testEscribir2 (){
		AgenciaDTO ag =  new AgenciaDTO();
		EmpleadoPretenso testPretenso = new EmpleadoPretenso ("torime","abcdario","Maria","0303456","Antonieta",45);
		HashMap<Cliente, Double> testComisiones = new HashMap<Cliente,Double>();
		testComisiones.put(testPretenso, 0.9);
		HashMap<String,EmpleadoPretenso> testEmpleadosPretensos = new HashMap<String,EmpleadoPretenso>();
		HashMap<String,Empleador> testEmpleadores = new HashMap<String,Empleador>();
		ArrayList<Contratacion> testContrataciones = new ArrayList<Contratacion>();
		ag.setComisionesUsuarios(testComisiones);
		ag.setContrataciones(testContrataciones);
		ag.setEmpleadores(testEmpleadores);
		ag.setEmpleados(testEmpleadosPretensos);
		ag.setEstadoContratacion(false);
		ag.setLimiteInferior(1000);
		ag.setLimiteSuperior(2000);
		try {
			persistencia.abrirOutput("archivo2.xml");
			persistencia.escribir(ag);
			persistencia.cerrarOutput();
		} catch (IOException e) {
			fail("no debería lanzar una excepcion");
		}
	}
}
