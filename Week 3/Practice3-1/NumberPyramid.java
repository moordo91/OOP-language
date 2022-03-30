import java.util.Scanner;

public class NumberPyramid {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of lines: ");
		int n = input.nextInt();
		
		// n���� ������ �ݺ��ؼ� �Ƕ�̵带 ����.
		// �Ƕ�̵�� ������ n, �غ��� 2n-1�� ��ٸ��÷� ��Ÿ�� �� ����.
		// ������ ���� (����) + (�������� ����) + (�������� ����)�� ���¸� ����.
		for (int i=0; i<n; i++) { // i��° ���� ������
			for (int j=0; j<(n-1)-i; j++) // ������ (n-1)-i�� �ݺ���.
				System.out.print("   ");
			for (int j=0; j<i; j++) // �������� ������ ����� ���� �������� ���ʿ� i���� ���� ����.
				System.out.printf("%3d", i+1-j);
			for (int j=0; j<i+1; j++) // �������� ������ ����� ���� �����Ͽ� �����ʿ� i+1���� ���� ����
				System.out.printf("%3d", j+1);
			System.out.println(); // �Ƕ�̵� ���� �ٲ���
		}
	}
}
