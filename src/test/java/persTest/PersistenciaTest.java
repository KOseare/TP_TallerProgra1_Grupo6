package persTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
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
	@BeforeClass
	public void setUp() {
		//borra el archivo
		ag = new AgenciaDTO();
		persistencia = new PersistenciaXML();
		File arch = new File ("archivo.xml");
		if (arch.exists())
			arch.delete();
		}

	@After
	public void tearDown() {
	}

	@Test
	public void testCrearArchivo() {
		 //verifica que el mÃ©todo persistir crea un archivo
		try {
			File arch = new File ("archivo.xml");
			Assert.assertTrue("debería existir el archivo archivo.xml", arch.exists());
		}
		catch (FileNotFoundException e) {
			Assert.fail("No debería lanzar excepcion: "+e.getMessage());
		}
	}
	@Test
    public void testAbrirInput() throws IOException {
        persistencia.abrirInput("archivo.xml");
        
    }

}
