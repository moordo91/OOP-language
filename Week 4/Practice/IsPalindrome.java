import java.util.Scanner;

public class IsPalindrome {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		
		if (isPalindrome(number))
			System.out.println(number + " is a palindrome number.");
		else
			System.out.println(number + " is not a palindrome number.");
	}
	
	
	public static int reverse(int number) {
		int result = 0;
		while (number != 0) {
			result = result * 10 + number % 10;
			number /= 10;
		}
		return result;
	}
	
	public static boolean isPalindrome(int number) {
		if (number == reverse(number))
			return true;
		else
			return false;
	}
}
