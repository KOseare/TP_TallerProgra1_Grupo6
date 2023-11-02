package datosTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
import util.Constantes;

public class EmpleadorTest {
	Empleador emp;
	
	@Before
	public void initEmpleador () {
		this.emp = new Empleador();
	}
	
	@Test
	public void testEmpleador1() {
		this.emp = new Empleador("nicod", "123456", "Nicolas Diaz", "+5492236012345", Constantes.SALUD, Constantes.FISICA);
		assertEquals("nicod", this.emp.getUsserName());
		assertEquals("123456", this.emp.getPassword());
		assertEquals("Nicolas Diaz", this.emp.getRealName());
		assertEquals("+5492236012345", this.emp.getTelefono());
		assertEquals(Constantes.SALUD, this.emp.getRubro());
		assertEquals(Constantes.FISICA, this.emp.getTipoPersona());
	}
	
	@Test
	public void testEmpleador2() {
		this.emp = new Empleador("nicod", "123456", "Nicolas Diaz", "+5492236012345", Constantes.COMERCIO_INTERNACIONAL, Constantes.JURIDICA);
		assertEquals("nicod", this.emp.getUsserName());
		assertEquals("123456", this.emp.getPassword());
		assertEquals("Nicolas Diaz", this.emp.getRealName());
		assertEquals("+5492236012345", this.emp.getTelefono());
		assertEquals(Constantes.COMERCIO_INTERNACIONAL, this.emp.getRubro());
		assertEquals(Constantes.JURIDICA, this.emp.getTipoPersona());
	}
	
	@Test
	public void testGetSetRubro1() {
		this.emp.setRubro(Constantes.SALUD);
		assertEquals(Constantes.SALUD, this.emp.getRubro());
	}
	
	@Test
	public void testGetSetRubro2() {
		this.emp.setRubro(Constantes.COMERCIO_LOCAL);
		assertEquals(Constantes.COMERCIO_LOCAL, this.emp.getRubro());
	}
	
	@Test
	public void testGetSetRubro3() {
		this.emp.setRubro(Constantes.COMERCIO_INTERNACIONAL);
		assertEquals(Constantes.COMERCIO_INTERNACIONAL, this.emp.getRubro());
	}

	@Test
	public void testGetSetTipoPersona1() {
		this.emp.setTipoPersona(Constantes.FISICA);
		assertEquals(Constantes.FISICA, this.emp.getTipoPersona());
	}
	
	@Test
	public void testGetSetTipoPersona2() {
		this.emp.setTipoPersona(Constantes.JURIDICA);
		assertEquals(Constantes.JURIDICA, this.emp.getTipoPersona());
	}
	
	@Test
	public void testCalculaComision1() {
		this.emp.setRubro(Constantes.SALUD);
		Ticket t = new Ticket();
		t.setRemuneracion(1000);
		assertEquals(600.0, this.emp.calculaComision(t), 0.001);
	}
	
	@Test
	public void testCalculaComision2() {
		this.emp.setRubro(Constantes.COMERCIO_LOCAL);
		Ticket t = new Ticket();
		t.setRemuneracion(1000);
		assertEquals(700.0, this.emp.calculaComision(t), 0.001);
	}
	
	@Test
	public void testCalculaComision3() {
		this.emp.setRubro(Constantes.COMERCIO_INTERNACIONAL);
		Ticket t = new Ticket();
		t.setRemuneracion(1000);
		assertEquals(800.0, this.emp.calculaComision(t), 0.001);
	}

	@Test
	public void testGetSetCandidato() {
		EmpleadoPretenso candidato = new EmpleadoPretenso();
		this.emp.setCandidato(candidato);
		assertEquals(candidato, this.emp.getCandidato());
	}

	@Test
	public void testGetSetListaDePostulantes() {
		ArrayList<ClientePuntaje> postulantes = new ArrayList<ClientePuntaje>();
		postulantes.add(new ClientePuntaje(10.0, new EmpleadoPretenso()));
		postulantes.add(new ClientePuntaje(25.2, new EmpleadoPretenso()));
		postulantes.add(new ClientePuntaje(15.3, new EmpleadoPretenso()));
		this.emp.setListaDePostulantes(postulantes);
		assertEquals(postulantes, this.emp.getListaDePostulantes());
	}

	@Test
	public void testGetSetPuntaje1() {
		this.emp.setPuntaje(50);
		assertEquals(50, this.emp.getPuntaje());
	}

	@Test
	public void testGetSetPuntaje2() {
		this.emp.setPuntaje(0);
		assertEquals(0, this.emp.getPuntaje());
	}
	
	@Test
	public void testGetSetPuntaje3() {
		this.emp.setPuntaje(-10);
		assertEquals(-10, this.emp.getPuntaje());
	}

	@Test
	public void testGetSetTicket() {
		Ticket t = new Ticket();
		this.emp.setTicket(t);
		assertEquals(t, this.emp.getTicket());
	}
	
	@Test
	public void testToString() {
		this.emp = new Empleador("nicod", "123456", "Nicolas Diaz", "+5492236012345", Constantes.SALUD, Constantes.FISICA);
		assertEquals("nicod, realName=+5492236012345 Puntaje: 0", this.emp.toString());
	}
}
