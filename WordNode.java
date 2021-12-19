package structures;

/**
 * This class encapsulates a word with fields for the word, and connections
 * 		to a left and right WordNode
 * @author kmascola
 * @date 2019
 */
public class WordNode {
	
	//A single word
	String word;
	
	//The number of times this word has been inserted
	private int quantity;
	
	//A left child of this node
	WordNode left;
	
	//A right child of this node
	WordNode right;
	
	public WordNode(String word, WordNode left, WordNode right) {
		this.word = word;
		quantity = 1;
		this.left = left;
		this.right = right;
	}
	
	public void updateQuantity() {
		quantity++;
	}
	
	public int getQuantity() {
		return quantity;
	}
	

}
