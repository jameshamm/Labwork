import java.io.File;
import countdown.FileIO;

public class characterReplacer {
	public static void main(String[] args) {
		FileIO reader = new FileIO();
		
		char[] topTen = new char[11];
		topTen[0] = ' ';
		
		final File folder = new File("src/languages");
		
		for(final File fileEntry : folder.listFiles()) {
			if(fileEntry.getName().contains("monograms.txt")) {
				System.out.println(fileEntry.getName());
				topTen = addTopCharacters("src/languages/"+fileEntry.getName());
			}
		}
	}
	
	public static char[] addTopCharacters(String path) {
		return new char[11];
	}
}
