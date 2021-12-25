package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_04_Exercise_Operator {
	@Test
	public void TC_01() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap:");
		String name = scanner.next();
		int age = scanner.nextInt();

		System.out.println("After 15 years, age of " + name + " will be " + (age + 15));

		scanner.close();
	}

	@Test
	public void TC_02() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap:");
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		// C1: only use 2 variable
		a = a + b;
		b = a - b;
		a = a - b;

		// C2: use temporary variable
		int c = a;
		a = b;
		b = c;
		System.out.println("After swapping then a = " + a + ", b = " + b);

		scanner.close();
	}

	@Test
	public void TC_03() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap:");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		System.out.println(a > b ? true : false);
		scanner.close();
	}
}
