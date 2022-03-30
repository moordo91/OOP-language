import java.util.Arrays;
import java.util.Scanner;

public class QsortFirstStep {
	public static int partition(int[] list) {
		int p = 0;
		int t = 0;
		int lm = 0 + 1;
		int rm = list.length - 1;
		while (rm >= lm) {
			while ((list[lm] <= list[p]) && (lm <= rm)) {
				lm++;
			}
			while ((list[rm] >= list[p]) && (rm >= lm)) {
				rm--;
			}
			if (lm > rm) {
				t = list[rm];
				list[rm] = list[p];
				list[p] = t;
				p = rm;
			}
			else {
				t = list[lm];
				list[lm] = list[rm];
				list[rm] = t;
			}
		}
		return p;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
		int n = input.nextInt();
		
		int[] myList = new int[n];
		System.out.print("Enter a list: ");
		for (int i = 0; i < n; i++) {
			myList[i] = input.nextInt();
		}
		
		partition(myList);
		
		System.out.println();
		System.out.print("After the partition, the list is: ");
		for (int i = 0; i < n; i++)
			System.out.print(myList[i] + " ");
	}
}
