import java.util.Scanner;

public class MultipleEachNum {
	public static void main(String[] args) {
		
		// 임의의 수 입력 받기.
		System.out.print("Enter an integer between 0 and 1000: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		// 잘못된 입력일 경우
		if (n < 0 || n >= 1000) {
			System.out.println("Invalid input.");
		}
		
		// 올바른 입력일 경우		
		else {
			// 각 자릿수 계산
			int n_100 = (n-n%100) / 100;
			int n_10 = (n-n%10)%100 / 10;
			int n_1 = n % 10;
			
			if (n >= 100) {
				int ans = n_100 * n_10 * n_1;
				System.out.print("The multiplication of all digits in " + n + " is " + ans);
			}
			else if (n >= 10) {
				int ans = n_10 * n_1;
				System.out.print("The multiplication of all digits in " + n + " is " + ans);
			}
			else {
				System.out.print("The multiplication of all digits in " + n + " is " + n);
			}
		}
	}
}
