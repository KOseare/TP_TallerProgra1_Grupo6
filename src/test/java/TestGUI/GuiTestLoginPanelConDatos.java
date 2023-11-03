package TestGUI;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import bin.util.Mensajes;
import modeloNegocio.Agencia;
import util.Constantes;
import vista.Ventana;

public class GuiTestLoginPanelConDatos extends GuiTestLoginPanel {

    @Before
    public void setUp() throws Exception
    {
    	 controlador = new Controlador();
         controlador.setMyOptionPane(op);
       Agencia.getInstance().getEmpleadores().clear();
       Agencia.getInstance().getEmpleados().clear();
       
       Agencia.getInstance().registroEmpleado("Roberts", "123456", "Roberto", "Manhattan", "2233222332", 18);
       Agencia.getInstance().registroEmpleador("Juan Ignacio", "password", "DrOcropus :P", "4637283942", Constantes.FISICA, Constantes.SALUD); 
    }
    
    @Test
    public void testLoginUsuarioDesconocido()
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
        
        TestUtils.clickComponent(aceptarLog, robot);
        //verifico los resultados
        Assert.assertEquals(Mensajes.USUARIO_DESCONOCIDO.getValor(), op.getMensaje());
    	
    }
    @Test
    public void testLoginPassErroneo()
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
        TestUtils.tipeaTexto("Roberts", robot);
        TestUtils.clickComponent(contra, robot);
        TestUtils.tipeaTexto("1234", robot);
        
        TestUtils.clickComponent(aceptarLog, robot);
        //verifico los resultados
        Assert.assertEquals(Mensajes.PASS_ERRONEO.getValor(), op.getMensaje());
    	
    }
    
}
