package TestGUI;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTextField;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bin.util.Mensajes;
import controlador.Controlador;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;
import vista.Ventana;

public class GuiTestAdminPanel {

	protected Robot robot;
	protected Controlador controlador;

	protected FalsoOptionPane op = new FalsoOptionPane();
	
	protected JButton loginButton,gatillarButton,aplicarPromoButton,modificarValoresButton,cerrarSesionButton;
	protected JTextField textoInferior, textoSuperior,nombreUsuario,contra;
	protected JCheckBox listaPostulantes;
	protected JList<EmpleadoPretenso> listaEmpleados;
	protected JList<Empleador> listaEmpleadores;
	
	public GuiTestAdminPanel() {
		try {
			robot = new Robot();
		} catch (AWTException e) {

		}
	}
	
	@Before
	public void setUp() throws Exception {
		Agencia.getInstance().getEmpleadores().clear();
		Agencia.getInstance().getEmpleados().clear();

		controlador = new Controlador();
		controlador.setMyOptionPane(op);
		

		loginButton = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.LOGIN);
		
		nombreUsuario = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NOMBRE_USUARIO);
		contra = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.PASSWORD);
		
		
		
		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("admin", robot);
		TestUtils.clickComponent(contra, robot);
		TestUtils.tipeaTexto("admin", robot);
		TestUtils.clickComponent(loginButton, robot);
		// se debe de abrir un Admin Panel

		// datos a usar
		gatillarButton = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.GATILLAR);
		aplicarPromoButton = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.APLICAR_PROMO);
		cerrarSesionButton = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CERRARSESION);
		modificarValoresButton = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.MODIFICAR_VALORES);
		
		nombreUsuario = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		textoInferior = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTO_INFERIOR);
		textoSuperior = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTO_SUPERIOR);
		listaPostulantes = (JCheckBox) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CHECK_BOX_LISTA_POSTULANTES);
		
		listaEmpleados = (JList<EmpleadoPretenso>) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.LISTA_EMPLEADOS);
		listaEmpleadores = (JList<Empleador>) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.LISTA_EMPLEADORES);
		
	}
	
    @Test
    public void testModificarValoresSoloInferior()
    {
    	robot.delay(TestUtils.getDelay());
    	TestUtils.clickComponent(textoInferior, robot);
    	TestUtils.tipeaTexto("12", robot);
    	
    	Assert.assertFalse("el boton cambiar deberia estar deshabilitado",modificarValoresButton.isEnabled());
    }
    @Test
    public void testModificarValoresSoloSuperior()
    {
    	robot.delay(TestUtils.getDelay());
    	TestUtils.clickComponent(textoSuperior, robot);
    	TestUtils.tipeaTexto("120000", robot);
    	Assert.assertFalse("el boton cambiar deberia estar deshabilitado",modificarValoresButton.isEnabled());
    }
    
    @Test
    public void testModificarValoresInvalido()
    {
    	robot.delay(TestUtils.getDelay());
    	TestUtils.clickComponent(textoInferior, robot);
    	TestUtils.tipeaTexto("1200000", robot);
    	
    	TestUtils.clickComponent(textoSuperior, robot);
    	TestUtils.tipeaTexto("60000", robot);
    	Assert.assertFalse("el boton cambiar deberia estar deshabilitado",modificarValoresButton.isEnabled());
    	
    	TestUtils.clickComponent(textoInferior, robot);
    	TestUtils.borraJTextField(textoInferior, robot);
    	TestUtils.tipeaTexto("-1200000", robot);
    	Assert.assertFalse("el boton cambiar deberia estar deshabilitado",modificarValoresButton.isEnabled());
    	
    	TestUtils.clickComponent(textoInferior, robot);
    	TestUtils.borraJTextField(textoInferior, robot);
    	TestUtils.tipeaTexto("a", robot);
    	
    	Assert.assertFalse("el boton cambiar deberia estar deshabilitado",modificarValoresButton.isEnabled());
    	TestUtils.clickComponent(textoInferior, robot);
    	TestUtils.borraJTextField(textoInferior, robot);
    	TestUtils.tipeaTexto("1", robot);
    	TestUtils.clickComponent(textoSuperior, robot);
    	TestUtils.borraJTextField(textoSuperior, robot);
    	TestUtils.tipeaTexto("das", robot);
    	Assert.assertFalse("el boton cambiar deberia estar deshabilitado",modificarValoresButton.isEnabled());
    }
    @Test
    public void testModificarValoresValido()
    {
    	robot.delay(TestUtils.getDelay());
    	TestUtils.clickComponent(textoInferior, robot);
    	TestUtils.tipeaTexto("30000", robot);
    	
    	TestUtils.clickComponent(textoSuperior, robot);
    	TestUtils.tipeaTexto("120000", robot);
    	Assert.assertTrue("el boton cambiar deberia estar habilitado",modificarValoresButton.isEnabled());
    }
    @Test
    public void testCerrarSesion()
    {
    	robot.delay(TestUtils.getDelay());
    	TestUtils.clickComponent(cerrarSesionButton, robot);

    	
    	Assert.assertTrue("Se deberia cambiar al panel Login", cerrarSesionButton.isEnabled());//no asegura que este en el panel login
    }
    @Test
    public void testGatillar()
    {
    	robot.delay(TestUtils.getDelay());
    	TestUtils.clickComponent(gatillarButton, robot);
    	//no lo muestra en una ventana emergente
    	Assert.assertTrue("Se deberia mostrar el mensaje AGENCIA_EN_CONTRATACION", Agencia.getInstance().getEstado() == Mensajes.AGENCIA_EN_CONTRATACION.getValor());
    	TestUtils.clickComponent(gatillarButton, robot);
    	Assert.assertTrue("Se deberia mostrar el mensaje AGENCIA_EN_BUSQUEDA", Agencia.getInstance().getEstado() == Mensajes.AGENCIA_EN_BUSQUEDA.getValor());
    	
    }
    @Test
    public void testAplicarPromo()
    {
    	robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(aplicarPromoButton, robot);
        //hay una excepcion O.O	
        Assert.fail("no se deberia lanzar una excepcion");
    }
	@Test
	public void testVistaIsPorTicket() {
    	robot.delay(TestUtils.getDelay());
        TestUtils.clickComponent(listaPostulantes, robot);
        
       
        Assert.assertTrue("Deberian coincidir el metodo isPorTicket con el checklist", controlador.getVista().isPorTicket() == listaPostulantes.isSelected());
	}
    

    
    
	
}
