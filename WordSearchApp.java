package apps;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import structures.WordTree;

public class WordSearchApp {
	static Scanner s1 = new Scanner(System.in);
	static Scanner s2;
	
	static final int BUILD = 1;
	static final int INSERT = 2;
	static final int LOCATE = 3;
	static final int QUIT = 4;
	
	static WordTree tree = new WordTree();

	public static void buildTree() throws IOException{
		tree = new WordTree();
		System.out.print("Enter the name of the text file to build the word tree => ");
		s2 = new Scanner(new File(s1.nextLine()));
		while(s2.hasNext())
			tree.insertWord(s2.next());
	}
	
	public static void insert() {
		System.out.print("Enter a word to be inserted into the word tree => ");
		String word = s1.next();
		s1.nextLine();
		int quantity = tree.insertWord(word);
		System.out.printf("The word %s has been inserted %d time(s).\n\n", word, quantity);
	}
	
	public static void locate() {
		System.out.print("Enter a word to be located in the tree => ");
		String word = s1.next();
		s1.nextLine();
		int depth = tree.wordSearch(word);
		if(depth < 0)
			System.out.printf("The word %s is not in the word tree.\n\n", word);
		else
			System.out.printf("The word %s is located at a depth of %d from the root.\n\n", word, depth);
	}
	
	public static void main(String[] args) throws IOException{
		int choice = getChoice();
		while (choice != QUIT) {
			if (choice < 1 || choice > QUIT) {
				System.out.println("\tIncorrect choice " + choice);
			} else {
				switch (choice) {
				case BUILD: buildTree(); break;
				case INSERT: insert(); break;
				case LOCATE: locate(); break;
				default: break;
				}
			}
			choice = getChoice();
		}
	}
	
	public static int getChoice() 
	throws IOException {
		System.out.println();
		System.out.println(BUILD + ". BUILD a new WordTree from a text file");
		System.out.println(INSERT + ". INSERT a Word into the current WordTree");
		System.out.println(LOCATE + ". LOCATE Word in the WordTree");
		System.out.println(QUIT + ". QUIT");
		System.out.print("\tEnter choice # => ");
		return (Integer.parseInt(s1.nextLine()));
	}
}
