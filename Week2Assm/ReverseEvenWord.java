package StringAssm;

public class ReverseEvenWord {

	public static void main(String[] args) {
		String str = "I am a software tester"; 
		String[] t = str.split(" ");

		String val = "";
		for (int i = 0; i < t.length; i++) 
        {
    		if (i % 2 != 0)
        		val = val + new StringBuilder(t[i]).reverse().toString() + " ";
    		else
        		val = val + t[i] + " ";
		}
		val = val.trim();
		System.out.println(val);

	}

}
