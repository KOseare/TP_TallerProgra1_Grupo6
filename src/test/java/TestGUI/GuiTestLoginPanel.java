package TestGUI;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import bin.controlador.Controlador;

import util.Constantes;
import vista.Ventana;

public class GuiTestLoginPanel {

	Robot robot;
	Controlador controlador;
	/*@Test
	public void test() {
		fail("me cago matando");
	}*/
	
	public GuiTestLoginPanel() {
		try {
			robot = new Robot();
		}catch(AWTException e) {
			
		}	
	}
	
    @Before
    public void setUp() throws Exception
    {
        controlador = new Controlador();
    }
    
    /*
    @After
    public void tearDown() throws Exception
    {
        controlador.getVentana().setVisible(false);
    }*/
    
    @Test
    public void testVacio() {
    	JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana)controlador.getVista(), Constantes.LOGIN);
        
    	Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    	
    }
    
    public void testSoloContrasena()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField contra =
            (JTextField) TestUtils.getComponentForName((Ventana)controlador.getVista(), Constantes.PASSWORD);
    	JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana)controlador.getVista(), Constantes.LOGIN);
    	 
        //lleno los JTextField
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("1234", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }
    @Test
    public void testSoloNombre()
    {
        robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombreUsuario =
            (JTextField) TestUtils.getComponentForName((Ventana)controlador.getVista(), Constantes.NOMBRE_USUARIO);
    	JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana)controlador.getVista(), Constantes.LOGIN);
    	 
        //lleno los JTextField
        TestUtils.clickComponent(nombreUsuario, robot);
        TestUtils.tipeaTexto("Bahiano", robot);
        //verifico los resultados
        Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
    }
    @Test
    public void testAmbosLlenos()
    {
    	robot.delay(TestUtils.getDelay());
        //obtengo las referencias a los componentes necesarios
        JTextField nombreUsuario =
            (JTextField) TestUtils.getComponentForName((Ventana)controlador.getVista(), Constantes.NOMBRE_USUARIO);
        JTextField contra =
                (JTextField) TestUtils.getComponentForName((Ventana)controlador.getVista(), Constantes.PASSWORD);

        JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana)controlador.getVista(), Constantes.LOGIN);
    	 
    	
        //lleno los JTextField
        TestUtils.clickComponent(nombreUsuario, robot);
        TestUtils.tipeaTexto("Bahiano", robot);
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("1234", robot);
        
        //verifico los resultados
        Assert.assertFalse("El boton de login deberia estar habilitado", !aceptarLog.isEnabled());
    	
    }
    
    

}
