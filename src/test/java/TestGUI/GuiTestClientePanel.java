package TestGUI;

import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.junit.Before;

import bin.modeloDatos.Ticket;
import controlador.Controlador;
import modeloDatos.Cliente;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;
import vista.Ventana;

public class GuiTestClientePanel {

	protected Robot robot;
	protected Controlador controlador;

	protected FalsoOptionPane op = new FalsoOptionPane();
	
	protected JButton loginButton,seleccionarCandidato,nuevoTicket,eliminarTicket,confirmarTicket,cerrarSesion;
	protected JTextField nombreUsuario,contra;
	protected JRadioButton jornadaMedia,jornadaCompleta,jornadaExtendida,expNada,expMedia,expMucha,primario,secundario,terciario,junior,senior,magnament,prescencial,homeOffice,indistinto;
	protected JList<Ticket> textAreaTicket;
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

		
		textAreaTicket = (JList<Ticket>) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXT_AREA_TICKET);
		listaCandidatos = (JList<Cliente>) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.LISTA_CANDIDATOS);
		
	}
	
	
}
