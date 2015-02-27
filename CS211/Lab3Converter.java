import java.util.*;

/*	This lab will return the ascii version of a string
 * 	It first converts it to ascii
 * 	Then it stores it in an array
 * 	Then it prints it with leading zeros
 * 	
 * 	Next it counts the frequency of each character
 * 	When a character shows up it increments a counter
 * 	The array hold all the counters
 * 	Then the array is run through and the non-trivial values are printed
 * 
 * @version 2.0™ 17/02/15
 * @author James Hamm 13525307
 * @todo 	Turn array into hashmap/table
 * 			reduce number of redundant loops
 * 			print it nicer
 * 				update the primeFactor so it produces the closest to sqrt
 * 				get string format and print together
 * 				Sort by frequency
 */

public class Lab3Converter {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		String s1 = "This is a default piece of text";
		System.out.println("Please enter a string to be encoded: ");
		String s2 = scan.nextLine();
		scan.close();
		
		

		byte[] values = (s2.length() > 0 ? s2 : s1).getBytes("US-ASCII");

		printNums(values);
		System.out.println();

		int[] frequency = new int[256];

		for (int i : values) {
			frequency[i]++;
		}

		for (int i = 0; i < frequency.length; i++) {
			if (frequency[i] > 0)
				System.out.println("'" + (char) i + "' appeared "
						+ frequency[i] + " time"
						+ ((frequency[i] == 1) ? "" : "s"));
		}

	}

	static void printNums(byte[] val) {
		int len = val.length;
		int gap = nonFactor(len);
		System.out.println("len: "+len+", gap: "+gap);
		for (int i = 0; i < len; i++) {
			System.out.print(String.format("%07d",
					Integer.parseInt(Integer.toBinaryString(val[i])))
					+ " ");
			if (i % gap == gap - 1)
				System.out.println();
		}
	}
	
	static int nonFactor(int p) {
		return (int) Math.sqrt(p);
	}

	static int sqrtFactor(int p) {
		int sqrt = (int) Math.sqrt(p);
		
		for (int i = sqrt; i > 1; i--) {
			if (p % i == 0)
				return p / i;
		}
		return p;
	}
}

//import java.util.Arrays; import java.util.HashMap; import java.util.Map; import java.util.Scanner; public class Lab3Converter { public static void main(String[] args) throws Exception { Scanner scan = new Scanner(System.in); String s1 = "This is a default piece of text"; System.out.println("Please enter a string to be encoded: "); String s2 = scan.nextLine(); scan.close(); byte[] values = (s2.length() > 0 ? s2 : s1).getBytes("US-ASCII"); System.out.println(Arrays.toString(values)); printNums(values); System.out.println(); int[] frequency = new int[256]; for (int i : values) { frequency[i]++; } for (int i = 0; i < frequency.length; i++) { if (frequency[i] > 0) System.out.println("'" + (char) i + "' appeared " + frequency[i] + " time" + ((frequency[i] == 1) ? "" : "s")); } } static void printNums(byte[] val) { int len = val.length; int gap = primeFactor(len); for (int i = 0; i < len; i++) { System.out.print(String.format("%07d", Integer.parseInt(Integer.toBinaryString(val[i]))) + " "); if (i % gap == gap - 1) System.out.println(); } } static int primeFactor(int p) { int sqrt = (int) Math.sqrt(p); for (int i = 3; i <= sqrt; i += 2) { if (p % i == 0) return p / i; } if ((p & 1) == 0) return p >> 1; return 1; } }