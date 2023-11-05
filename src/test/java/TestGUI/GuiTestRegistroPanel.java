package TestGUI;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bin.util.Mensajes;
import controlador.Controlador;
import excepciones.ImposibleCrearEmpleadoException;
import excepciones.NewRegisterException;
import modeloNegocio.Agencia;
import util.Constantes;
import vista.PanelLogin;
import vista.Ventana;

public class GuiTestRegistroPanel {

	protected Robot robot;
	protected Controlador controlador;

	protected FalsoOptionPane op = new FalsoOptionPane();

	JButton registroButton, cancelarButton;
	JTextField nombreUsuario, contrasenia, confirmarContrasenia, nombreReal, telefono, apellido, edad;
	JRadioButton empleado, empleador, salud, comercioInternacional, comercioLocal, fisica, juridica;

	public GuiTestRegistroPanel() {
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
		

		registroButton = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REGISTRAR);
		TestUtils.clickComponent(registroButton, robot);

		// se debe de abrir un Registro Panel

		// datos a usar
		registroButton = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
		cancelarButton = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_CANCELAR);

		nombreUsuario = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		contrasenia = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);
		confirmarContrasenia = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);
		nombreReal = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);
		telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);
		apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);
		edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.REG_EDAD);

		empleado = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.EMPLEADO);
		empleador = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADOR);
		salud = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_RADIO_SALUD);
		comercioInternacional = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_RADIO_COMERCIO_INTERNACIONAL);
		comercioLocal = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_RADIO_COMERCIO_LOCAL);
		fisica = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_RADIO_FISICA);
		juridica = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_RADIO_JURIDICA);

	}

	@After
	public void tearDown() throws Exception {
		Ventana v = (Ventana) controlador.getVista();
		v.setVisible(false);
	}

	@Test
	public void testBotonCancelar() {// revisar
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(cancelarButton, robot);

		registroButton = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REGISTRAR);
		Assert.assertTrue("deberia abrirse un PaneldeRegistro", (registroButton instanceof JButton));
	}

	@Test
	public void testRegVacio() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(empleador, robot);
		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
		TestUtils.clickComponent(empleado, robot);
		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegSoloNombre() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(empleador, robot);

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Bahiano", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
		TestUtils.clickComponent(empleado, robot);
		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegSoloContrasenia() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(empleador, robot);

		TestUtils.clickComponent(contrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
		TestUtils.clickComponent(empleado, robot);
		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegSoloConfirmarContrasenia() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(empleador, robot);

		TestUtils.clickComponent(confirmarContrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
		TestUtils.clickComponent(empleado, robot);
		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegSoloNombreReal() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(empleador, robot);

		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Augusto", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
		TestUtils.clickComponent(empleado, robot);
		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegSoloTelefono() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(empleador, robot);

		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("2232354761", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
		TestUtils.clickComponent(empleado, robot);
		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegSoloApellido() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(empleado, robot);

		TestUtils.clickComponent(apellido, robot);
		TestUtils.tipeaTexto("Massa", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegSoloEdad() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(empleado, robot);

		TestUtils.clickComponent(edad, robot);
		TestUtils.tipeaTexto("18", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegSinNombre() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(empleador, robot);

		TestUtils.clickComponent(contrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(confirmarContrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Augusto", robot);

		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("2232354761", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());

		TestUtils.clickComponent(empleado, robot);

		TestUtils.clickComponent(apellido, robot);
		TestUtils.tipeaTexto("Massa", robot);

		TestUtils.clickComponent(edad, robot);
		TestUtils.tipeaTexto("18", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegSinContrasenia() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(empleador, robot);

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Bahiano", robot);

		TestUtils.clickComponent(confirmarContrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Augusto", robot);

		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("2232354761", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());

		TestUtils.clickComponent(empleado, robot);

		TestUtils.clickComponent(apellido, robot);
		TestUtils.tipeaTexto("Massa", robot);

		TestUtils.clickComponent(edad, robot);
		TestUtils.tipeaTexto("18", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegSinConfirmarContrasenia() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(empleador, robot);

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Bahiano", robot);

		TestUtils.clickComponent(contrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Augusto", robot);

		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("2232354761", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());

		TestUtils.clickComponent(empleado, robot);

		TestUtils.clickComponent(apellido, robot);
		TestUtils.tipeaTexto("Massa", robot);

		TestUtils.clickComponent(edad, robot);
		TestUtils.tipeaTexto("18", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegSinNombreReal() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(empleador, robot);

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Bahiano", robot);

		TestUtils.clickComponent(contrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(confirmarContrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("2232354761", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());

		TestUtils.clickComponent(empleado, robot);

		TestUtils.clickComponent(apellido, robot);
		TestUtils.tipeaTexto("Massa", robot);

		TestUtils.clickComponent(edad, robot);
		TestUtils.tipeaTexto("18", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegSinTelefono() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(empleador, robot);

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Bahiano", robot);

		TestUtils.clickComponent(contrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(confirmarContrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Augusto", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());

		TestUtils.clickComponent(empleado, robot);

		TestUtils.clickComponent(apellido, robot);
		TestUtils.tipeaTexto("Massa", robot);

		TestUtils.clickComponent(edad, robot);
		TestUtils.tipeaTexto("18", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegSinApellido() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Bahiano", robot);

		TestUtils.clickComponent(contrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(confirmarContrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Augusto", robot);

		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("2232354761", robot);

		TestUtils.clickComponent(empleado, robot);

		TestUtils.clickComponent(edad, robot);
		TestUtils.tipeaTexto("18", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegSinEdad() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Bahiano", robot);

		TestUtils.clickComponent(contrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(confirmarContrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Augusto", robot);

		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("2232354761", robot);

		TestUtils.clickComponent(empleado, robot);

		TestUtils.clickComponent(apellido, robot);
		TestUtils.tipeaTexto("Massa", robot);

		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	}

	@Test
	public void testRegCorrecto() {
		robot.delay(TestUtils.getDelay());

		TestUtils.clickComponent(empleador, robot);

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Bahiano", robot);

		TestUtils.clickComponent(contrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(confirmarContrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Augusto", robot);

		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("2232354761", robot);

		Assert.assertTrue("El boton de registro deberia estar habilitado", registroButton.isEnabled());
		
		
		TestUtils.clickComponent(comercioInternacional, robot);
		Assert.assertTrue("El boton de registro deberia estar habilitado", registroButton.isEnabled());

		TestUtils.clickComponent(comercioLocal, robot);
		Assert.assertTrue("El boton de registro deberia estar habilitado", registroButton.isEnabled());
		
		TestUtils.clickComponent(salud, robot);
		Assert.assertTrue("El boton de registro deberia estar habilitado", registroButton.isEnabled());
		
		TestUtils.clickComponent(juridica, robot);
		Assert.assertTrue("El boton de registro deberia estar habilitado", registroButton.isEnabled());
		
		TestUtils.clickComponent(fisica, robot);
		Assert.assertTrue("El boton de registro deberia estar habilitado", registroButton.isEnabled());

		TestUtils.clickComponent(empleado, robot);

		TestUtils.clickComponent(apellido, robot);
		TestUtils.tipeaTexto("Massa", robot);

		TestUtils.clickComponent(edad, robot);
		TestUtils.tipeaTexto("-1", robot);
		Assert.assertFalse("El boton de registro deberia estar deshablitado", registroButton.isEnabled());
	
		TestUtils.borraJTextField(edad, robot);
		TestUtils.clickComponent(edad, robot);
		TestUtils.tipeaTexto("18", robot);
		Assert.assertTrue("El boton de registro deberia estar hablitado", registroButton.isEnabled());
		
	}
	@Test
	public void testReg1Empleador() {
		robot.delay(TestUtils.getDelay());
		int aux = Agencia.getInstance().getEmpleadores().size();

		TestUtils.clickComponent(empleador, robot);

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Bahiano", robot);

		TestUtils.clickComponent(contrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(confirmarContrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Augusto", robot);

		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("2232354761", robot);		
		
		TestUtils.clickComponent(comercioInternacional, robot);

		TestUtils.clickComponent(fisica, robot);
		
		TestUtils.clickComponent(registroButton, robot);

		Assert.assertTrue("no se agrego el empleador a la lista de empleadores", Agencia.getInstance().getEmpleadores().size() == aux+1);
		
	}
	@Test
	public void testReg1Empleado() {
		robot.delay(TestUtils.getDelay());
		int aux = Agencia.getInstance().getEmpleados().size();

		TestUtils.clickComponent(empleado, robot);

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Juan", robot);

		TestUtils.clickComponent(contrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(confirmarContrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Ignacio", robot);

		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("5543621457", robot);		
		
		TestUtils.clickComponent(salud, robot);

		TestUtils.clickComponent(juridica, robot);
		
		TestUtils.clickComponent(apellido, robot);
		TestUtils.tipeaTexto("Massa", robot);

		TestUtils.clickComponent(edad, robot);
		TestUtils.tipeaTexto("18", robot);
		
		TestUtils.clickComponent(registroButton, robot);


		Assert.assertTrue("no se agrego el empleador a la lista de empleados", Agencia.getInstance().getEmpleados().size() == aux+1);
		
	}
	@Test	
	public void testRegPassNoCoincide() {
		robot.delay(TestUtils.getDelay());
		int aux = Agencia.getInstance().getEmpleadores().size();

		TestUtils.clickComponent(empleador, robot);

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Juan", robot);

		TestUtils.clickComponent(contrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(confirmarContrasenia, robot);
		TestUtils.tipeaTexto("123486", robot);

		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Ignacio", robot);

		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("5543621457", robot);		
		
		TestUtils.clickComponent(salud, robot);

		TestUtils.clickComponent(juridica, robot);
		
		TestUtils.clickComponent(registroButton, robot);
		
		Assert.assertEquals(Mensajes.PASS_ERRONEO.getValor(), op.getMensaje());//se espera un mensaje pero en realidad agrega el empleado con contraseña incorrecta
		//no existe Mensajes.PASS_NO_COINCIDE
	}
	@Test
	public void testRegUsuarioRepetido() {
		robot.delay(TestUtils.getDelay());


		try {
			Agencia.getInstance().registroEmpleado("Roberts", "123456", "Roberto", "Manhattan", "2233222332", 18);
		} catch (NewRegisterException | ImposibleCrearEmpleadoException e) {
			
		}
		
		TestUtils.clickComponent(empleado, robot);

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Roberts", robot);

		TestUtils.clickComponent(contrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(confirmarContrasenia, robot);
		TestUtils.tipeaTexto("123486", robot);

		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Ignacio", robot);

		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("5543621457", robot);		
		
		TestUtils.clickComponent(salud, robot);

		TestUtils.clickComponent(juridica, robot);
		
		TestUtils.clickComponent(apellido, robot);
		TestUtils.tipeaTexto("Massa", robot);

		TestUtils.clickComponent(edad, robot);
		TestUtils.tipeaTexto("18", robot);
		
		TestUtils.clickComponent(registroButton, robot);
		
		Assert.assertEquals(Mensajes.USUARIO_REPETIDO.getValor(), op.getMensaje());
	}
	
	//Mensajes.PARAMETROS_NULOS no sucede nunca
	
	
	@Test
	public void testCambioDePanel() {
		robot.delay(TestUtils.getDelay());
		int aux = Agencia.getInstance().getEmpleadores().size();

		TestUtils.clickComponent(empleador, robot);

		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Bahiano", robot);

		TestUtils.clickComponent(contrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(confirmarContrasenia, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(nombreReal, robot);
		TestUtils.tipeaTexto("Augusto", robot);

		TestUtils.clickComponent(telefono, robot);
		TestUtils.tipeaTexto("2232354761", robot);		
		
		TestUtils.clickComponent(comercioInternacional, robot);

		TestUtils.clickComponent(fisica, robot);
		
		TestUtils.clickComponent(registroButton, robot);

		fail("se debe testear cambio de panel");

	}
}
