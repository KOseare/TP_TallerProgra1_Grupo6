package TestGUI;

import static org.junit.Assert.fail;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTextField;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import controlador.Controlador;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import util.Constantes;
import vista.Ventana;

public class GuiTestAdminPanelConDatos extends GuiTestAdminPanel{
	

	@Before
	public void setUp() throws Exception {
		Agencia.getInstance().getEmpleadores().clear();
		Agencia.getInstance().getEmpleados().clear();

		try {
			Agencia.getInstance().registroEmpleador("Juan Ignacio", "password", "DrOcropus :P", "4637283942", Constantes.FISICA, Constantes.SALUD);
			Agencia.getInstance().registroEmpleado("Roberts", "123456", "Roberto", "Manhattan", "2233222332", 18);

		} catch (Exception e) {
			fail("no deberia lanzar excepcion");
		} 
		
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
	public void testAplicarPromoEmpleado() {
    	robot.delay(TestUtils.getDelay());
    	listaEmpleados.setSelectedIndex(0);
        TestUtils.clickComponent(listaPostulantes, robot);
        TestUtils.clickComponent(aplicarPromoButton, robot);

        Assert.assertTrue("deberia salir una ventana emergente o el mensaje es invalido",op.getMensaje()==listaEmpleados.getSelectedValue().toString());
        
	}
	@Test
	public void testAplicarPromoEmpleadoSinListaPostulantes() {
    	robot.delay(TestUtils.getDelay());
    	listaEmpleados.setSelectedIndex(0);
        TestUtils.clickComponent(aplicarPromoButton, robot);

        Assert.assertTrue("deberia salir una ventana emergente o el mensaje es invalido",op.getMensaje()==listaEmpleados.getSelectedValue().toString());
	}
	@Test
	public void testAplicarPromoEmpleador() {
    	robot.delay(TestUtils.getDelay());
    	listaEmpleadores.setSelectedIndex(0);
        TestUtils.clickComponent(listaPostulantes, robot);
        TestUtils.clickComponent(aplicarPromoButton, robot);

        Assert.assertTrue("deberia salir una ventana emergente o el mensaje es invalido",op.getMensaje()==listaEmpleadores.getSelectedValue().toString());
        
	}
	@Test
	public void testAplicarPromoEmpleadorSinListaPostulantes() {
    	robot.delay(TestUtils.getDelay());
    	listaEmpleadores.setSelectedIndex(0);
        TestUtils.clickComponent(aplicarPromoButton, robot);

        Assert.assertTrue("deberia salir una ventana emergente o el mensaje es invalido",op.getMensaje()==listaEmpleadores.getSelectedValue().toString());
	}
	

}
