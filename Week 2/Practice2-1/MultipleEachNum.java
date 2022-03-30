import java.util.Scanner;

public class MultipleEachNum {
	public static void main(String[] args) {
		
		// ������ �� �Է� �ޱ�.
		System.out.print("Enter an integer between 0 and 1000: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		// �߸��� �Է��� ���
		if (n < 0 || n >= 1000) {
			System.out.println("Invalid input.");
		}
		
		// �ùٸ� �Է��� ���		
		else {
			// �� �ڸ��� ���
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
