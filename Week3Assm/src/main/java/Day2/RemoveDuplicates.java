package Day2;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String str = "PayPal";
		char[] ch = str.toCharArray();
		
		Set<Character> charSet = new HashSet<Character>();
		Set<Character> dupcharSet = new HashSet<Character>();
		
		for(int i = 0; i < ch.length; i++) {
			//Adding characters in to charSet
			boolean add = charSet.add(ch[i]);
			if(!add) {
				//Adding duplicate characters in to dupcharSet
				dupcharSet.add(ch[i]);
			}
		}
		System.out.println(charSet);
		System.out.println(dupcharSet);
		
		//Check the dupCharSet elements and remove those in the charSet
		charSet.removeAll(dupcharSet);
		System.out.println("After removing the character which are in dupCharSet:" +charSet);
		
	}

}
