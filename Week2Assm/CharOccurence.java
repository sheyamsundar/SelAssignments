package StringAssm;

public class CharOccurence {

	public static void main(String[] args) {
		String str = "Welcome to Chennai";
		int count = 0;
	      for(int i = 0; i < str.length(); i++)
	      {
	        if(str.charAt(i) == 'e')
	          count = count + 1;
	      }
	      System.out.println(count);

	}

}
