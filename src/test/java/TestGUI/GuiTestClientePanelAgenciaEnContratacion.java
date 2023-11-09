package TestGUI;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import modeloNegocio.Agencia;
import util.Mensajes;

public class GuiTestClientePanelAgenciaEnContratacion extends GuiTestClientePanel {

	
	@Override
	public void inicializacionDatos() {
		Agencia.getInstance().gatillarRonda();
		super.inicializacionDatos();
	}
	@After
	public void tearDown() throws Exception {
		Agencia.getInstance().gatillarRonda();
		super.tearDown();
	}

	@Test
	public void testSeleccionarCandidato() {
		robot.delay(TestUtils.getDelay());
		
		listaCandidatos.setSelectedIndex(0);
		
		TestUtils.clickComponent(seleccionarCandidato, robot);
		Assert.assertEquals("deberia salir una ventana emergente o el texto es incorrecto",op.getMensaje(), controlador.getVista().getCandidato().toString());
		fail("no sale una ventana emergente, NO hay manera se saber si la ventana emergente es visible");
	}
	@Test
	public void testAreaDeTexto() {
		robot.delay(TestUtils.getDelay());
		
		Assert.assertFalse("no deberia mostra el mensaje Mensajes.SIN_TICKET.getValor()",textAreaTicket.getText() == Mensajes.SIN_TICKET.getValor());
	}
	@Test
	public void testEliminacionTicket() {
		robot.delay(TestUtils.getDelay());

			/*TestUtils.clickComponent(nuevoTicket, robot);//la creacion por la clase controlador no actualiza la pantalla
			TestUtils.clickComponent(remuneracionPretendida, robot);
			TestUtils.tipeaTexto("1300", robot);
			TestUtils.clickComponent(confirmarTicket, robot);*/
			
			Assert.assertTrue("deberia estar activado",eliminarTicket.isEnabled());
			TestUtils.clickComponent(eliminarTicket, robot);
			Assert.assertTrue("deberia estar activado",eliminarTicket.isEnabled());
			

	}

}
