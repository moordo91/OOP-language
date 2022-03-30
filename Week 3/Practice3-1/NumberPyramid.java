import java.util.Scanner;

public class NumberPyramid {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of lines: ");
		int n = input.nextInt();
		
		// n개의 라인을 반복해서 피라미드를 형성.
		// 피라미드는 윗변이 n, 밑변이 2n-1인 사다리꼴로 나타낼 수 있음.
		// 각각의 행은 (공백) + (내림차순 수열) + (오름차순 수열)의 형태를 지님.
		for (int i=0; i<n; i++) { // i번째 행을 생성함
			for (int j=0; j<(n-1)-i; j++) // 공백은 (n-1)-i번 반복됨.
				System.out.print("   ");
			for (int j=0; j<i; j++) // 내림차순 수열은 정가운데 열을 기준으로 왼쪽에 i개의 항을 가짐.
				System.out.printf("%3d", i+1-j);
			for (int j=0; j<i+1; j++) // 오름차순 수열은 정가운데 열을 포함하여 오른쪽에 i+1개의 항을 가짐
				System.out.printf("%3d", j+1);
			System.out.println(); // 피라미드 행을 바꿔줌
		}
	}
}
