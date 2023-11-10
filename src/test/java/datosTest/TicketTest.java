package datosTest;

import static org.junit.Assert.*;

import org.junit.Test;


import modeloDatos.Ticket;
import util.Constantes;

public class TicketTest {

	@Test
	public void testTicket() {
		try {
		Ticket t1c = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertEquals(t1c.getLocacion(), Constantes.HOME_OFFICE);
		assertTrue("falla en registrar remuneracion P1", t1c.getRemuneracion()==2000);
		assertEquals(t1c.getJornada(),Constantes.JORNADA_MEDIA);
		assertEquals(t1c.getPuesto(),Constantes.JUNIOR);
		assertEquals(t1c.getExperiencia(),Constantes.EXP_NADA);
		assertEquals(t1c.getEstudios(),Constantes.PRIMARIOS);
		}
		catch (Exception e) {
			fail ("no debería lanzar excepción p1");
		}
		try {
			Ticket t2c = new Ticket (Constantes.PRESENCIAL,2000,Constantes.JORNADA_COMPLETA,Constantes.SENIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
			assertEquals(t2c.getLocacion(), Constantes.PRESENCIAL);
			assertTrue("falla en registrar remuneracion P2", t2c.getRemuneracion()==2000);
			assertEquals(t2c.getJornada(),Constantes.JORNADA_COMPLETA);
			assertEquals(t2c.getPuesto(),Constantes.SENIOR);
			assertEquals(t2c.getExperiencia(),Constantes.EXP_MEDIA);
			assertEquals(t2c.getEstudios(),Constantes.SECUNDARIOS);
			}
		catch (Exception e) {
			fail ("no debería lanzar excepción p2");
		}
		try {
			Ticket t3c = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.MANAGMENT,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
			assertEquals(t3c.getLocacion(), Constantes.INDISTINTO);
			assertTrue("falla en registrar remuneracion P3", t3c.getRemuneracion()==2000);
			assertEquals(t3c.getJornada(),Constantes.JORNADA_EXTENDIDA);
			assertEquals(t3c.getPuesto(),Constantes.MANAGMENT);
			assertEquals(t3c.getExperiencia(),Constantes.EXP_MUCHA);
			assertEquals(t3c.getEstudios(),Constantes.TERCIARIOS);
			}
		catch (Exception e) {
			fail ("no debería lanzar excepción p3");
		}
	}

	@Test
	public void testGetComparacionEstudios() {
		Ticket t11 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t21 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p1", 1.0 == t11.getComparacionEstudios(t21));
		Ticket t12 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t22 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		assertTrue("falla p2", 1.5 == t12.getComparacionEstudios(t22));
		Ticket t13 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t23 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		assertTrue("falla p3", 2.0 == t13.getComparacionEstudios(t23));
		Ticket t14 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		Ticket t24 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p4", -0.5 == t14.getComparacionEstudios(t24));
		Ticket t15 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		Ticket t25 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		assertTrue("falla p5", 1.0 == t15.getComparacionEstudios(t25));		
		Ticket t16 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		Ticket t26 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		assertTrue("falla p6", 1.5 == t16.getComparacionEstudios(t26));			
		Ticket t17 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		Ticket t27 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p7", -2.0 == t17.getComparacionEstudios(t27));
		Ticket t18 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		Ticket t28 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		assertTrue("falla p8", -1.5 == t18.getComparacionEstudios(t28));		
		Ticket t19 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		Ticket t29 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		assertTrue("falla p9", 1.0 == t19.getComparacionEstudios(t29));
	}

	@Test
	public void testGetComparacionExperiencia() {
		Ticket t11 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t21 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p1", 1.0 == t11.getComparacionExperiencia(t21));
		Ticket t12 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t22 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		assertTrue("falla p2", 1.5 == t12.getComparacionExperiencia(t22));
		Ticket t13 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t23 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		assertTrue("falla p3", 2.0 == t13.getComparacionExperiencia(t23));
		Ticket t14 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		Ticket t24 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p4", -0.5 == t14.getComparacionExperiencia(t24));
		Ticket t15 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		Ticket t25 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		assertTrue("falla p5", 1.0 == t15.getComparacionExperiencia(t25));		
		Ticket t16 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		Ticket t26 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		assertTrue("falla p6", 1.5 == t16.getComparacionExperiencia(t26));			
		Ticket t17 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		Ticket t27 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p7", -2.0 == t17.getComparacionExperiencia(t27));
		Ticket t18 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		Ticket t28 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		assertTrue("falla p8", -1.5 == t18.getComparacionExperiencia(t28));		
		Ticket t19 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		Ticket t29 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		assertTrue("falla p9", 1.0 == t19.getComparacionExperiencia(t29));
	}
	
	@Test
	public void testGetComparacionJornada() {
		Ticket t11 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t21 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p1", 1.0 == t11.getComparacionJornada(t21));
		Ticket t12 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t22 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		assertTrue("falla p2", -0.5 == t12.getComparacionJornada(t22));
		Ticket t13 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t23 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		assertTrue("falla p3", -1.0 == t13.getComparacionJornada(t23));
		Ticket t14 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		Ticket t24 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p4", -0.5 == t14.getComparacionJornada(t24));
		Ticket t15 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		Ticket t25 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		assertTrue("falla p5", 1.0 == t15.getComparacionJornada(t25));		
		Ticket t16 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		Ticket t26 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		assertTrue("falla p6", -0.5 == t16.getComparacionJornada(t26));			
		Ticket t17 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		Ticket t27 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p7", -1.0 == t17.getComparacionJornada(t27));
		Ticket t18 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		Ticket t28 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		assertTrue("falla p8", 1.0 == t18.getComparacionJornada(t28));		
		Ticket t19 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		Ticket t29 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		assertTrue("falla p9", 1.0 == t19.getComparacionJornada(t29));
	}
	
	@Test
	public void testGetComparacionLocacion() {
		Ticket t11 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t21 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p1", 1.0 == t11.getComparacionLocacion(t21));
		Ticket t12 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t22 = new Ticket (Constantes.PRESENCIAL,2000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		assertTrue("falla p2", -1.0 == t12.getComparacionLocacion(t22));
		Ticket t13 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t23 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		assertTrue("falla p3", 1.0 == t13.getComparacionLocacion(t23));
		Ticket t14 = new Ticket (Constantes.PRESENCIAL,2000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		Ticket t24 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p4", -1.0 == t14.getComparacionLocacion(t24));
		Ticket t15 = new Ticket (Constantes.PRESENCIAL,2000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		Ticket t25 = new Ticket (Constantes.PRESENCIAL,2000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		assertTrue("falla p5", 1.0 == t15.getComparacionLocacion(t25));		
		Ticket t16 = new Ticket (Constantes.PRESENCIAL,2000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		Ticket t26 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		assertTrue("falla p6", -1.0 == t16.getComparacionLocacion(t26));			
		Ticket t17 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		Ticket t27 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p7", 1.0 == t17.getComparacionLocacion(t27));
		Ticket t18 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		Ticket t28 = new Ticket (Constantes.PRESENCIAL,2000,Constantes.JORNADA_COMPLETA,Constantes.JUNIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		assertTrue("falla p8", -1.0 == t18.getComparacionLocacion(t28));		
		Ticket t19 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		Ticket t29 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		assertTrue("falla p9 ", 1.0 == t19.getComparacionLocacion(t29));
	}
	
	@Test
	public void testGetComparacionPuesto() {
		Ticket t11 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t21 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p1", 1.0 == t11.getComparacionPuesto(t21));
		Ticket t12 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t22 = new Ticket (Constantes.PRESENCIAL,2000,Constantes.JORNADA_COMPLETA,Constantes.SENIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		assertTrue("falla p2", -0.5 == t12.getComparacionPuesto(t22));
		Ticket t13 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t23 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.MANAGMENT,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		assertTrue("falla p3", -1.0 == t13.getComparacionPuesto(t23));
		Ticket t14 = new Ticket (Constantes.PRESENCIAL,2000,Constantes.JORNADA_COMPLETA,Constantes.SENIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		Ticket t24 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p4", -0.5 == t14.getComparacionPuesto(t24));
		Ticket t15 = new Ticket (Constantes.PRESENCIAL,2000,Constantes.JORNADA_COMPLETA,Constantes.SENIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		Ticket t25 = new Ticket (Constantes.PRESENCIAL,2000,Constantes.JORNADA_COMPLETA,Constantes.SENIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		assertTrue("falla p5", 1.0 == t15.getComparacionPuesto(t25));		
		Ticket t16 = new Ticket (Constantes.PRESENCIAL,2000,Constantes.JORNADA_COMPLETA,Constantes.SENIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		Ticket t26 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.MANAGMENT,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		assertTrue("falla p6", -0.5 == t16.getComparacionPuesto(t26));			
		Ticket t17 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.MANAGMENT,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		Ticket t27 = new Ticket (Constantes.HOME_OFFICE,2000,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p7", -1.0 == t17.getComparacionPuesto(t27));
		Ticket t18 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.MANAGMENT,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		Ticket t28 = new Ticket (Constantes.PRESENCIAL,2000,Constantes.JORNADA_COMPLETA,Constantes.SENIOR,Constantes.EXP_MEDIA,Constantes.SECUNDARIOS);
		assertTrue("falla p8", 1.0 == t18.getComparacionPuesto(t28));		
		Ticket t19 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.MANAGMENT,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		Ticket t29 = new Ticket (Constantes.INDISTINTO,2000,Constantes.JORNADA_EXTENDIDA,Constantes.MANAGMENT,Constantes.EXP_MUCHA,Constantes.TERCIARIOS);
		assertTrue("falla p9", 1.0 == t19.getComparacionPuesto(t29));
	}

	public void testGetComparacionRemuneracion() {
		Ticket t11 = new Ticket (Constantes.INDISTINTO,500,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t21 = new Ticket (Constantes.HOME_OFFICE,800,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p1", 1.0 == t11.getComparacionRemuneracion(t21));
		Ticket t12 = new Ticket (Constantes.INDISTINTO,500,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t22 = new Ticket (Constantes.HOME_OFFICE,1500,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		assertTrue("falla p2", -0.5 == t12.getComparacionRemuneracion(t22));
		Ticket t13 = new Ticket (Constantes.INDISTINTO,500,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t23 = new Ticket (Constantes.HOME_OFFICE,2100,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		assertTrue("falla p3", -1.0 == t13.getComparacionRemuneracion(t23));
		Ticket t14 = new Ticket (Constantes.INDISTINTO,1500,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		Ticket t24 = new Ticket (Constantes.HOME_OFFICE,800,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p4", 1.0 == t14.getComparacionRemuneracion(t24));
		Ticket t15 = new Ticket (Constantes.INDISTINTO,1500,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		Ticket t25 = new Ticket (Constantes.HOME_OFFICE,1200,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		assertTrue("falla p5", 1.0 == t15.getComparacionRemuneracion(t25));		
		Ticket t16 = new Ticket (Constantes.INDISTINTO,1500,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		Ticket t26 = new Ticket (Constantes.HOME_OFFICE,2100,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		assertTrue("falla p6", -0.5 == t16.getComparacionRemuneracion(t26));			
		Ticket t17 = new Ticket (Constantes.INDISTINTO,2100,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		Ticket t27 = new Ticket (Constantes.HOME_OFFICE,900,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p7", 1.0 == t17.getComparacionRemuneracion(t27));
		Ticket t18 = new Ticket (Constantes.INDISTINTO,2100,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		Ticket t28 = new Ticket (Constantes.HOME_OFFICE,1200,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		assertTrue("falla p8", 1.0 == t18.getComparacionRemuneracion(t28));		
		Ticket t19 = new Ticket (Constantes.INDISTINTO,2100,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		Ticket t29 = new Ticket (Constantes.HOME_OFFICE,2200,Constantes.JORNADA_MEDIA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.TERCIARIOS);
		assertTrue("falla p9", 1.0 == t19.getComparacionRemuneracion(t29));
	}
	@Test
	public void testGetComparacionTotalEsc1() {
		Ticket t11 = new Ticket (Constantes.INDISTINTO,1500,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		Ticket t21 = new Ticket (Constantes.INDISTINTO,1500,Constantes.JORNADA_EXTENDIDA,Constantes.JUNIOR,Constantes.EXP_NADA,Constantes.PRIMARIOS);
		assertTrue("falla p1", 6.0 == t11.getComparacionTotal(t21));
	}
	
	@Test
	public void testGetComparacionTotalEsc2() {
		Ticket t12 = new Ticket (Constantes.HOME_OFFICE,1200,Constantes.JORNADA_EXTENDIDA,Constantes.SENIOR,Constantes.EXP_NADA,Constantes.SECUNDARIOS);
		Ticket t22 = new Ticket (Constantes.PRESENCIAL,1500,Constantes.JORNADA_COMPLETA,Constantes.MANAGMENT,Constantes.EXP_MUCHA,Constantes.PRIMARIOS);
		assertTrue("falla p2", 1.0 == t12.getComparacionTotal(t22));
	}
}
