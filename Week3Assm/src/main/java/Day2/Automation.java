package Day2;

public class Automation extends MultipleLanguage implements Language, TestTool{

	public static void main(String[] args) {
		
		Automation obj = new Automation();
		obj.javaMethod();
		obj.seleniumMethod();
		obj.python("Calling the Implemented method in Abstract class");
		obj.ruby();
		

	}

	public void seleniumMethod() {
		System.out.println("Selenium method in the TestTool interface implemented");
		
	}

	public void javaMethod() {
		System.out.println("Java method in the Language interface implemented");
		
	}

	@Override
	public void ruby() {
		System.out.println("Calling the UnImplemented method in Abstract class");
		
	}

}
