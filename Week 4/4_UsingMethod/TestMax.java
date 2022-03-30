public class TestMax {
	public static void main(String[] args) {
		int i = 4;
		int j = 19;
		
		System.out.println(max(i, j) + 
				" is larger than the other.");
				
	}
	
	public static int max(int a, int b) {
		if (a > b) return a;
		else return b;
	}
}
