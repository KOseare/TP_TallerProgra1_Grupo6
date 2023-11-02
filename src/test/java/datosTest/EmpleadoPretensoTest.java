package datosTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloDatos.Ticket;
import util.Constantes;

public class EmpleadoPretensoTest {
	EmpleadoPretenso emp;
	
	@Before
	public void initEmpleador () {
		this.emp = new EmpleadoPretenso();
	}

	@Test
	public void testEmpleadoPretenso() {
		this.emp = new EmpleadoPretenso("nicod", "123456", "Nicolas", "+5492236012345", "Diaz", 26);
		assertEquals("nicod", this.emp.getUsserName());
		assertEquals("123456", this.emp.getPassword());
		assertEquals("Nicolas", this.emp.getRealName());
		assertEquals("+5492236012345", this.emp.getTelefono());
		assertEquals("Diaz", this.emp.getApellido());
		assertEquals(26, this.emp.getEdad());
	}

	@Test
	public void testGetSetApellido() {
		this.emp.setApellido("Diaz");
		assertEquals("Diaz", this.emp.getApellido());
	}

	@Test
	public void testGetSetEdad() {
		this.emp.setEdad(18);
		assertEquals(18, this.emp.getEdad());
	}

	@Test
	public void testCalculaComision1() {
		this.emp.setPuntaje(0);
		Ticket t = new Ticket();
		t.setRemuneracion(1000);
		t.setPuesto(Constantes.JUNIOR);
		assertEquals(800.0, this.emp.calculaComision(t), 0.001);
	}
	
	@Test
	public void testCalculaComision2() {
		this.emp.setPuntaje(0);
		Ticket t = new Ticket();
		t.setRemuneracion(1000);
		t.setPuesto(Constantes.SENIOR);
		assertEquals(900.0, this.emp.calculaComision(t), 0.001);
	}
	
	@Test
	public void testCalculaComision3() {
		this.emp.setPuntaje(0);
		Ticket t = new Ticket();
		t.setRemuneracion(1000);
		t.setPuesto(Constantes.MANAGMENT);
		assertEquals(1000.0, this.emp.calculaComision(t), 0.001);
	}
	
	@Test
	public void testCalculaComision4() {
		this.emp.setPuntaje(15);
		Ticket t = new Ticket();
		t.setRemuneracion(1000);
		t.setPuesto(Constantes.JUNIOR);
		assertEquals(650.0, this.emp.calculaComision(t), 0.001);
	}
	
	@Test
	public void testCalculaComision5() {
		this.emp.setPuntaje(-15);
		Ticket t = new Ticket();
		t.setRemuneracion(1000);
		t.setPuesto(Constantes.SENIOR);
		assertEquals(900.0, this.emp.calculaComision(t), 0.001);
	}
	
	@Test
	public void testCalculaComision6() {
		this.emp.setPuntaje(55);
		Ticket t = new Ticket();
		t.setRemuneracion(1000);
		t.setPuesto(Constantes.MANAGMENT);
		assertEquals(500.0, this.emp.calculaComision(t), 0.001);
	}
	
	@Test
	public void testGetSetCandidato() {
		Empleador candidato = new Empleador();
		this.emp.setCandidato(candidato);
		assertEquals(candidato, this.emp.getCandidato());
	}

	@Test
	public void testGetSetListaDePostulantes() {
		ArrayList<ClientePuntaje> postulantes = new ArrayList<ClientePuntaje>();
		postulantes.add(new ClientePuntaje(10.0, new Empleador()));
		postulantes.add(new ClientePuntaje(25.2, new Empleador()));
		postulantes.add(new ClientePuntaje(15.3, new Empleador()));
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
		this.emp = new EmpleadoPretenso("nicod", "123456", "Nicolas", "+5492236012345", "Diaz", 26);
		assertEquals("nicod, realName=Nicolas Puntaje: 0  apellido=Diaz, edad=26", this.emp.toString());
	}
}
