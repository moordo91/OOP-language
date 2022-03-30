import java.util.Scanner;

public class ScissorsRockPaper {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int iWin = 0; // �÷��̾ �̱� Ƚ�� ī����.
		int comWin = 0; // ��ǻ�Ͱ� �̱� Ƚ�� ī����.
		
		while (true) {
			
			// ��ǻ�Ͱ� ������ ���� ����.
			int comsHand = (int)(Math.random() * 3);
			if (comsHand == 0)
				System.out.println("computer is scissors.");
			else if (comsHand == 1)
				System.out.println("computer is rock.");
			else
				System.out.println("computer is paper");

			// �÷��̾ ������ ���� ����.
			System.out.print("scissor (0), rock (1), paper (2): ");
			int myHand = input.nextInt();
			
			// �÷��̾ �̱�� ���̽�
			if ((myHand == 1 && comsHand == 0) ||
				(myHand == 2 && comsHand == 1) ||
				(myHand == 0 && comsHand == 2)) {
				System.out.println("You won.");
				iWin++;
			}
			// �÷��̾ �й��ϴ� ���̽�
			else if ((comsHand == 1 && myHand == 0) ||
					 (comsHand == 2 && myHand == 1) ||
					 (comsHand == 0 && myHand == 2)) {
					 System.out.println("Computer won.");
					 comWin++;
			}
			// ���� ���
			else
				System.out.println("It's a draw.");
			
			if (Math.abs(iWin - comWin) >= 2)
				break;
		}
	
		System.out.println(((iWin > comWin) ? "You ":"Computer ") +
			"won more than two times.");
		
	}
}
