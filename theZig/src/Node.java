class Node {
	public char letter;
	public int frequency;
	public Node leftChild, rightChild;
	
	public Node() {
		letter = '\u0000'; //default 'null' character
		frequency = 0;
		leftChild = null;
		rightChild = null;
	}
	
	public Node(char letter, int frequency) {
		this.letter = letter;
		this.frequency = frequency;
		leftChild = null;
		rightChild = null;
	}
	
	boolean isLeaf() {
		return (leftChild == null && rightChild == null);
	}
}
