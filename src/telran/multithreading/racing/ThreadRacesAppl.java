package telran.multithreading.racing;

import java.util.ArrayList;
import java.util.List;

import telran.view.ConsoleInputOutput;
import telran.view.InputOutput;

public class ThreadRacesAppl {
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
		List<ThreadRacer> racers = new ArrayList<>();
		for(int i = 1; i<= nRunners; i++) {
			racers.add(new ThreadRacer(i, distance));
		}
		start(racers);
		join(racers);
		io.writeObjectLine("Congratulations to thread #" + ThreadRacer.winnerId);
	}

	private static void start(List<ThreadRacer> racers) {
		racers.forEach(racer -> racer.start());
	}
	private static void join(List<ThreadRacer> racers) {
		racers.forEach(racer -> {
			try {
				racer.join();
			} catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		});
	}

}
