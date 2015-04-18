/*	This object simulates a Binary Tree structure
 * 	It 
 * 
 * 
 */

public class Tree implements Comparable<Tree>{
	public int frequency, height;
	public Node root;
	
	//constructor
	public Tree() {
		root = null;
		height = 0;
	}
	
	public Tree(Node root, int frequency) {
		this.root = root;
		this.frequency = frequency;
	}
	
	public Tree(Node root, int frequency, int height) {
		this.root = root;
		this.frequency = frequency;
		this.height = height;
	}
	
	//comparator
	public int compareTo(Tree t) {
		if(frequency == t.frequency) {
			if(height == t.height) return 0;
			return (height-t.height > 0)? 1:-1;
		}
		return (frequency-t.frequency > 0)? 1:-1;
	}
	
	String path = "";
	boolean foundChar = false;
	
	//gets the huffman path that leads to a character
	public String getPath(char c) {
		inOrder(root, c, "");
		foundChar = false;
		return path;
	}

	public void inOrder(Node current, char c, String path) {
		if(!foundChar && current != null) {
			if(current.letter == c) {
				this.path = path;
				foundChar = true;
			}
			else {
				inOrder(current.leftChild, c, path+"0");
				inOrder(current.rightChild, c, path+"1");
			}
		} 
	}
	
	//overrides toString
	public String toString() {
		return "frequency: "+frequency+", height: "+height;
	}
}
