package testCajaBlanca;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;


public class TestUtilPromo {

	@Before 
	public void setUp(){
		EmpleadoPretenso empleado1 = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235363636", "Pereyra", 22);
		EmpleadoPretenso empleado2 = new EmpleadoPretenso("Ruben456", "Ruben456", "Ruben", "223899866", "Hernandez", 55);
		
		empleado1.setPuntaje(1);
		empleado2.setPuntaje(4);
		
		Empleador empleador1 = new Empleador();
		Empleador empleador2 = new Empleador();
		
		ClientePuntaje puntajeTest1 = new ClientePuntaje(3.4, empleado1);
		ClientePuntaje puntajeTest2 = new ClientePuntaje(4.2, empleador1);
		
		ArrayList<ClientePuntaje> lista1 = new ArrayList<ClientePuntaje>(); 
		ArrayList<ClientePuntaje> lista2 = new ArrayList<ClientePuntaje>();
		
		lista1.add(puntajeTest1);
		lista2.add(puntajeTest2);
		
		empleador2.setListaDePostulantes(lista1);
		empleado2.setListaDePostulantes(lista2);
		
		HashMap<String, EmpleadoPretenso> empleados = new HashMap<String, EmpleadoPretenso>();
		HashMap<String, Empleador> empleadores = new HashMap<String, Empleador>();
		
	}
	
	@Test
	public void testAplicaPromo1() {
		UtilPromo utilPromoTest = new UtilPromo();
		//utilPromoTest.aplicaPromo(false, empleados, empleadores);  
	}
	
}
