package testIntegracion;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestCaso1_Admin.class,
	TestCaso1_Empleado.class,
	TestCaso1_Empleador.class,
	TestCaso2.class,
	TestCaso3y5.class,
	TestCaso4.class
})
public class SuiteIntegracion {

}
