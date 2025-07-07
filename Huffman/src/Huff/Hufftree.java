package Huff;
import java.util.NoSuchElementException;



public class Hufftree {
	/* Adaptive Tree constants */
	static final int ALPH_SIZE = 127;	// size of the alphabet字母表
	static final char none = (char) 256;//非字符
	static final char NYT = (char) 257;// 尚未传输的节点Not Yet transmitted code (NEW: 0)
	
	protected Node tree[]=new Node[2*ALPH_SIZE];//在 Huffman 树中，每个字符可能会生成一个叶节点，而这些叶节点之间会有额外的内部节点
	protected int root;//根节点的索引

//	/* Adaptive Tree data members */
//	protected Node tree[] = new Node[2*ALPH_SIZE];
//	protected int root;
	

	/**
	 * initiate an Adaptive Tree
	 * 
	 * Creates a single-node tree with the rootnumber as the root
	 */
	public void initTree(int root_index) {//初始化函数
		for (int i=0; i < 2*ALPH_SIZE; i++) {
			tree[i] = new Node();
		}
		root = root_index;//根节点
		tree[root].str = NYT;//特殊节点标识,标识尚未出现的字符
	}
	
	/**
	 * Swap 交换函数
	 * swaps two nodes in the tree. Make sure its not an ancestor祖先
	 */
	public synchronized void swap(int first, int second) {//synchronized单线程
		int temp;
		char tempchar;
		
		// 交换左右孩子swap return pointers (chirlden's parents)
		tree[tree[first].left].parent = second;
		tree[tree[first].right].parent = second;
		tree[tree[second].left].parent = first;
		tree[tree[second].right].parent = first;
		
		// swap left pointers
		temp = tree[second].left;
		tree[second].left = tree[first].left;
		tree[first].left = temp;
		
		// swap right pointers
		temp = tree[second].right;
		tree[second].right = tree[first].right;
		tree[first].right = temp;
		
		// swap data: letter, count
		tempchar = tree[second].str;
		tree[second].str = tree[first].str;
		tree[first].str = tempchar;
		
		temp = tree[second].count;
		tree[second].count = tree[first].count;
		tree[first].count = temp;
	}
	
	/**
	 * findChar 查找函数
	 * 
	 * Returns the index of the character
	 */
	public int find (char letter) throws NoSuchElementException {
		for (int i=0; i < 2*ALPH_SIZE; i++) {
			if (tree[i].str == letter) return i;//第一个出口 返回索引
		}
		throw new NoSuchElementException(" not find");
	}
	
	/**
	 * code2char
	 * 
	 * Returns the character associated with the binary code
	 */
	public char code2char(String str) throws NoSuchElementException {
		Node current = tree[root];
		
		for (int i=0; i < str.length(); i++) {
			// check if current binary digit is valid
			if  (str.charAt(i) != '0'  && str.charAt(i) != '1') {
				throw new NoSuchElementException("Has a non-binary digit at " + i);
			}
			// go left
			if (str.charAt(i) == '0') {
				if (current.left == 0) throw new NoSuchElementException();
				else current = tree[current.left];
			}
			//go right
			else if (str.charAt(i) == '1') {
				if (current.right == 0) throw new NoSuchElementException();
				else current = tree[current.right];
			}
		}
		if (current.str == none) throw new NoSuchElementException("Not a leaf node");
		else return current.str;
	}
	
	/**
	 * char2code  将letter转换为其对应的二进制编码
	 * 
	 * Returns the code associated with the character 返回值类型为 String，表示该字符对应的二进制编码
	 */
	public String char2code(char letter) throws NoSuchElementException {
		StringBuffer bincode = new StringBuffer("");
		Node current = null;
		
		// find the letter
		current = tree[find(letter)];
		
		// Make the binary string
		while (current != tree[root]) {
			// is a left child
			if (tree[tree[current.parent].left] == current) {
				bincode.insert(0, '0');//insert(位置，字符)
			}
			// is a right child
			else if (tree[tree[current.parent].right] == current) {
				bincode.insert(0, '1');
			}
			// huh?
			else throw new NoSuchElementException ("Invalid tree structure: current node is neither left nor right child of its parent.");
			
			// move  up
			current = tree[current.parent];
		}
		return bincode.toString();
	}
	
	/**
	 * spawn
	 * 
	 * Gives birth to new NYT and external node from old NYT node
	 * returns the value of the new NYT node 创建一个新的字符节点，并同时更新 NYT（Not Yet Transmitted）节点的位置
	 */
	public int spawn (char newchar) {
		int oldNYTindex;
		Node oldNYT;
		
		// Find the current NYT node (NEW node)查找当前的 NYT 节点（空）
		oldNYTindex = find(NYT);
		oldNYT = tree[oldNYTindex];
		
		// create new nodes
		oldNYT.str = none;	// not leaf表示该节点不再是一个叶节点，而是一个内部节点 ，NYT 节点将被分裂，不再直接表示一个字符。
		
		oldNYT.right = oldNYTindex - 1;
		tree[oldNYT.right].str = newchar;
		tree[oldNYT.right].count = 1;
		tree[oldNYT.right].parent = oldNYTindex;
		
		oldNYT.left = oldNYTindex - 2;
		tree[oldNYT.left].str = NYT;
		tree[oldNYT.left].parent = oldNYTindex;
		
		return oldNYTindex - 2;
	}
	
	/**
	 * HighestInBlock 
	 * 具有指定计数 count 的所有节点中位置最高的节点
	 * 	 * Returns the value of the node that is the highest in the block
	 * i.e. of all nodes with the same count
	 */
	public int highestInBlock (int count) {
		int highest = -1;
		
		for (int i=0; i < 2*ALPH_SIZE; i++) {
			if (tree[i].count == count) highest=i;
		}
		if (highest == -1) throw new NoSuchElementException("No such node with count of " + count);
		
		return highest;
	}
}