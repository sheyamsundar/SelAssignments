package Bank;

public class AxisBank extends BankInfo{
	
	@Override
	public void deposit(int dp) {
		System.out.println("Deposited amount in Axis Bank: "+dp);
	}

	public static void main(String[] args) {
		
		AxisBank axis = new AxisBank();
		axis.saving(165700.65);
		axis.fixed(50000);
		axis.deposit(10000);

	}

}
