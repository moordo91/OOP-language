public class PassByValue {
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 2;
		
		System.out.println("Before invoking the swap method,");
		System.out.println("\tnum1 = " + num1);
		System.out.println("\tnum2 = " + num2);
		System.out.println();
		
		swap(num1, num2);
		
		System.out.println("After invoking the swap method,");
		System.out.println("\tnum1 = " + num1);
		System.out.println("\tnum2 = " + num2);
		
	}
	
	public static void swap(int x, int y) {
		System.out.println("\tInside the swap method");
		System.out.println("\t\tBefore swapping,");
		System.out.println("\t\tnum1 = " + x);
		System.out.println("\t\tnum2 = " + y);
		System.out.println();
		
		int temp = x;
		x = y;
		y = temp;
		
		System.out.println("\t\tBefore swapping,");
		System.out.println("\t\tnum1 = " + x);
		System.out.println("\t\tnum2 = " + y);
		System.out.println();
	}
}
