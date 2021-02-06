package fibonacci;

public class Fibonacci {
	
	public static int fibonacci(int n) {
		if(n<=1)return n;
		return fibonacci(n - 1)+fibonacci(n - 2);
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(fibonacci(40));
	}

}
