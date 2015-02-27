public class Lab1BitShift {
	
	public static void main(String[] args) {
		System.out.println("result: " +nextTwo(123));
	}
	
	static int nextTwo(int n) {
		return ((n-- & n++) == 0) ? n : nextTwo(++n >> 1) << 1;
	}

//	public static int inc(int n){
//        if ((n & 1) == 0) // if even add 1
//            return n | 1;
//        else 
//            return inc(n>>1)<<1; // else move bits right and try again
//    }
} 

