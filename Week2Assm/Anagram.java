package StringAssm;

import java.util.Arrays;
public class Anagram {

	public static void main(String[] args) {
		String str1 = "stops";
		String str2 = "potss";
		boolean status = false;
		if(str1.length()!=str2.length()) {
			System.out.println("Not an anagram");
		}
		else {
			char[] ArrayS1 = str1.toLowerCase().toCharArray();
			char[] ArrayS2 = str2.toLowerCase().toCharArray();
			Arrays.sort(ArrayS1);
			Arrays.sort(ArrayS2);
			status = Arrays.equals(ArrayS1, ArrayS2);
		}
		if(status)
			System.out.println("Anagram");
		else
			System.out.println("Not an anagram");

	}

}
