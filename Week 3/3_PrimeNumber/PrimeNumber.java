// 2���� 50���� ������ 10���� ��� ����ϴ� ���α׷�
// number = 2 �� ������ ���ʴ�� �Ҽ����� Ȯ���ϴ� ���Ʈ���� �˰����̴�.
// 	�� number�� ���Ͽ� isPrime = true, �� �Ҽ��� �����Ѵ�.
// 	�� number�� ���Ͽ� 2�������� number/2���� ���� ������ ������ �������� 0���� Ȯ���Ѵ�.
// 		�������� 0�� ���, isPrime�� false�� �ϰ� loop�� break�Ѵ�.
// 		�������� 0�̵Ǵ� ���� ���ٸ�, �켱 �Ҽ��� ������ count�� 1��ŭ �ø���. �׸���,
// 		  count % 10 != 0 �� ��� �״�� ����Ѵ�.
// 		  count % 10 == 0 �� ��� ����ϰ� �����Ѵ�.
// 	count < NUMBER_OF_PRIME�� ��� ��� �ݺ��Ѵ�.

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
