package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCozinha;

public class Principal {
	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore (1); 
		
		for(int id=0; id<5; id++) {
			Thread tcozinha = new ThreadCozinha(id, semaforo); 
			tcozinha.start();
		}
		
		
	}

}
