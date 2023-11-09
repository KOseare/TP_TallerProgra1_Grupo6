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
import persistencia.AgenciaDTO;

public class AgenciaDTOTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEscenario1() {
		try {
		AgenciaDTO ag = new AgenciaDTO();
		EmpleadoPretenso testPretenso = new EmpleadoPretenso ("torime","abcdario","Maria","0303456","Antonieta",45);
		HashMap<Cliente, Double> testComisiones = new HashMap<Cliente,Double>();
		testComisiones.put(testPretenso, 0.9);
		HashMap<String,EmpleadoPretenso> testEmpleadosPretensos = new HashMap<String,EmpleadoPretenso>();
		HashMap<String,Empleador> testEmpleadores = new HashMap<String,Empleador>();
		ArrayList<Contratacion> testContrataciones = new ArrayList<Contratacion>();
		ag.setComisionesUsuarios(testComisiones);
		ag.setContrataciones(testContrataciones);
		ag.setEmpleadores(testEmpleadores);
		ag.setEmpleados(testEmpleadosPretensos);
		ag.setEstadoContratacion(false);
		ag.setLimiteInferior(1000);
		ag.setLimiteSuperior(2000);
		}
		catch (Exception e) {
			fail ("no debería lanzar una excepcion");
		}
	}

}
