package TestGUI;

import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bin.util.Mensajes;
import controlador.Controlador;
import excepciones.ImposibleModificarTicketsException;
import modeloDatos.Cliente;
import modeloNegocio.Agencia;
import util.Constantes;
import vista.Ventana;

public class GuiTestClientePanel {

	protected Robot robot;
	protected Controlador controlador;

	protected FalsoOptionPane op = new FalsoOptionPane();
	
	protected JButton loginButton,seleccionarCandidato,nuevoTicket,eliminarTicket,confirmarTicket,cerrarSesion;
	protected JTextField nombreUsuario,contra,remuneracionPretendida;
	protected JRadioButton jornadaMedia,jornadaCompleta,jornadaExtendida,expNada,expMedia,expMucha,primario,secundario,terciario,junior,senior,managment,prescencial,homeOffice,indistinto;
	protected JTextArea textAreaTicket;
	protected JList<Cliente> listaCandidatos;
	
	public GuiTestClientePanel() {
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
		
		try {
			Agencia.getInstance().registroEmpleador("Juan Ignacio", "password", "DrOcropus :P", "4637283942", Constantes.FISICA, Constantes.SALUD);
			Agencia.getInstance().registroEmpleado("Roberts", "123456", "Roberto", "Manhattan", "2233222332", 18);

		} catch (Exception e) {
			fail("no deberia lanzar excepcion");
		} 
		

		loginButton = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.LOGIN);
		
		nombreUsuario = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NOMBRE_USUARIO);
		contra = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.PASSWORD);
		
		
		
		TestUtils.clickComponent(nombreUsuario, robot);
		TestUtils.tipeaTexto("Roberts", robot);
		TestUtils.clickComponent(contra, robot);
		TestUtils.tipeaTexto("123456", robot);

		TestUtils.clickComponent(loginButton, robot);
		
		// se debe de abrir un Panel Cliente

		// datos a usar
		seleccionarCandidato = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.SELECCIONAR_CANDIDATO);
		nuevoTicket = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NUEVOTICKET);
		eliminarTicket = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.ELIMINAR_TICKET);
		confirmarTicket = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CONFIRMARNUEVOTICKET);
		cerrarSesion = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CERRARSESION);
		
		jornadaMedia = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.JORNADA_MEDIA);
		jornadaCompleta = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.JORNADA_COMPLETA);
		jornadaExtendida = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.JORNADA_EXTENDIDA);

		expNada = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EXP_NADA);
		expMedia = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EXP_MEDIA);
		expMucha = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EXP_MUCHA);
		
		primario = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.PRIMARIOS);
		secundario = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.SECUNDARIOS);
		terciario = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TERCIARIOS);
		
		junior = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.JUNIOR);
		senior = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.SENIOR);
		managment = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.MANAGMENT);
		
		prescencial = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.PRESENCIAL);
		homeOffice = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.HOME_OFFICE);
		indistinto = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.INDISTINTO);
		
		textAreaTicket = (JTextArea) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXT_AREA_TICKET);
		listaCandidatos = (JList<Cliente>) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.LISTA_CANDIDATOS);
		remuneracionPretendida = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTFIELD_REMUNERACION);
	}
	
	@Test
	public void testSeleccionarCandidatoVacio() {
		robot.delay(TestUtils.getDelay());
		
		try {
			TestUtils.clickComponent(seleccionarCandidato, robot);	
		}catch(Exception e) {
			fail("no deberia lanzar excepcion");
		}
	}
	
	@Test
	public void testCamposNuevoTicket() {
		robot.delay(TestUtils.getDelay());
			
		TestUtils.clickComponent(nuevoTicket, robot);
	
		Assert.assertFalse("deberia estar desactivado", nuevoTicket.isEnabled());
		
		Assert.assertTrue("deberia estar activado", jornadaMedia.isRolloverEnabled());
		Assert.assertTrue("deberia estar activado", jornadaExtendida.isRolloverEnabled());
		Assert.assertTrue("deberia estar activado", jornadaCompleta.isRolloverEnabled());

		Assert.assertTrue("deberia estar activado", expNada.isRolloverEnabled());
		Assert.assertTrue("deberia estar activado", expMedia.isRolloverEnabled());
		Assert.assertTrue("deberia estar activado", expMucha.isRolloverEnabled());
		
		Assert.assertTrue("deberia estar activado", primario.isRolloverEnabled());
		Assert.assertTrue("deberia estar activado", secundario.isRolloverEnabled());
		Assert.assertTrue("deberia estar activado", terciario.isRolloverEnabled());
		
		Assert.assertTrue("deberia estar activado", junior.isRolloverEnabled());
		Assert.assertTrue("deberia estar activado", senior.isRolloverEnabled());
		Assert.assertTrue("deberia estar activado", managment.isRolloverEnabled());
		
		Assert.assertTrue("deberia estar activado", prescencial.isRolloverEnabled());
		Assert.assertTrue("deberia estar activado", homeOffice.isRolloverEnabled());
		Assert.assertTrue("deberia estar activado", indistinto.isRolloverEnabled());
	
		Assert.assertTrue("deberia estar activado", remuneracionPretendida.isEditable());
		
		//scroll hasta remuneracion pretendida
		TestUtils.clickComponent(remuneracionPretendida, robot);

		TestUtils.tipeaTexto("-1", robot);
		Assert.assertFalse("deberia estar desactivado", confirmarTicket.isEnabled());
		TestUtils.borraJTextField(remuneracionPretendida, robot);
		TestUtils.tipeaTexto("aaa", robot);
		Assert.assertFalse("deberia estar desactivado", confirmarTicket.isEnabled());
		TestUtils.borraJTextField(remuneracionPretendida, robot);
		TestUtils.tipeaTexto("1300", robot);
		Assert.assertTrue("deberia estar activado", confirmarTicket.isEnabled());
		
		
	}
	@Test
	public void testCreacionNuevoTicket() {
		robot.delay(TestUtils.getDelay());

		//scroll hasta remuneracion pretendida
		TestUtils.clickComponent(remuneracionPretendida, robot);
		TestUtils.tipeaTexto("1300", robot);
		
		TestUtils.clickComponent(confirmarTicket, robot);
		Assert.assertFalse("deberia estar desactivado", confirmarTicket.isEnabled());
		Assert.assertTrue("deberia estar activado", nuevoTicket.isEnabled());
		
		
	}
	@Test
	public void testEliminacionTicket() {
		robot.delay(TestUtils.getDelay());
		try {
			Agencia.getInstance().crearTicketEmpleado(Constantes.PRESENCIAL, 12000, Constantes.JORNADA_MEDIA, Constantes.JUNIOR, Constantes.EXP_NADA, Constantes.TERCIARIOS, Agencia.getInstance().getEmpleados().get(0));
		} catch (ImposibleModificarTicketsException e) {
			// TODO Auto-generated catch block
			fail("no deberia lanzar excepcion");
		}
	}
	@Test
	public void testAreaDeTexto() {
		robot.delay(TestUtils.getDelay());
		Assert.assertTrue("deberia mostra el mensaje Mensajes.SIN_TICKET.getValor()",textAreaTicket.getText() == "");//no existe Mensajes.SIN_TICKET.getValor()
	}
	@Test
	public void testCerrarSesion() {
		robot.delay(TestUtils.getDelay());
		
		TestUtils.clickComponent(cerrarSesion, robot);
		Assert.assertTrue("deberia estar habilitado",cerrarSesion.isEnabled());
		Assert.assertFalse("deberia volver a la panel login",cerrarSesion.isEnabled());//no encuentro manera de obtener el panel actual

	}
	
}
