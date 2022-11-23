package Day2;

import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3,1, 10, 4, 5, 6, 8, 9, 10, 2, 5, 4, 9, 6,3};
		
		Set<Integer> num = new TreeSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			num.add(nums[i]);
		}
		System.out.println("Set Values: "+num);
		for(int i = 1; i < num.size(); i++) {
			if(!num.contains(i)) {
				System.out.println("Missing Number: "+i);
			}
		}

	}

}
