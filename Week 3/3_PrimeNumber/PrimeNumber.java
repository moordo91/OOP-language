// 2부터 50개의 정수를 10개씩 끊어서 출력하는 프로그램
// number = 2 일 때부터 차례대로 소수임을 확인하는 브루트포스 알고리즘이다.
// 	각 number에 대하여 isPrime = true, 즉 소수로 가정한다.
// 	각 number에 대하여 2에서부터 number/2까지 수로 일일이 나누어 나머지가 0인지 확인한다.
// 		나머지가 0일 경우, isPrime을 false로 하고 loop를 break한다.
// 		나머지가 0이되는 수가 없다면, 우선 소수의 개수인 count를 1만큼 늘린다. 그리고,
// 		  count % 10 != 0 일 경우 그대로 출력한다.
// 		  count % 10 == 0 일 경우 출력하고 개행한다.
// 	count < NUMBER_OF_PRIME인 경우 계속 반복한다.

public class PrimeNumber {
	public static void main(String[] args) {
	    final int NUMBER_OF_PRIMES = 50;
	    final int NUMBER_OF_PRIMES_PER_LINE = 10;
	    int count = 0;
	    int number = 2;
	    
	    System.out.println("The first 50 prime numbers are \n");
	    
	    while (count < NUMBER_OF_PRIMES) {
	    	boolean isPrime = true;
	    	
	    	for (int divisor = 2; divisor <= number/2; divisor++) {
	    		if (number % divisor == 0) {
	    			isPrime = false;
	    			break;
	    		}
	    	}
	    	
	    	if (isPrime) {
	    		count++;
	    		
	    		if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
	    			System.out.printf("%3d\n", number);
	    		}
	    		else
	    			System.out.printf("%3d ", number);
	    	}
	    	
	    	number++;
	    }
	}
}
