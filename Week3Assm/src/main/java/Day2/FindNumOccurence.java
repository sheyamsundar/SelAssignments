package Day2;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class FindNumOccurence {

	public static void main(String[] args) {
		int[] num = {2,3,5,6,3,2,1,4,2,1,6,-1};
		Map<Integer, Integer> tree = new TreeMap<Integer, Integer>();
		
		for(int i = 0; i < num.length; i++) {
			if(tree.containsKey(num[i])) {
				int value = tree.get(num[i]);
				tree.put(num[i], value+1);
			}
			
			else {
				tree.put(num[i], 1);
			}
		}
		
		System.out.println(tree);

	}

}
