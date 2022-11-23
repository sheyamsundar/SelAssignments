package Day2;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueCharacters {

	public static void main(String[] args) {
		
		String name = "sheyam sundar";
		char[] nameArray = name.toCharArray();
		
		Set<Character> nameSet = new HashSet<Character>();
		
		for(int i = 0; i < nameArray.length; i++) {
			boolean add = nameSet.add(nameArray[i]);
			if(!add) {
				nameSet.remove(nameArray[i]);
			}
		}
		
		System.out.println(nameSet);
	}

}
