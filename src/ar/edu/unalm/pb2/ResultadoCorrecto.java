package ar.edu.unalm.pb2;

public class ResultadoCorrecto extends Thread {

	private static Long contador = 0l;
	private static Object cerrojo = 0;
	private static Integer repeticiones = 2000000;
	
	@Override
	public void run() {
		int cont = 0;
		for(int i = 0; i < repeticiones; i++) {
			cont++;
			cont++;
			cont--;
			cont++;
			cont--;
		}
		synchronized (cerrojo) {
			contador += cont;
		}
		
	}
	
	public static Long getContador() {
		return contador;
	}
}
