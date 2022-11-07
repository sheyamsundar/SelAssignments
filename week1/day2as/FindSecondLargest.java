package week1.day2as;

public class FindSecondLargest {
	
	public static void main(String[] args) {
		
		int[] arr1 = {3, 2, 11, 4, 6, 7};
		int temp = 0, n = arr1.length;
		for (int i=0;i<arr1.length;i++)
		{
			for (int j=i+1;j<arr1.length;j++)
			{
				if(arr1[j]<arr1[i])
				{
					temp = arr1[i];
					arr1[i] = arr1[j];
					arr1[j]=temp;
				}
			}
		}
		System.out.println("Array after sorting in ascending order\n");
		for(int i = 0; i<arr1.length;i++)
		{
			System.out.println(arr1[i]);
		}
		
		System.out.println("Second largest number in the array: " +arr1[n-2]);
	}

}
