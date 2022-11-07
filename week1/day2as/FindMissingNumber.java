package week1.day2as;

public class FindMissingNumber {

	public static void main(String[] args) {
		int[] arr = {3, 1, 5, 2, 6, 8, 7};
		int n = arr.length;
		int sum, missingNum, temp = 0, arrSum = 0;
		for (int i=0;i<n;i++)
		{
			for (int j=i+1;j<n;j++)
			{
				if(arr[j]<arr[i])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j]=temp;
				}
			}
		}
		sum = (n*(n+1))/2;
		for(int i = 0; i < n; i++)
		{
			arrSum = arrSum + arr[i]; 
		}
		System.out.println("Sum of the sequential numbers: "+sum);
		System.out.println("Total sum of the array elements: "+arrSum);
		missingNum = arrSum - sum;
		System.out.println("Missing number in the given series:" +missingNum);
	}

}
