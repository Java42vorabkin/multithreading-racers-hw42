package telran.multithreading.racing;

import java.util.ArrayList;
import java.util.List;

import telran.view.ConsoleInputOutput;
import telran.view.InputOutput;

public class ThreadRacesAppl2 {
	private static final int THREADs_MIN = 3;
	private static final int THREADs_MAX = 10;
	private static final int DISTANCE_MIN = 100;
	private static final int DISTANCE_MAX = 3500;

	public static void main(String[] args) {
		InputOutput io = new ConsoleInputOutput();
		io.writeObjectLine("Thread Racers");
		int nRunners = io.readInt(String.format("Please chose number of runners from %d to %d Threads",
				THREADs_MIN, THREADs_MAX), THREADs_MIN, THREADs_MAX);
		int distance = io.readInt(String.format("Please chose a distance from %d to %d",
				DISTANCE_MIN, DISTANCE_MAX), DISTANCE_MIN, DISTANCE_MAX);
		Thread[] racers = new Thread[nRunners];
		for(int i = 0; i< nRunners; i++) {
			racers[i] = new Thread(new ThreadRacer2(i+1, distance));
		}
		start(racers);
		join(racers);
		io.writeObjectLine("Congratulations to thread #" + ThreadRacer2.winnerId);
	}
	private static void start(Thread[] racers) {
		for(int i=0; i<racers.length; i++) {
			racers[i].start();
		}
	}

	private static void join(Thread[] racers) {
		for(int i=0; i<racers.length; i++) {
			try {
				racers[i].join();
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
