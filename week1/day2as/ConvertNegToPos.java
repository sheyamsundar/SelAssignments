package week1.day2as;

public class ConvertNegToPos {
	public int convertMethod(int negNum) {
		if(negNum < 0)
			negNum = -negNum;
		return negNum;

	}

	public static void main(String[] args) {
		int a = -100;
		ConvertNegToPos neg = new ConvertNegToPos();
		int result = neg.convertMethod(a);
		System.out.println("After converting negative number to positive: " +result);

	}

}
