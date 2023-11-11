package datosTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	EmpleadorTest.class,
	UsuarioTest.class,
	EmpleadoPretensoTest.class,
	AdminTest.class,
	ContratacionTest.class,
	TicketTest.class
})
public class SuiteDatos {

}
