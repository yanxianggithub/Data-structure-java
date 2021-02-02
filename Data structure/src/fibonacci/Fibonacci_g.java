package fibonacci;

public class Fibonacci_g {

	public static int fibonacci(int n) {
		if(n <= 1)return n;
		int first = 0;
		int second = 1;
		while(n-- > 1) {
			second += first;
			first = second - first;
		}
		return second;
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(fibonacci(40));
	}

}
