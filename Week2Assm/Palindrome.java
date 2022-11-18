package StringAssm;

public class Palindrome {

	public static void main(String[] args) {
		String str = "madam";
		String rev = "";
		int strLength = str.length();
	       for ( int i = (strLength - 1); i>=0;--i)
	       {
	         rev = rev + str.charAt(i);
	       }
	       if(str.toLowerCase().equals(rev.toLowerCase()))
	         System.out.println("Palindrome");
	        else
	          System.out.println("Not a palindrome");

	}

}
