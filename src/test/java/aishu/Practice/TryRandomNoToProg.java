package aishu.Practice;

import java.util.Random;

public class TryRandomNoToProg {

	public static void main(String[] args) {
		Random ran = new Random();
		int random = ran.nextInt(200);
		System.out.println(random);
		
		int c = TryRandomNoToProg.check(random,54);
		System.out.println(c);
	}
	public static int check(int a,int b)
	{
		int c=a+b;
		return c;
		
	}
}
