import java.util.Scanner;

public class RepeatAdditionQuiz {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n1 = (int)(Math.random() * 10);
		int n2 = (int)(Math.random() * 10);
		
		System.out.print(
				"What is " + n1 + " + " + n2 + "? ");
		int answer = input.nextInt();
		
		while (answer != n1 + n2) {
			System.out.print(
					"Wrong answer. Try agin. What is "
					+ n1 + " + " + n2 + "? ");
			answer = input.nextInt();			
		}
		
		System.out.println("You got it!");
	}
}
