package Utils;

import java.io.IOException;

import persistencia.IPersistencia;

public class MockPersistencia<E> implements IPersistencia<E> {
	
	private boolean throwExcp;
	
	public MockPersistencia (boolean throwExcp) {
		this.throwExcp = throwExcp;
	}

	@Override
	public void abrirInput(String arg0) throws IOException {
		if (throwExcp) throw new IOException();
	}

	@Override
	public void abrirOutput(String arg0) throws IOException {
		if (throwExcp) throw new IOException();
	}

	@Override
	public void cerrarInput() throws IOException {
		if (throwExcp) throw new IOException();
	}

	@Override
	public void cerrarOutput() throws IOException {
		if (throwExcp) throw new IOException();
	}

	@Override
	public void escribir(E arg0) throws IOException {
		if (throwExcp) throw new IOException();
	}

	@Override
	public E leer() throws IOException, ClassNotFoundException {
		if (throwExcp) throw new IOException();
		return null;
	}

}
