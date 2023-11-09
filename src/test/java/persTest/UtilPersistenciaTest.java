package persTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Cliente;
import modeloDatos.Contratacion;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import persistencia.AgenciaDTO;
import persistencia.UtilPersistencia;

public class UtilPersistenciaTest {
	UtilPersistencia testDePersistencia;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAgenciaDTOFromAgencia() throws Exception {
		try {
			AgenciaDTO agdto;
			EmpleadoPretenso testPretenso = new EmpleadoPretenso ("torime","abcdario","Maria","0303456","Antonieta",45);
			HashMap<Cliente, Double> testComisiones = new HashMap<Cliente,Double>();
			testComisiones.put(testPretenso, 0.9);
			HashMap<String,EmpleadoPretenso> testEmpleadosPretensos = new HashMap<String,EmpleadoPretenso>();
			HashMap<String,Empleador> testEmpleadores = new HashMap<String,Empleador>();
			ArrayList<Contratacion> testContrataciones = new ArrayList<Contratacion>();
			Agencia.getInstance().setComisionesUsuarios(testComisiones);
			Agencia.getInstance().setContrataciones(testContrataciones);
			Agencia.getInstance().setEmpleadores(testEmpleadores);
			Agencia.getInstance().setEmpleados(testEmpleadosPretensos);
			Agencia.getInstance().setEstadoContratacion(false);
			Agencia.getInstance().setLimitesRemuneracion(1000,2000);
			agdto= UtilPersistencia.AgenciaDtoFromAgencia();
			assertEquals("No coincide comisiones", agdto.getComisionesUsuarios(),Agencia.getInstance().getComisionesUsuarios());
			assertEquals("No coincide contrataciones", agdto.getContrataciones(),Agencia.getInstance().getContrataciones());
			assertEquals("No coincide empleadores", agdto.getEmpleadores(),Agencia.getInstance().getEmpleadores());
			assertEquals("No coincide empleados", agdto.getEmpleados(),Agencia.getInstance().getEmpleados());
			assertTrue("No coincide estado de contratacion", agdto.isEstadoContratacion()==Agencia.getInstance().isEstadoContratacion());
			assertTrue("No coincide limite inferior", agdto.getLimiteInferior()==Agencia.getInstance().getLimiteInferior());
			assertTrue("No coincide limite superior", agdto.getLimiteSuperior()==Agencia.getInstance().getLimiteSuperior());   
		} catch (Exception e){
			fail ("No debería lanzar excepcion");
		}
		
	}
	
	@Test
	public void testAgenciaFromAgenciaDTO() throws Exception {
	   try {	
		AgenciaDTO agdto = new AgenciaDTO();
		EmpleadoPretenso testPretenso = new EmpleadoPretenso ("torime","abcdario","Maria","0303456","Antonieta",45);
		HashMap<Cliente, Double> testComisiones = new HashMap<Cliente,Double>();
		testComisiones.put(testPretenso, 0.9);
		HashMap<String,EmpleadoPretenso> testEmpleadosPretensos = new HashMap<String,EmpleadoPretenso>();
		HashMap<String,Empleador> testEmpleadores = new HashMap<String,Empleador>();
		ArrayList<Contratacion> testContrataciones = new ArrayList<Contratacion>();
		agdto.setComisionesUsuarios(testComisiones);
		agdto.setContrataciones(testContrataciones);
		agdto.setEmpleadores(testEmpleadores);
		agdto.setEmpleados(testEmpleadosPretensos);
		agdto.setEstadoContratacion(false);
		agdto.setLimiteInferior(1000);
		agdto.setLimiteSuperior(2000);
		UtilPersistencia.agenciaFromAgenciaDTO(agdto);
		assertEquals("No coincide comisiones", agdto.getComisionesUsuarios(),Agencia.getInstance().getComisionesUsuarios());
		assertEquals("No coincide contrataciones", agdto.getContrataciones(),Agencia.getInstance().getContrataciones());
		assertEquals("No coincide empleadores", agdto.getEmpleadores(),Agencia.getInstance().getEmpleadores());
		assertEquals("No coincide empleados", agdto.getEmpleados(),Agencia.getInstance().getEmpleados());
		assertTrue("No coincide estado de contratacion", agdto.isEstadoContratacion()==Agencia.getInstance().isEstadoContratacion());
		assertTrue("No coincide limite inferior", agdto.getLimiteInferior()==Agencia.getInstance().getLimiteInferior());
		assertTrue("No coincide limite superior", agdto.getLimiteSuperior()==Agencia.getInstance().getLimiteSuperior());   
	   }
	   catch (Exception e) {
		   fail("No debería arrojar una excepcion");
	   }
	}
}
