import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("Enter the number of array: ");
		int n = input.nextInt();
		double[] myList = new double[n];
		System.out.print("Enter elements of the array: ");
		for (int i = 0; i < n; i++) {
			myList[i] = input.nextDouble();
		}
		selectionSort(myList);
		System.out.println(Arrays.toString(myList));
	}
	
	
	public static void selectionSort(double[] list) {
		for (int i = 0; i <list.length; i++) {	
			double currentMin = list[i];
			int currentMinIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
	}
}
