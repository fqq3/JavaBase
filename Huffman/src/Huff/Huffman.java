package Huff;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Huffman extends Hufftree {
	private String symbols = "";
	private String charSent = "";
	private String codeSent = "";	//table 7-4
	private Map<Character, String> initCode = new HashMap<Character, String>();
	
	public Huffman() {
		initCode();
	}
	
	/**
	 * Initialize the data string
	 */
	public void initCode() {
		initTree(51);
		symbols = NYT + "ABCD";
		
		initCode.put(NYT, "0");
		initCode.put('A', "00001");
		initCode.put('B', "00010");
		initCode.put('C', "00011");
		initCode.put('D', "00100");
	}
	
	/**
	 * Update the tree
	 * 
	 * @param newchar
	 */
	public void updateTree(char newchar) {
		int current;
		int max;
		
		try {	// first appearance for symbol
			current = find (newchar);	// 查找 newchar 对应的节点Go to symbol external node
			max = highestInBlock(tree[current].count);	//交换位置 有相同权重的节点中位置最高的节点的索引Node number max in block?
			if (current != max && tree[current].parent != max) {
				print ("    Swapping nodes " +current+ " and " +max);
				swap(current, max);	// Switch node with highest node in block
				current = max;//指向交换后的位置
			}
			print ("    Increasing count for '" +newchar+ "'");
			tree[current].count++;	// Increment node weight
		} catch (NoSuchElementException e) {	// Yes
			print ("    Spawning new node for '" +newchar+ "'");
			current = spawn(newchar);	// NYT gives birth to new NYT and external node
			current = tree[current].parent;	// Go to old NYT node
			tree[current].count++;	// Increment count of old NYT node
		}
		
		while (current != root) {	// Is this the root node?
			current = tree[current].parent;	// Go to parent node
			max = highestInBlock(tree[current].count);	// Node number max in block?
			if (current != max && tree[current].parent != max) {
				print ("    Swapping nodes " +current+ " and " +max);
				swap(current, max);	// Switch node with highest node in block
				current = max;
			}
			tree[current].count++;	// Increment node weight
		}
	}
	
	/**
	 * Encode 编码
	 * 
	 * @param hold		current char
	 * @return code		code of current char
	 */
	public String encode(char hold) {
		String code;
		try {
			code = hold + "(" + char2code(hold) + ") ";
			print ("Character '" + hold + "' FOUND:");
			print ("    Sending code for '" +hold+ "'");
		} catch (NoSuchElementException d) {
			print ("Character '" + hold + "' not found:");
			code = char2code(NYT);
			if (code.equals("")) {
				code = initCode.get(NYT);
			}
			code = "NEW(" + code + ") " + hold + "(" + initCode.get(hold) + ") ";
			print ("   Sending NYT and character '" + hold + "'");
		}
		return code;
	}
	
	public void print (String mess) {
		System.out.println(mess);
	}
	
	public void run(String charList) {
		charSent = charList;
		int i, j;
		char hold, symbol;
		for (i=0; i<charSent.length(); i++) {
			hold = charSent.charAt(i);	// current char
			
			codeSent += encode(hold);	// 1.encode
			print ("*Sequence of symbols and codes sent to the decoder:");
			print ("   " + codeSent);
			
			print ("Updating the tree:");
			updateTree(hold);	// 2.update
			
			print ("*Print the code of each symbol:");
			StringBuilder sb = new StringBuilder();
			for (j=0; j<symbols.length(); j++) {
				symbol = symbols.charAt(j);
				if (symbol == NYT) {
					sb.append("NEW").append("(");
				} else {
					sb.append(symbol).append("(");
				}
				try {
					sb.append(char2code(symbol));
				} catch (NoSuchElementException e) {
					sb.append(initCode.get(symbol));
				}
				sb.append(") ");
			}
			print ("   " + sb.toString());
			print ("");
		}
	}
	
	public static void main(String[] args) {
		 Huffman huff1 = new Huffman();
		String charList = "AADCCDD";	// "ABBCADAD";
		huff1.run(charList);
	}
}
 