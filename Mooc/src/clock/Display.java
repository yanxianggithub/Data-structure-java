package clock;

import java.util.Calendar;

public class Display {
	private int second = 0;
	private int minute = 0;
	private int hour = 0;
	private static int limit = 60;

	public Display() {
		Calendar c = Calendar.getInstance();
		
		this.hour = c.get(Calendar.HOUR_OF_DAY);
		this.minute = c.get(Calendar.MINUTE);
		this.second = c.get(Calendar.SECOND);
	}

	public void increase() {
		second++;
		if(second == limit) {
			second = 0;
			minute++;
			if(minute == limit) {
				minute = 0;
				hour++;
				if(hour == 24) {
					hour = 0;
				}
			}
		}
	}
	
	public void show() {
		System.out.printf("%02d:%02d:%02d\n",hour,minute,second);
	}
	
	public static void main(String[] args) {
		Display d = new Display();
		d.show();
	}

}
