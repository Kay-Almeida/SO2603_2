package controller;

import java.util.concurrent.Semaphore;

public class ThreadCozinha extends Thread {
	
	int id; 
	private int max, min; 
	private Semaphore semaforo; 
	
	public ThreadCozinha(int id, Semaphore semaforo) {
		this.id = id; 
		this.semaforo = semaforo; 
	}
	
	public void run () {
		cozimento();
		try {
			semaforo.acquire();
			entrega(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
            semaforo.release();
		}
	}
	
	public void cozimento() {
		if(id%2!=0) {
			min = 500; 
			max = 800; 
			int range = max - min + 1;
			int tempo = (int) (Math.random()* range) + min;
		//  double porcentagem = (tempo*10)/100; 
			System.out.println(String.format("A Sopa de Cebola "+ id +" está em fase de cozimento por "+ (double) tempo/1000 + " segundos"));
			try {
				sleep(tempo);
				for(double i=0; i<tempo; i=i+100) {
					System.out.println("Sopa de cebola está "+ id + " está " + ((i/100)*10) + "% cozida");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			
		}else {
			min = 600; 
			max = 1200; 
			int range = max - min + 1;
			int tempo = (int) ((Math.random()* range) + min);
			System.out.println (String.format("A Lasanha a Bolonhesa "+ id +" está em fase de cozimento por "+ (double) tempo/1000 + " segundos"));
			try {
				sleep(tempo);
				for(double  i=0; i<tempo; i=i+100) {
					System.out.println("Lasanha a Bolonhesa "+ id +" está " + ((i/100)*10) + "% cozida");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}	
	}
	
	public void entrega () {
		if(id%2!=0) {
			int tempo = 500;  
			double tempos = (double) tempo/1000; 
			System.out.println(String.format("Sopa de cebola "+ id +" está sendo entregue em "+ tempos + " segundos"));

			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}else {
			int tempo = 500; 
			double tempos = (double) tempo/1000; 
			System.out.println(String.format("Lasanha a Bolonhesa "+ id +" está sendo entregue em "+ tempos + " segundos"));
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
