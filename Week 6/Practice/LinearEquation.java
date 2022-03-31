import java.util.Scanner;

public class LinearEquation {
	private double a, b, c, d, e, f;
	
	public LinearEquation(
			double a, double b, double c, double d, double e, double f) {
		this.a = a; this.b = b; this.c = c;
		this.d = d; this.e = e; this.f = f;
	}
	
	public double getA() {
		return a;
	}
	public double getB() {
		return b;
	}
	public double getC() {
		return c;
	}
	public double getD() {
		return d;
	}
	public double getE() {
		return e;
	}
	public double getF() {
		return f;
	}
	
	public boolean isSolvable() {
		return a*d-b*c != 0 ? true : false ;
	}

	public String getX() {
		if (isSolvable())
			return "" + (e*d-b*f)/(a*d-b*c);
		else
			return "F";
	}
	
	public String getY() {
		if (isSolvable())
			return "" + (a*f-e*c)/(a*d-b*c);
		else
			return "F";
	}
	
	public void solveProblem() {
		if (!this.isSolvable())
			System.out.println("the equation has no solution");
		else {
			System.out.println("x = " + this.getX());
			System.out.println("y = " + this.getY());
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double[] p = new double[6];
		System.out.println("Input parameters a b c d e f: ");
		for (int i = 0; i < 6; i++)
			p[i] = input.nextDouble();
		
		LinearEquation eqs = 
				new LinearEquation(p[0], p[1], p[2], p[3], p[4], p[5]);
		
		eqs.solveProblem();
	}
}
