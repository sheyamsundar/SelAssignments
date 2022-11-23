package System;

public class Desktop extends Computer {
	
	public void desktopSize() {
		String brand = "Dell";
		double size = 15.6;
		System.out.println("Brand: "+brand);
		System.out.println("Size: "+size);

	}

	public static void main(String[] args) {
		
		Desktop dt = new Desktop();
		dt.computerModel();
		dt.desktopSize();
		
	}

}
