import java.util.Arrays;

public class philChecker {
	public static void main(String[] args) {
		FileIO reader = new FileIO();
		
		String[] rawData = reader.load("X://LABWORK/CS211/alice.txt");
		int rawRows = rawData.length;
		int rawColumns = rawData[0].split("\t").length;
		String[][] data = new String[rawRows][rawColumns];
		System.out.println(Arrays.toString(rawData));
		
		for(int i = 0; i < rawData.length; i++) {
			String[] tokens = rawData[i].split("\t");
			for(int j = 0; j < tokens.length; j++) {
				data[i][j] = tokens[j];
			}
		}
		
		for(int i = 0; i < data.length; i++) {
			System.out.println(data[i][12]);
		}
		
		//System.out.println(Arrays.deepToString(data));
		
		try {
			reader.save("X://LABWORK/CS211/bob.csv",data);
			System.out.println("SAVED");
		} catch(Exception e) {
			System.out.println(e.getClass());
		}
	}
}
