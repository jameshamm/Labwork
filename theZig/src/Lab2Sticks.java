import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Lab2Sticks {
	private static boolean time = true;
	private static boolean timeInd = false;
	private static boolean debug = false;
	private static long start;

	public static void main(String[] args) {
		if (time)
			start = System.nanoTime();
		long iterations = 1_000_000_0;
		int breaks = 8;

		double total = 0.0;
		for (long i = 0; i < iterations; i++) {
			total += breakSticks(breaks);
		}
		System.out.println("With " + breaks + " breaks: " + total * 100.0
				/ iterations + "%");
		if (time)
			System.out.println((System.nanoTime() - start) / 1000000 + "ms");
	}

	static int breakSticks(int n) {
		double length = 1;
		if (timeInd)
			start = System.nanoTime();
		Set<Double> breaks = new HashSet<Double>();
		while (breaks.size() < n) {
			double rand = ThreadLocalRandom.current().nextDouble(length);
			if (rand > 0.0)
				breaks.add(rand);
		}
		double[] pointsToBreak = new double[n];
		int x = 0;
		for (Double dobby : breaks) {
			pointsToBreak[x++] = dobby;
		}
		Arrays.sort(pointsToBreak);

		double[] sticks = new double[n + 1];

		sticks[0] = pointsToBreak[0];
		for (int i = 1; i < n; i++) {
			sticks[i] = pointsToBreak[i] - pointsToBreak[i - 1];
		}
		sticks[n] = length - pointsToBreak[n - 1];
		Arrays.sort(sticks);

		if (debug)
			System.out.println("NEW SET OF STICKS " + Arrays.toString(sticks));
		for (int i = 0; i < n - 1; i++) {
			if (sticks[i] + sticks[i + 1] > sticks[i + 2]) {
				if (debug)
					System.out.println("It can from with sticks from " + i);
				return 1;
			}
		}
		if (debug)
			System.out.println("It can't");
		return 0;
	}

	static int breakSticks() {
		return breakSticks(2);
	}
}