import java.util.Scanner;

public class DetermineTriangle {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three edges (length in double): ");
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		
		if (a+b<=c || b+c<=a || c+a<=b) {
			System.out.println("Input is invalid");
		}
		
		else {
			System.out.println("The perimeter is " + (a+b+c));
		}
	}
}
