package ar.edu.unalm.pb2;

public class Clasico {
	
	private Long contador = 0l;
	
	public void run() {
		Integer cantThreads = Runtime.getRuntime().availableProcessors();
		int repeticiones = cantThreads * 2000000;
		for(int i = 0; i < repeticiones; i++) {
			contador++;
			contador++;
			contador--;
			contador++;
			contador--;
		}
	}
	
	public Long getContador() {
		return contador;
	}
}
