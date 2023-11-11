package TestGUI;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import modeloNegocio.Agencia;
import bin.util.Mensajes;
import util.Constantes;
import vista.Ventana;

public class GuiTestLoginPanel {

	protected Robot robot;
	protected Controlador controlador;

	protected FalsoOptionPane op = new FalsoOptionPane();

	public GuiTestLoginPanel() {
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
	}

	@After
	public void tearDown() throws Exception {
		Ventana v = (Ventana) controlador.getVista();
		v.setVisible(false);
	}

	@Test
	public void testBotonRegistro() {
		robot.delay(TestUtils.getDelay());
		// obtengo las referencias a los componentes necesarios
		JButton registroButton = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REGISTRAR);

		Assert.assertTrue("El boton de registro deberia estar habilitado", registroButton.isEnabled());

		// clickea boton
		TestUtils.clickComponent(registroButton, robot);

		robot.delay(TestUtils.getDelay());

		// no ecncontre otra manera de saber si el panelLogin cambio a PanelRegistro
		JButton cancelarButton = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_CANCELAR);

		Assert.assertTrue("deberia abrirse un PaneldeRegistro", cancelarButton.isEnabled());
	}

	@Test
	public void testVacio() {
		JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.LOGIN);

		Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());

	}

	public void testSoloContrasena() {
		robot.delay(TestUtils.getDelay());
		// obtengo las referencias a los componentes necesarios
		JTextField contra = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.PASSWORD);
		JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.LOGIN);

		// lleno los JTextField
		TestUtils.clickComponent(contra, robot);
		TestUtils.tipeaTexto("1234", robot);
		// verifico los resultados
		Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
	}

	@Test
	public void testSoloNombre() {
		robot.delay(TestUtils.getDelay());
		// obtengo las referencias a los componentes necesarios
		JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NOMBRE_USUARIO);
		JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.LOGIN);

		// lleno los JTextField
		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Bahiano", robot);
		// verifico los resultados
		Assert.assertFalse("El boton de login deberia estar deshablitado", aceptarLog.isEnabled());
	}

	@Test
	public void testAmbosLlenos() {
		robot.delay(TestUtils.getDelay());
		// obtengo las referencias a los componentes necesarios
		JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NOMBRE_USUARIO);
		JTextField contra = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.PASSWORD);

		JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.LOGIN);

		// lleno los JTextField
		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Bahiano", robot);
		TestUtils.clickComponent(contra, robot);
		TestUtils.tipeaTexto("1234", robot);

		// verifico los resultados
		Assert.assertFalse("El boton de login deberia estar habilitado", !aceptarLog.isEnabled());

	}

	@Test
	public void testLoginUsuarioDesconocido() {
		robot.delay(TestUtils.getDelay());
		// obtengo las referencias a los componentes necesarios
		JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NOMBRE_USUARIO);
		JTextField contra = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.PASSWORD);

		JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.LOGIN);

		// lleno los JTextField
		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Bahiano", robot);
		TestUtils.clickComponent(contra, robot);
		TestUtils.tipeaTexto("1234", robot);

		TestUtils.clickComponent(aceptarLog, robot);
		// verifico los resultados
		Assert.assertEquals(Mensajes.USUARIO_DESCONOCIDO.getValor(), op.getMensaje());

	}

	@Test
	public void testAdminLog() {
		robot.delay(TestUtils.getDelay());

		JTextField nombreUsuario = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NOMBRE_USUARIO);
		JTextField contra = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.PASSWORD);

		JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.LOGIN);

		// lleno los JTextField
		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("admin", robot);
		TestUtils.clickComponent(contra, robot);
		TestUtils.tipeaTexto("admin", robot);

		TestUtils.clickComponent(aceptarLog, robot);
		robot.delay(500);
		// verifico los resultados
		Assert.assertTrue("deberia haber logeado",((JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CERRARSESION)).isEnabled());
	}

}
