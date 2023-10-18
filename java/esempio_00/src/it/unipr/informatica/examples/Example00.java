package it.unipr.informatica.examples;

public class Example00 {
	private static void go() {
		for(int j = 0; j < 5; ++j) {
			Thread a = new ThreadA(j);
			a.start();
			
			Thread b = new Thread(new ThreadB(j));
			b.start();
			
			Thread c = new ThreadC(j);
			c.start();
			
			Thread d = new Thread(new ThreadD(j));
			d.start();
		}
	}
	
	public static void main(String[] args) {
		// System.out.println("Partito");
		Example00.go();
	}
	
	// Classe Inner
	// Una classe interna statica non ha accesso diretto ai membri 
	// non statici della classe esterna, ma può accedere solo a membri 
	// statici della classe esterna, se presenti.
	//
	// Se dichiaro le classi interne come statiche, posso istanziarle 
	// direttamente all'interno del metodo `go` o `main` senza dover 
	// istanziare un oggetto della classe esterna. 
	//
	// Se non metto `static` alla classe inner devo usare `Example00.this.id`
	private static class ThreadC extends Thread {
		private int id;
		
		private ThreadC(int id) {
			if(id < 0)
				throw new IllegalArgumentException("id");
			
			this.id = id;
		}
		
		@Override
		public void run() {
			for(int i = 0; i < 10; ++i)
				System.out.println("C: " + i + " - id: " + id);
		}
	}
	
	private static class ThreadD implements Runnable {
		private int id;
		
		public ThreadD(int id) {
			if(id < 0)
				throw new IllegalArgumentException("id");
			
			this.id = id;
		}
		
		@Override
		public void run() {
			for(int i = 0; i < 10; ++i)
				System.out.println("D: " + i + " - id: " + id);
		}
	}
}
