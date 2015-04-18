
public class test {
	public static void main(String[] args) {
		int[][] array = new int[3][];
		array[0] = new int[5];
		array[1] = new int[4];
		array[2] = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = 100*i+j;
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
}
