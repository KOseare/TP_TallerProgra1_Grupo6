package persTest;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		String a=null;
		File arch = new File ("archivo.xml");
		try {
			persistencia.abrirInput("archivo.xml");
			fail("no debería lanzar una excepcion");
			//persistencia.abrirInput(a);
			//persistencia.abrirInput("archivoxml");
		}
		catch (Exception e1){
			fail("debería lanzar una excepcion");
		}
    }
	
	@Test
    public void testAbrirOutput() {
		File arch = new File ("archivo.xml");
		String a=null;
		try {
			persistencia.abrirOutput("archivo.xml");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			fail("no debería lanzar una excepcion");
		}
		try {
			persistencia.abrirOutput(a);
			fail("debería lanzar la excepcion nullpointer");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		try {
			persistencia.abrirOutput("archivoxml");
			fail("debería lanzar una excepcion");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
    }
	
	@Test
	public void TestCerrarInput() {
		try {
			File arch = new File ("archivo.xml");
			persistencia.abrirInput("archivo.xml");			
			persistencia.cerrarInput();
			fail("no debería lanzar una excepcion");
		} catch (IOException e) {
			// TODO Auto-generated catch block			
		}
	}
	
	@Test
	public void TestCerrarOutput() {
		try {
			File arch = new File ("archivo.xml");
			persistencia.abrirOutput("archivo.xml");			
			persistencia.cerrarOutput();
			fail("no debería lanzar una excepcion");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	
	@Test
	public void testLeer() throws ClassNotFoundException {
		File arch = new File ("archivo.xml");
		AgenciaDTO ag;
		try {
			ag = (AgenciaDTO) persistencia.leer();
			fail("no debería lanzar una excepcion");
		} catch (IOException e) {

		}
	}

	/*Escenario 1: Recibe un parámetro vacío de tipo AgenciaDTO				
	Escenario 2: Recibe un parámetro tipo String (es un Object)				
	Escenario 3: Recibe un parámetro null				
	*/
	
	@Test
	public void testEscribir (){
		AgenciaDTO ag =  new AgenciaDTO();
		File arch = new File ("archivo.xml");
		try {
			persistencia.abrirOutput("archivo.xml");
			persistencia.escribir(ag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			fail("no debería lanzar una excepcion");
		}
	}
}
