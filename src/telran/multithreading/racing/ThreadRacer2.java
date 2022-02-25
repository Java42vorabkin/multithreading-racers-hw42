package telran.multithreading.racing;

import java.util.Random;

public class ThreadRacer2 implements Runnable {
	static final int SLEEPING_TIME_MIN = 2;
	static final int SLEEPING_TIME_MAX = 5;
	
	private int racerId;
	private int distance;
	
	public static int winnerId = 0;
	
	
	public ThreadRacer2(int racerId, int distance) {
		this.racerId = racerId;
		this.distance = distance;
	}

	@Override
	public void run() {
		int sleepingRange=SLEEPING_TIME_MAX - SLEEPING_TIME_MIN + 1;
		for (int i = 0; i < distance; i++) {
			try {
				int sleepingTime = SLEEPING_TIME_MIN+(int)(Math.random()*sleepingRange);
				Thread.sleep(sleepingTime);
				System.out.println(racerId);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (winnerId == 0) {
			winnerId = racerId;
		}
		
	}

}
