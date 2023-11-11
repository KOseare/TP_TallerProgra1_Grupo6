package TestGUI;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ GuiTestAdminPanel.class, GuiTestAdminPanelConDatos.class, GuiTestClientePanel.class,
		GuiTestLoginPanel.class, GuiTestLoginPanelConDatos.class, GuiTestRegistroPanel.class })
public class AllTests {

}
