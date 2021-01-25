package clock;

public class Clock {
	Display display = new Display();
	public void start() {
		while(true) {
			display.show();
			display.increase();
		}
	}
	public static void main(String[] args) {
		Clock clock = new Clock();
		clock.start();
	}

}
