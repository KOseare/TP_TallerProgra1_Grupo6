package datosTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
import util.Constantes;

public class EmpleadorTest {
	
	@Test
	public void testEmpleadorStringStringStringStringStringString() {
		Empleador e = new Empleador("pablo_r", "123456", "Pablo Rosas", "+5492236012345", Constantes.COMERCIO_LOCAL, Constantes.EMPLEADOR);
		String resultado = e.getRubro();
		assertEquals(resultado, Constantes.COMERCIO_LOCAL);
	}
	
	@Test
	public void testGetSetRubro1() {
		Empleador e = new Empleador();
		e.setRubro(Constantes.SALUD);
		assertEquals(Constantes.SALUD, e.getRubro());
	}
	
	@Test
	public void testGetSetRubro2() {
		Empleador e = new Empleador();
		e.setRubro(Constantes.COMERCIO_LOCAL);
		assertEquals(Constantes.COMERCIO_LOCAL, e.getRubro());
	}
	
	@Test
	public void testGetSetRubro3() {
		Empleador e = new Empleador();
		e.setRubro(Constantes.COMERCIO_INTERNACIONAL);
		assertEquals(Constantes.COMERCIO_INTERNACIONAL, e.getRubro());
	}

	@Test
	public void testGetSetTipoPersona1() {
		Empleador e = new Empleador();
		e.setTipoPersona(Constantes.FISICA);
		assertEquals(Constantes.FISICA, e.getTipoPersona());
	}
	
	@Test
	public void testGetSetTipoPersona2() {
		Empleador e = new Empleador();
		e.setTipoPersona(Constantes.JURIDICA);
		assertEquals(Constantes.JURIDICA, e.getTipoPersona());
	}
	
	@Test
	public void testCalculaComision1() {
		Empleador e = new Empleador();
		e.setRubro(Constantes.SALUD);
		Ticket t = new Ticket();
		t.setRemuneracion(1000);
		assertEquals(600.0, e.calculaComision(t), 0.001);
	}
	
	@Test
	public void testCalculaComision2() {
		Empleador e = new Empleador();
		e.setRubro(Constantes.COMERCIO_LOCAL);
		Ticket t = new Ticket();
		t.setRemuneracion(1000);
		assertEquals(700.0, e.calculaComision(t), 0.001);
	}
	
	@Test
	public void testCalculaComision3() {
		Empleador e = new Empleador();
		e.setRubro(Constantes.COMERCIO_INTERNACIONAL);
		Ticket t = new Ticket();
		t.setRemuneracion(1000);
		assertEquals(800.0, e.calculaComision(t), 0.001);
	}

	@Test
	public void testGetSetCandidato() {
		Empleador e = new Empleador();
		EmpleadoPretenso candidato = new EmpleadoPretenso();
		e.setCandidato(candidato);
		assertEquals(candidato, e.getCandidato());
	}

	@Test
	public void testGetSetListaDePostulantes() {
		Empleador e = new Empleador();
		ArrayList<ClientePuntaje> postulantes = new ArrayList<ClientePuntaje>();
		postulantes.add(new ClientePuntaje(10.0, new EmpleadoPretenso()));
		postulantes.add(new ClientePuntaje(25.2, new EmpleadoPretenso()));
		postulantes.add(new ClientePuntaje(15.3, new EmpleadoPretenso()));
		e.setListaDePostulantes(postulantes);
		assertEquals(postulantes, e.getListaDePostulantes());
	}

	@Test
	public void testGetSetPuntaje1() {
		Empleador e = new Empleador();
		e.setPuntaje(50);
		assertEquals(50, e.getPuntaje());
	}

	@Test
	public void testGetSetPuntaje2() {
		Empleador e = new Empleador();
		e.setPuntaje(0);
		assertEquals(0, e.getPuntaje());
	}
	
	@Test
	public void testGetSetPuntaje3() {
		Empleador e = new Empleador();
		e.setPuntaje(-10);
		assertEquals(-10, e.getPuntaje());
	}

	@Test
	public void testGetSetTicket() {
		Empleador e = new Empleador();
		Ticket t = new Ticket();
		e.setTicket(t);
		assertEquals(t, e.getTicket());
	}
}
