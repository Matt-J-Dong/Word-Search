package structures;

/**
 * A Binary Search Tree of WordNodes.
 * 
 * @author Matthew Dong
 * @date 2/19/21
 */
public class WordTree {
	
	WordNode root;
	int numWords;
	
	public WordTree(){
		root = null;
		numWords = 0;
	}
	
	/**
	 * If word doesn't exist in this word tree, it should be inserted in
	 * 		the appropriate place based on Binary Search.  If words already
	 * 		exists in this tree, the quantity should be updated to reflect 
	 * 		the appropriate number of times word appears in the text
	 * @param word a word to be inserted into this Binary Search Tree
	 * @return the quantity, or number of times that word has been added to the list
	 */
	public int insertWord(String word) {
		//complete this method
		WordTree tree = new WordTree();
//		WordNode temp = root;
		if(root!=null) {
			if(root.word.compareTo(word)==0) {//if word is equal to check
				root.updateQuantity();
				++numWords;
				return root.getQuantity();
			}
			else {
				if(root.word.compareTo(word)>0) {//if word is less than check
					return nodeWord(root.left,root,word);
				}
				else {
					return nodeWord(root.right,root,word);
				}
			}
		}
		else{
			root = new WordNode(word,null,null);
			return 1;
		}
//		return 0; //quiets the compiler
	}
	private int nodeWord(WordNode temp, WordNode prev, String word) {
		if(temp==null) {
			WordNode node = new WordNode(word,null,null);
			if(prev.word.compareTo(word)>0) {
				prev.left=node;
			}
			else {
				prev.right=node;
			}
			return 1;
		}
		else{
			if(temp.word.compareTo(word)==0) {
				temp.updateQuantity();
				++numWords;
				return temp.getQuantity();
			}
			else {
				if(temp.word.compareTo(word)>0) {
					return nodeWord(temp.left,temp,word);
				}
				else {
					return nodeWord(temp.right,temp,word);
				}
			}
		}
//		return temp.getQuantity(); //quiets the compiler
	}
	/**
	 * Performs a search in this word tree for the word.  Determines and returns
	 *      the depth of the word in the tree.  The root is at depth 0, a child of
	 *      the root is at depth 1, etc... If the word is not in this word tree, -1
	 *      is returned to reflect that the word does not exist in the tree.
	 * 
	 * @param word a word to be searched for in this tree
	 * @return the depth of the word in the tree, or -1 if word is not found.
	 */
	public int wordSearch(String word) {
		//complete this method
		int num = 0;
		WordNode ptr = root;
		while(ptr.word.compareTo(word)!=0) {
			if(word.compareTo(ptr.word)<0) {
				num++;
				if(ptr.left!=null) {
					ptr=ptr.left;
				}
				else {
					return -1;
				}
			}
			else {
				num++;
				if(ptr.right!=null) {
					ptr=ptr.right;
				}
				else {
					return -1;
				}
			}
		}
		return num; //quiets the compiler
	}

}
