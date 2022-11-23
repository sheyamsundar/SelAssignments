package College;

public class Student extends Department{
	
	public void studentName(String name) {
		System.out.println("Name: "+name);

	}
	
	public void studentDept(String studept) {
		System.out.println("Student Dept: "+studept);

	}
	
	public void studentID(int id) {
		System.out.println("Student ID: "+id);

	}

	public static void main(String[] args) {
		
		Student st = new Student();
		st.studentID(64);
		st.studentName("S. Sheyam Sundar");
		st.studentDept("IT");
		st.deptName("Information Technology");
		st.collegeName("Adhiyamaan College of Engineering");
		st.collegeCode(2100);
		st.collegeRank(55);

	}

}
