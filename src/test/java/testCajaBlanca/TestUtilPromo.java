package testCajaBlanca;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Cliente;
import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import util.Constantes;

/*El método aplicaPromo de la clase UtilPromo retorna un objeto de Cliente que será el beneficiario de una promoción. Recibe los siguientes parámetros:

		boolean promoPorListaDePostulantes
		HashMap<String, EmpleadoPretenso> empleados
		HashMap<String, Empleador> empleadores)

Como precondicion, los HashMap son diferentes de null (podrían estar vacíos)
El Cliente beneficiado, puede ser un empleado o un empleador.
Si el parámetro promoPorListaDePostulantes es true, el Cliente será seleccionado del HashMap cuya sumatoria total de postulantes sea mayor.
En caso contrario, el Cliente beneficiado será seleccionado del HashMap cuya cantidad de elementos sea mayor.
Si solo uno de los HashMap está vacío, el Cliente será seleccionado del HashMap distinto de null
Una vez seleccionado el hashmap en cuestión, el Cliente beneficiado será el de mayor puntaje.
Si ambos HashMap están vacíos, el método retornará null*/

public class TestUtilPromo {
	private EmpleadoPretenso empleado1 ;
	private EmpleadoPretenso empleado2 ;
	private EmpleadoPretenso empleado3 ;

	private Empleador empleador1;
	private Empleador empleador2;
	private Empleador empleador3;

	private ArrayList<ClientePuntaje> lista1 ;
	private ArrayList<ClientePuntaje> lista2 ;

	private ClientePuntaje puntajeTest1;
	private ClientePuntaje puntajeTest1a;
	private ClientePuntaje puntajeTest2;
	private ClientePuntaje puntajeTest2a;
	
	private HashMap<String, EmpleadoPretenso> empleados;
	private HashMap<String, Empleador> empleadores;
	
	@Before 
	public void setUp(){
		empleado1 = new EmpleadoPretenso("Juan123", "Juan123", "Juan", "2235363636", "Pereyra", 22);
		empleado2 = new EmpleadoPretenso("Ruben456", "Ruben456", "Ruben", "223899866", "Hernandez", 55);
		empleado3 = new EmpleadoPretenso("Raul456", "Raul456", "Raul", "223899866", "Diaz", 44);
		
		empleador1 = new Empleador("emaSA", "emaSA", "emaSA", "2235698547", Constantes.SALUD,Constantes.FISICA);
		empleador2 = new Empleador("cook", "cook", "cook", "2235698547", Constantes.COMERCIO_INTERNACIONAL, Constantes.JURIDICA);
		empleador3 = new Empleador("SA", "SA", "SA", "2235698547", Constantes.SALUD,Constantes.JURIDICA);
		
		lista1 = new ArrayList<ClientePuntaje>(); 
		lista2 = new ArrayList<ClientePuntaje>(); 
		 
		empleados = new HashMap<String, EmpleadoPretenso>();
		empleadores = new HashMap<String, Empleador>(); 
	}
	
	@Test
	public void testAplicaPromo1() {	
		empleado1.setPuntaje(1);
		empleado2.setPuntaje(40);
		empleado3.setPuntaje(8);
		
		empleador1.setPuntaje(2);
		empleador2.setPuntaje(80);
		empleador3.setPuntaje(10);
		
		puntajeTest1 = new ClientePuntaje(5, empleado1);
		puntajeTest1a = new ClientePuntaje(8, empleado2);

		puntajeTest2 = new ClientePuntaje(10, empleador1);
		puntajeTest2a = new ClientePuntaje(5, empleador2);
 
		lista1.add(puntajeTest1);//lista 1 tiene pretenso
		lista1.add(puntajeTest1a);
	 
		lista2.add(puntajeTest2);///list 2 tiene empleadores
		 
		empleador2.setListaDePostulantes(lista1);
		empleado2.setListaDePostulantes(lista2);
		
		empleados.put("empleado1", empleado1);
		empleados.put("empleado2", empleado2);
	    empleados.put("empleado3", empleado3);
		
		empleadores.put("empleador3", empleador3);
		empleadores.put("empleador2", empleador2);
		empleadores.put("empleador1", empleador1);

		UtilPromo utilPromoTest = new UtilPromo();
		Cliente c1 = utilPromoTest.aplicaPromo(true, empleados, empleadores);  
		
		Assert.assertEquals(empleador2, c1); 
	} 

	@Test
	public void testAplicaPromo2() {

		empleador1.setPuntaje(100);
		empleador2.setPuntaje(50);
		empleador3.setPuntaje(200);
		
		int aux = Integer.MIN_VALUE;//lo tomo como valor limite_
		empleado1.setPuntaje(aux);
		empleado2.setPuntaje(aux);
		empleado3.setPuntaje(aux);

		empleados.put("empleado1", empleado1);
		empleados.put("empleado2", empleado2);
	    empleados.put("empleado3", empleado3);
		
		empleadores.put("empleador3", empleador3);
		empleadores.put("empleador2", empleador2);
		empleadores.put("empleador1", empleador1);
		 
		UtilPromo utilPromoTest = new UtilPromo();
		Cliente c1 =  utilPromoTest.aplicaPromo(true, empleados, empleadores);  

		Assert.assertEquals(null, c1); 

	}
	
