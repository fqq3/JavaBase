package vocabulary;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.Set;
//import java.util.TreeSet;

import java.io.*;
import java.util.*;
public class Vocabulary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		try {
			BufferedReader reader =new BufferedReader(new FileReader("in.txt"));//new File(
			BufferedWriter writer =new BufferedWriter(new FileWriter("words.txt"));
			String l;
			StringBuilder chars = new StringBuilder();
			
			while((l=reader.readLine())!=null) {
				//l=l.toLowerCase();
				chars.append(l).append(" ");
			}
			reader.close();
			in.close();
			
			String[] words = chars.toString().toLowerCase().split("\\P{L}+");//匹配非字母字符
			Set<String> vocabulary=new TreeSet<>(Arrays.asList(words));//不重复 有序Arrays.asList(words)
			
			for(String word:vocabulary) {
				writer.write(word);
				writer.newLine();
			}
			writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
//import java.io.BufferedReader;
//
//import java.io.BufferedWriter;
// 
//import java.io.FileReader;
// 
//import java.io.FileWriter;
// 
//import java.io.IOException;
// 
//import java.util.Scanner;
// 
//import java.util.Set;
// 
//import java.util.TreeSet;
// 
//public class Vocabulary {
// 
//public static void main(String[] args) throws IOException {
// 
//	BufferedReader ifile = new BufferedReader(new FileReader("in.txt"));
//	 
//	BufferedWriter ofile = new BufferedWriter(new FileWriter("words.txt"));
//	 
//	Set<String> words = new TreeSet<String>();
//	 
//	Scanner sc = new Scanner(System.in);
//	 
//	String s;
// 
//	int flag=0;
//	 
//	String word="";
//	 
//	while((s=ifile.readLine())!=null) {
//	 
//		s = s.toLowerCase();
//	 
//		for(int i=0;i<s.length();i++) {
//		 
//			if(Character.isLowerCase(s.charAt(i))) {
//			 
//			word+=(s.charAt(i)+"");
//			 
//			flag=1;
//			 
//			}
//		 
//			else if(flag==1) {
//			 
//			words.add(word);
//			 
//			word="";
//			 
//			flag=0;
//			 
//			}
//	 
//		}
//	 
//		if(flag==1) {
//			words.add(word);
//		}
//		 
//	}
//		 
//	for(String ch:words) {
//	 
//		ofile.write(ch);
//		 
//		ofile.newLine();
//	 
//	}
//	 
//	ofile.close();
//	 
//	ifile.close();
//	 
//	sc.close();
//	 
//	}
//}
