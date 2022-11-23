package Day2;

import java.util.HashSet;
import java.util.Set;


public class RemoveDuplicateWords {

	public static void main(String[] args) {
		
		String text = "We learn java basics as part of java sessions in java week1";
		String[] split = text.split(" ");
		
		Set<String> strSet = new HashSet<String>();
		
		for(int i = 0; i < split.length; i++) {
			strSet.add(split[i]);
		}
		
		System.out.println(strSet);

	}

}
