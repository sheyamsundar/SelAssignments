package Day2;

import java.util.HashSet;
import java.util.Set;

public class CountDuplicateWords {

	public static void main(String[] args) {
		String text = "We learn java basics as part of java sessions in java week1";
		String[] split = text.split(" ");
		int count = 0;
		
		Set<String> strSet = new HashSet<String>();
		
		for(int i = 0; i < split.length; i++) {
			boolean add = strSet.add(split[i]);
			if(!add)
				count++;
		}
		
		System.out.println("Set values: "+strSet);
		System.out.println("Number of duplicate words: "+count);

	}

}
