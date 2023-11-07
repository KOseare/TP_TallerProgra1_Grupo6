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

/*void
abrirInput(String nombre)
 
void
abrirOutput(String nombre)
 
void
cerrarInput()
 
void
cerrarOutput()
 
void
escribir(Object objeto)
 
Object
leer()*/
public class PersistenciaTest {
	AgenciaDTO ag;
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
		File arch = new File ("archivo.xml");
		String a=null;
		//persistencia.abrirInput("archivo.xml");
		//persistencia.abrirInput(a);
		//persistencia.abrirInput("archivoxml");
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
			fail("debería lanzar una excepcion");
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		try {
			persistencia.abrirOutput("archivoxml");
			fail("debería lanzar una excepcion");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	

}
