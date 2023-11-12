package negocioAgenciaTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CalculaPremiosCastigosAsignacionesTest.class, CerraSesionTest.class, CrearTicketEmpleadoTest.class,
		CreatTicketEmpleadorTest.class, EliminarTicketTest.class, GatillarRondaTest.class, GeneraPostulantesTest.class,
		GetInstanceTest.class, GuardarAgenciaTest.class, LoginTest.class, MatchTest.class, RegistroEmpleadorTest.class,
		RegistroEmpleadoTest.class, SetLimitesRemuneracionTest.class })
public class SuiteNegocioAgencia {

}
