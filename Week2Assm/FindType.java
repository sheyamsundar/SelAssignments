package StringAssm;

public class FindType {

	public static void main(String[] args) {
		String test = "$$ Welcome to 2nd Class of Automation $$ ";
		int  letter = 0, space = 0, num = 0, specialChar = 0;
		char[] testArray = test.toCharArray();
		for(int i =0 ; i< testArray.length; i++) {
			if(Character.isDigit(testArray[i]))
			{
				num++;
			}
			else if(Character.isLetter(testArray[i])) {
				
				letter++;
			}
			else if(Character.isSpaceChar(testArray[i])) {
				space++;
			}
			else
				specialChar++;
				
		}
		System.out.println("No. of letters: "+letter);
		System.out.println("No. of spaces: "+space);
		System.out.println("No. of digits: "+num);
		System.out.println("No. of special characters: "+specialChar);

	}

}
