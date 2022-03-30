import java.util.Scanner;

public class ScissorsRockPaper {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int iWin = 0; // 플레이어가 이긴 횟수 카운팅.
		int comWin = 0; // 컴퓨터가 이긴 횟수 카운팅.
		
		while (true) {
			
			// 컴퓨터가 무엇을 낼지 결정.
			int comsHand = (int)(Math.random() * 3);
			if (comsHand == 0)
				System.out.println("computer is scissors.");
			else if (comsHand == 1)
				System.out.println("computer is rock.");
			else
				System.out.println("computer is paper");

			// 플레이어가 무엇을 낼지 결정.
			System.out.print("scissor (0), rock (1), paper (2): ");
			int myHand = input.nextInt();
			
			// 플레이어가 이기는 케이스
			if ((myHand == 1 && comsHand == 0) ||
				(myHand == 2 && comsHand == 1) ||
				(myHand == 0 && comsHand == 2)) {
				System.out.println("You won.");
				iWin++;
			}
			// 플레이어가 패배하는 케이스
			else if ((comsHand == 1 && myHand == 0) ||
					 (comsHand == 2 && myHand == 1) ||
					 (comsHand == 0 && myHand == 2)) {
					 System.out.println("Computer won.");
					 comWin++;
			}
			// 비기는 경우
			else
				System.out.println("It's a draw.");
			
			if (Math.abs(iWin - comWin) >= 2)
				break;
		}
	
		System.out.println(((iWin > comWin) ? "You ":"Computer ") +
			"won more than two times.");
		
	}
}
