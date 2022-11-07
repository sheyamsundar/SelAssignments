package week1.day1as;

public class GlobalVar1 {
	int noOfWheels = 2;
	short noOfMirrors = 2;
	long chassisNumber = 123456789L;
	boolean isPunctured = false;
	String bikeName = "Yamaha MT15";
	double runningKM = 5000.5;

	public static void main(String[] args) {
		GlobalVar1 bike = new GlobalVar1();
		System.out.println(bike.bikeName);
		System.out.println(bike.chassisNumber);
		System.out.println(bike.runningKM);
		System.out.println(bike.noOfWheels);
		System.out.println(bike.noOfMirrors);
		System.out.println(bike.isPunctured);
		

	}

}
