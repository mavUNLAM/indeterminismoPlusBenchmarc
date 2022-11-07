package ar.edu.unalm.pb2;

public class Main {

	public static void main(String[] args) {
		Integer cantThreads = Runtime.getRuntime().availableProcessors();
		Long resultEsperado = cantThreads * 2000000l;
		System.out.println("Cantidad de hilos del procesador: " + cantThreads);
		System.out.println("Resultado esperado: " + resultEsperado + "\n");
		
		metodoClasico();
		
		
		metodoIndeterminista();
		
		
		resultadoCorrecto();
		
	}

	private static void resultadoCorrecto() {
		Long inicio = System.currentTimeMillis();
		
		//---------------------------------------------------------------
		Integer cantThreads = Runtime.getRuntime().availableProcessors();
		ResultadoCorrecto[] vectorCorrecto = new ResultadoCorrecto[cantThreads];
		
		for(int i = 0 ; i < vectorCorrecto.length; i++) {
			vectorCorrecto[i] = new ResultadoCorrecto();
			vectorCorrecto[i].start();
		}
		try {
			for(int i = 0 ; i < vectorCorrecto.length; i++) {
				vectorCorrecto[i].join();
			}
		}catch(InterruptedException e) {}
		//---------------------------------------------------------------
		
		Long fin = System.currentTimeMillis() - inicio;
		
		System.out.println("Resultado correcto: " + ResultadoCorrecto.getContador());
		System.out.println("Tiempo que tardó en finalizar (ms): " + fin + "\n");
	}

	private static void metodoIndeterminista() {
		Long inicio = System.currentTimeMillis();
		
		//---------------------------------------------------------------
		Integer cantThreads = Runtime.getRuntime().availableProcessors();
		Indeterminismo[] vector = new Indeterminismo[cantThreads];
		
		for(int i = 0 ; i < vector.length; i++) {
			vector[i] = new Indeterminismo();
			vector[i].start();
		}
		try {
			for(int i = 0 ; i < vector.length; i++) {
				vector[i].join();
			}
		}catch(InterruptedException e) {}
		//---------------------------------------------------------------
		
		Long fin = System.currentTimeMillis() - inicio;
		
		System.out.println("Resultado indeterminado: " + Indeterminismo.getContador());
		System.out.println("Tiempo que tardó en finalizar (ms): " + fin + "\n");
	}

	private static void metodoClasico() {
		Long inicio = System.currentTimeMillis();
		
		//-----------------------------------------------------------------
		Clasico clasico = new Clasico();
		clasico.run();
		//-----------------------------------------------------------------
		
		Long fin = System.currentTimeMillis() - inicio;
		System.out.println("Resultado clásico: " + clasico.getContador());
		System.out.println("Tiempo que tardó en finalizar (ms): " + fin + "\n");
	}

}
