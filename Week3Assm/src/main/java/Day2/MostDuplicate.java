package Day2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MostDuplicate {

	public static void main(String[] args) {
		String s = "abbabab";
		int maxValue;
		char[] charArray = s.toCharArray();
		
		Map<Character, Integer> hash = new HashMap<Character, Integer>();
		
		for(int i =0; i< charArray.length;i++) {
			if(hash.containsKey(charArray[i])) {
				int value = hash.get(charArray[i]);
				hash.put(charArray[i], value+1);
			}
			else {
				hash.put(charArray[i], 1);
			}
		}
		System.out.println(hash);
		Set<Entry<Character, Integer>> entrySet = hash.entrySet();
		
		maxValue = Collections.max(hash.values());
		
		for (Entry<Character, Integer> entry : entrySet) {
			
			if(entry.getValue() == maxValue) {
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
			
		}

	}

}