	@Test
	public void testAplicaPromo3() {
		empleado1.setPuntaje(100);
		empleado2.setPuntaje(40);
		empleado3.setPuntaje(1);
		
		empleador1.setPuntaje(2);
		empleador2.setPuntaje(80);
		empleador3.setPuntaje(10);
		
		puntajeTest1 = new ClientePuntaje(5, empleado1);
		puntajeTest1a = new ClientePuntaje(8, empleado2);
		puntajeTest2 = new ClientePuntaje(10, empleador1);
		puntajeTest2a = new ClientePuntaje(5, empleador2);
	 
		lista1.add(puntajeTest1);
		lista1.add(puntajeTest1a);
		lista2.add(puntajeTest2);
			  
		empleador3.setListaDePostulantes(lista1);
		empleado3.setListaDePostulantes(lista2);
			
		empleados.put("empleado1", empleado1);
		empleados.put("empleado2", empleado2);
	    empleados.put("empleado3", empleado3);
		
		UtilPromo utilPromoTest = new UtilPromo();
		Cliente c1 = utilPromoTest.aplicaPromo(true, empleados, empleadores);  
		Assert.assertEquals(empleado1, c1); 

	}
	@Test
	public void testAplicaPromo4() {

	empleado1.setPuntaje(1);
	empleado2.setPuntaje(40);
	empleado3.setPuntaje(8);
	
	empleador1.setPuntaje(200);
	empleador2.setPuntaje(50);
	empleador3.setPuntaje(100);
	
	puntajeTest1 = new ClientePuntaje(5, empleado1);
	puntajeTest1a = new ClientePuntaje(8, empleado2);

	puntajeTest2 = new ClientePuntaje(10, empleador1);
	puntajeTest2a = new ClientePuntaje(5, empleador2);
 
	lista1.add(puntajeTest1);
	lista2.add(puntajeTest2);
	lista2.add(puntajeTest2a);	
		 
	empleador3.setListaDePostulantes(lista1);
	empleado3.setListaDePostulantes(lista2);
		
	empleadores.put("empleador3", empleador3);
	empleadores.put("empleador2", empleador2);
	empleadores.put("empleador1", empleador1);

		 
	UtilPromo utilPromoTest = new UtilPromo();
	Cliente c1 = utilPromoTest.aplicaPromo(true, empleados, empleadores);  
	Assert.assertEquals(empleador1, c1); 
	}
	
	
	@Test
	public void testAplicaPromo5() {

	empleado1.setPuntaje(10);
	empleado2.setPuntaje(40);
	empleado3.setPuntaje(8);
	
	empleador1.setPuntaje(2);
	empleador2.setPuntaje(8);
	empleador3.setPuntaje(10);
	
	puntajeTest1 = new ClientePuntaje(5, empleado1);
	puntajeTest1a = new ClientePuntaje(8, empleado2);

	puntajeTest2 = new ClientePuntaje(10, empleador1);
	puntajeTest2a = new ClientePuntaje(5, empleador2);
 
	lista2.add(puntajeTest2);///list 2 tiene empleadores
	lista2.add(puntajeTest2a);	
		 
	empleado3.setListaDePostulantes(lista2);
		
	empleados.put("empleado1", empleado1);
	empleados.put("empleado2", empleado2);
	empleados.put("empleado3", empleado3);
		
	empleadores.put("empleador3", empleador3);
	empleadores.put("empleador2", empleador2);
	empleadores.put("empleador1", empleador1);
	UtilPromo utilPromoTest = new UtilPromo();
	Cliente c1 = utilPromoTest.aplicaPromo(true, empleados, empleadores);  
	Assert.assertEquals(empleado2, c1); 
	}
	
	@Test
	public void testAplicaPromo6() { 
	UtilPromo utilPromoTest = new UtilPromo();
	Cliente c1 = utilPromoTest.aplicaPromo(true, empleados, empleadores);  
	Assert.assertEquals(null, c1); 
	}
	
	@Test
	public void testAplicaPromo7() {

	empleado1.setPuntaje(1);
	empleado2.setPuntaje(4);
	empleado3.setPuntaje(8);
	
	empleador1.setPuntaje(2);
	empleador2.setPuntaje(8);
	empleador3.setPuntaje(10);
		
	empleados.put("empleado1", empleado1);
	empleados.put("empleado2", empleado2);
		
	empleadores.put("empleador3", empleador3);
	empleadores.put("empleador2", empleador2);
	empleadores.put("empleador1", empleador1);
		 
	UtilPromo utilPromoTest = new UtilPromo();
	Cliente c1 = utilPromoTest.aplicaPromo(false, empleados, empleadores);  
	Assert.assertEquals(empleador3, c1); 
	}
	
	@Test
	public void testAplicaPromo8() {
	empleado1.setPuntaje(Integer.MIN_VALUE);
	empleado2.setPuntaje(Integer.MIN_VALUE);
	empleado3.setPuntaje(Integer.MIN_VALUE);
	
	empleador1.setPuntaje(2);
	empleador2.setPuntaje(8);
	empleador3.setPuntaje(10);
		
	empleados.put("empleado1", empleado1);
	empleados.put("empleado2", empleado2);
	empleados.put("empleado3", empleado3);
		
	empleadores.put("empleador3", empleador3);
	empleadores.put("empleador2", empleador2);

	UtilPromo utilPromoTest = new UtilPromo();
	Cliente c1 = utilPromoTest.aplicaPromo(false, empleados, empleadores);  
	Assert.assertEquals(null, c1); 
	}
	
	@Test
	public void testAplicaPromo9() {
	UtilPromo utilPromoTest = new UtilPromo();
	Cliente c1 = utilPromoTest.aplicaPromo(false, empleados, empleadores);  
	Assert.assertEquals(null, c1);   
	}
}
