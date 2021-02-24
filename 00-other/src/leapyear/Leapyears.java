package leapyear;

import java.util.Scanner;

public class Leapyears {

	public int isleapyear(int year) {
		int isleapyear = 0;
		if(year % 4 == 0) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					isleapyear = 1;
				}
			}
			isleapyear = 1;
		}
		return isleapyear;
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Scanner in = new Scanner(System.in);
		Leapyears y = new Leapyears();
		System.out.println("请输入年份：");
		int i = in.nextInt();
		if(y.isleapyear(i) == 1)
			System.out.printf("%d是闰年。",i);
		else System.out.printf("%d不是闰年。",i);
		in.close();
	}
}
