package Studentinfo;

public class Students {
	
	public void getStudentInfo(int id) {
		System.out.println("Student ID (with id arg alone):" +id);

	}
	
	public void getStudentInfo(int id, String name) {
		System.out.println("Student ID (with id and name args):" +id);
		System.out.println("Student Name: "+name);

	}
	
	public void getStudentInfo(String email, long phoneNum) {
		System.out.println("Student email id (with email id and phone number args):" +email);
		System.out.println("Student phone number: "+phoneNum);

	}
	

	public static void main(String[] args) {
		
		Students stObj = new Students();
		stObj.getStudentInfo(64);
		stObj.getStudentInfo(64, "Sheyam");
		stObj.getStudentInfo("sundarsheyam@gmail.com", 9876543210L);

	}

}
