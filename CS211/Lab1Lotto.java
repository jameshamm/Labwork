import java.util.*;

/* 	Write a Java program that uses a Monte Carlo algorithm
 * 		to calculate the probability that next week’s lottery draw won’t have any consecutive pairs of numbers 
 * 		e.g. 8,9 or 22, 23 
 * 		Six numbers are drawn from 1 to 45
 * 
 * 		@author James Hamm 13525307
 * 		@dateModified 04.02.15 
 */

public class Lab1Lotto {
	public static void main(String[] args) {
		int ITERATIONS = 1_000_000, total = 0;
		Random rand = new Random();
		for (int i = 0; i < ITERATIONS; i++) {
			Set<Integer> mySet = new TreeSet<Integer>();
			while (mySet.size() < 6) {
				int x = rand.nextInt(45) + 1;
				if (mySet.contains(x + 1) || mySet.contains(x - 1)) {
					total += 1;
					break;
				} else 
					mySet.add(x);
			}
		}
		System.out.println((double) (ITERATIONS - total) / ITERATIONS);
	}
}
