package testIntegracion;

import java.lang.reflect.Field;

public class MockUtils {
	public static void resetSingleton (Class cl) {
		Field instance;
		try {
			instance = cl.getDeclaredField("instance");
			instance.setAccessible(true);
			instance.set(null, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
