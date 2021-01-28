package fibonacci;

public class Fibonacci_g {

	public static int fibonacci(int n) {
		if(n <= 1)return n;
		int first = 0;
		int second = 1;
		for(int i = 0;i < n - 1;i++) {
			int sum = first + second;
			first = second;
			second = sum;
		}
		return second;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(fibonacci(40));
	}

}
