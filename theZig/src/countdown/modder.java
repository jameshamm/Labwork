package countdown;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class modder {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		sortByLength("src/dictionary.txt");
	}

	public static void sortByLength(String path) throws FileNotFoundException, IOException {
		FileIO reader = new FileIO();
		String[] raw = reader.load(path);
		for(int i = 0; i < raw.length; i++) {
			raw[i] = raw[i].trim();
		}

		Arrays.sort(raw, new MyComparator());

		System.out.println(Arrays.toString(raw));
		reader.save("src/dictionaryByLength.txt", raw);
	}
}


class MyComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		if(o2.length() > o1.length()) {
			return 1;
		} else if(o2.length() < o1.length()) {
			return -1;
		}
		return o1.compareTo(o2);
	}
}