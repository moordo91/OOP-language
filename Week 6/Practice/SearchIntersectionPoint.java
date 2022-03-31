import java.util.Scanner;

public class SearchIntersectionPoint {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] point = new double[4];
		double[][] pm = new double[2][3];
		
		System.out.print("Input x1 y1 x2 y2: ");
		for (int i = 0; i < 4; i++)
			point[i] = input.nextDouble();
		pm[0] = findLine(point[0], point[1], point[2], point[3]);
		
		System.out.print("Input x3 y3 x4 y4: ");
		for (int i = 0; i < 4; i++)
			point[i] = input.nextDouble();
		pm[1] = findLine(point[0], point[1], point[2], point[3]);
		

		LinearEquation eqs =
				new LinearEquation(pm[0][0], pm[0][1], pm[1][0], pm[1][1], pm[0][2], pm[1][2]);
		
		eqs.solveProblem();
	}
	
	public static double[] findLine(double x1, double y1, double x2, double y2) {
		double p = y2 - y1;
		double q = x1 - x2;
		double r = x1*y2 - x2*y1;
		double[] pm = {p, q, r};
		return pm;
	}	
		
}
