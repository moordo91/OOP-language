import java.util.Arrays;

public class ArrayWorkHours {
	public static void main(String[] args) {
		int[][] hours = {
				{2,4,3,4,5,8,8},
				{7,3,4,3,3,4,4},
				{3,3,4,3,3,2,2},
				{9,3,4,7,3,4,1},
				{3,5,4,3,6,3,8},
				{3,4,4,6,3,4,4},
				{3,7,4,8,3,8,4},
				{6,3,5,9,2,7,9},
		};
		
		int[][] h_sum = new int[hours.length][2];
		
		for (int i = 0; i < hours.length; i++) {
			h_sum[i][0] = i;
			for(int j = 0; j < hours[i].length; j++)
				h_sum[i][1] += hours[i][j];
		}
		
		for (int i = 0; i < h_sum.length; i++) {
			int max_n = h_sum[i][0];
			int max_v = h_sum[i][1];
			int currentIndex = i;
			for (int j = i + 1; j < h_sum.length; j++)
				if (max_v < h_sum[j][1]) {
					max_n = h_sum[j][0];
					max_v = h_sum[j][1];
					currentIndex = j;
				}			
			
			if (currentIndex != i) {
				h_sum[currentIndex][0] = h_sum[i][0];
				h_sum[currentIndex][1] = h_sum[i][1];
				h_sum[i][0] = max_n;
				h_sum[i][1] = max_v;
			}
		}
		
		for(int i = 0; i < h_sum.length; i++)
			System.out.println("Employee " + h_sum[i][0] +
					": " + h_sum[i][1]);
	}
}