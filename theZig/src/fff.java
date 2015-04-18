import java.io.*;
import java.util.*;
import countdown.FileIO;


public class fff {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileIO reader = new FileIO();
		String[] text = reader.load("src/languages/enc.txt");
		Set<String> words = new TreeSet<>();
		
		for(int i = 0; i < text.length; i++) {
			String[] temp = text[i].split(" ");
			
			for(int j = 0; j < temp.length; j++) {
				String t = temp[j].replaceAll("[,.]", "");
				words.add(t);
			}
		}
		
		String[] save = words.toArray(new String[words.size()]);
		
		
		//sort
		for(int t = 0; t < save.length - 1; t++) {
			for(int i = 0; i < save.length - t - 1; i++) // for(int i = 0; i<t1.length -1; i++)
			{
				String a = save[i];
				String b = save[i + 1];
				int s = a.length() - b.length();
				if(s == 0)// if(t1[i+1].compareTo(t1[1+1])>0)
				{
					if(a.compareTo(b) > 0) {
						String tempStr = save[i];
						save[i] = save[i + 1];
						save[i + 1] = tempStr;
					}
				} else {
					if(s > 0) {
						String tempStr = save[i];
						save[i] = save[i + 1];
						save[i + 1] = tempStr;
					}
				}
			}
		}
		
		reader.save("src/languages/singleWords.txt", save);
	}
}