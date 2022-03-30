import java.util.Scanner;

public class SubtractionQuizLoop {
	public static void main(String[] args) {
		final int N_OF_Qs = 5;
		int correctCount = 0;
		int count = 0;
		long startTime = System.currentTimeMillis();
		String output = "";
		Scanner input = new Scanner(System.in);
		
		while (count < N_OF_Qs) {
			int n1 = (int)(Math.random() * 10);
			int n2 = (int)(Math.random() * 10);
			
			if (n1 < n2) {
				int temp = n1;
				n1 = n2;
				n2 = temp;
			}
			
			System.out.print(
					"What is " + n1 + " - " + n2 + "? ");
			int ans = input.nextInt();
			
			if (n1 - n2 == ans) {
				System.out.println("You're correct!\n");
				correctCount++;
			}
			
			else {
				System.out.println(
					"Your answer is wrong.\n" + 
					n1 + " - " + n2 + " should be "
					+ (n1 - n2) + "\n");
			}
			count++;
			output += "\n" + n1 + " - " + n2 + " = " + ans +
					((n1-n2==ans) ? " correct" : " wrong");
		}
		long endTime = System.currentTimeMillis();
		long testTime = endTime - startTime;
		
		System.out.println("Correct count is " + correctCount 
			+ "\nTest time is " + testTime / 1000 
			+ " seconds\n" + output);
	}
}
