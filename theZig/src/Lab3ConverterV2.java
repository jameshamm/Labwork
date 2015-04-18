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
 * @version 2.1™ 17/02/15
 * @author James Hamm 13525307
 * @todo 	reduce number of redundant loops
 * 			print it nicer
 * 				update the primeFactor so it produces the closest to sqrt
 * 				get string format and print together
 * 				Sort by frequency
 */

public class Lab3ConverterV2 {
	public static void main(String[] args) throws Exception {
		
		//get input and store as ascii in array
		Scanner scan = new Scanner(System.in);
		String s1 = "The cat sat on the mat";
		System.out.println("Please enter a string to be encoded: ");
		String s2 = scan.nextLine();
		scan.close();
		
		byte[] values = (s2.length() > 0 ? s2 : s1).getBytes("US-ASCII");

		printNums(values);
		
		
		//check frequency of each character
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for(int i = 0; i < values.length; i++) {
			char c = (char)values[i];
			if(map.get(c) == null) map.put(c, 1);
			else map.put(c, map.get(c)+1);
		}
		
		for(Character t : map.keySet()) {
			int count = map.get(t);
			if(count > 0) {
				System.out.println("'"+t+"' appears "+count+((count==1)?" time":" times"));
			}
		}
		System.out.println();
		
		//sort by frequency
		//Set<Integer>
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
		System.out.println();
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

//import java.util.*; /* This lab will return the ascii version of a string * It first converts it to ascii * Then it stores it in an array * Then it prints it with leading zeros * * Next it counts the frequency of each character * When a character shows up it increments a counter * The array hold all the counters * Then the array is run through and the non-trivial values are printed * * @version 2.1™ 17/02/15 * @author James Hamm 13525307 * @todo Turn array into hashmap/table * reduce number of redundant loops * print it nicer * update the primeFactor so it produces the closest to sqrt * get string format and print together * Sort by frequency */ public class Lab3ConverterV2 { public static void main(String[] args) throws Exception { //get input and store as ascii in array Scanner scan = new Scanner(System.in); String s1 = "The cat sat on the mat"; System.out.println("Please enter a string to be encoded: "); String s2 = scan.nextLine(); scan.close(); byte[] values = (s2.length() > 0 ? s2 : s1).getBytes("US-ASCII"); printNums(values); //check frequency of each character Map<Character, Integer> map = new HashMap<Character, Integer>(); for(int i = 0; i < values.length; i++) { char c = (char)values[i]; if(map.get(c) == null) { map.put(c, 1); } else map.put(c, map.get(c)+1); } for(Character t : map.keySet()) { int count = map.get(t); if(count > 0) { System.out.println("'"+t+"' appears "+count+((count==1)?" time":" times")); } } System.out.println(); } static void printNums(byte[] val) { int len = val.length; int gap = nonFactor(len); System.out.println("len: "+len+", gap: "+gap); for (int i = 0; i < len; i++) { System.out.print(String.format("%07d", Integer.parseInt(Integer.toBinaryString(val[i]))) + " "); if (i % gap == gap - 1) System.out.println(); } System.out.println(); } static int nonFactor(int p) { return (int) Math.sqrt(p); } static int sqrtFactor(int p) { int sqrt = (int) Math.sqrt(p); for (int i = sqrt; i > 1; i--) { if (p % i == 0) return p / i; } return p; } }