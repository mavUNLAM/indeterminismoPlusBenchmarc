package ar.edu.unalm.pb2;

public class Indeterminismo extends Thread{
	private static Long contador = 0l;
	private static Integer repeticiones = 2000000;
	
	@Override
	public void run() {
		for(int i = 0; i < repeticiones; i++) {
			contador++;
			contador++;
			contador--;
			contador++;
			contador--;
		}
	}
	
	public static Long getContador() {
		return contador;
	}
	
}
