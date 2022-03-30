public class IsEmrip {
	public static void main(String[] args) {
		int number = 2;
		int count = 0;
		
		while (count < 120) {
			if (isPrime(number) && isPrime(IsPalindrome.reverse(number)) && !(IsPalindrome.isPalindrome(number))) {
				count++;
				
				if (count % 10 == 0)
					System.out.printf("%5d\n", number);
				else
					System.out.printf("%s5d", number);
				}	
			number++;
		}
	}
	
	public static boolean isPrime(int number) {
		for (int divisor = 2; divisor <= number / 2; divisor++) {
			if (number % divisor ==0) {
				return false;
			}
		}
		return true;
	}
}
