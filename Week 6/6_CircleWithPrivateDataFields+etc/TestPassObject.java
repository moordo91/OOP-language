
public class TestPassObject {
	public static void main(String[] args) {
		CircleWithPrivateDataFields myCircle =
				new CircleWithPrivateDataFields();
		
		int n = 5;
		printAreas(myCircle, n);
		
		System.out.println("\n" + "Radius is " + myCircle.getRadius());
		System.out.println("n is " + n);
	}
	
	public static void printAreas(
			CircleWithPrivateDataFields c, int times) {
		System.out.println("Radius \t\tArea");
		while (times >= 1) {
			System.out.println(c.getRadius() + "\t\t" + c.getArea());
			c.setRadius(c.getRadius() + 1);
			times--;
		}
	}

	// Radius는 reference 전달: 영향을 받음
	// n은 value 전달: 영향을 받지 않음
}
