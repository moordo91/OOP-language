/* 브루트 포스로 구현한 최대공약수*/
import java.util.Scanner;

public class GreastCommonDivisior {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
		int n1 = input.nextInt();
		System.out.print("Enter second integer: ");
		int n2 = input.nextInt();
		
		int gcd = 1;
		int k = 2;
		while (k <= n1 && k <= n2) {
			if (n1 % k == 0 && n2 % k == 0)
				gcd = k;
			k++;
		}
		
		System.out.println("the greatest common divisior for "
				+ n1 + " and " + n2 + " is " + gcd);
	}
}
