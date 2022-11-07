package week1.day1as;

public class Mobile {
	String mobileBrand = "Samsung";
	char mobileLogo = 'S';
	short noOfMobiles = 5;
	int modelNum = 900;
	long imeiNum = 9876543210L;
	float mobilePrice = 59999.99f;
	boolean isDamaged = false;

	public static void main(String[] args) {
		Mobile mob = new Mobile();
		System.out.println(mob.mobileBrand);
		System.out.println(mob.mobileLogo);
		System.out.println(mob.modelNum);
		System.out.println(mob.imeiNum);
		System.out.println(mob.noOfMobiles);
		System.out.println(mob.mobilePrice);
		System.out.println(mob.isDamaged);

	}

}
