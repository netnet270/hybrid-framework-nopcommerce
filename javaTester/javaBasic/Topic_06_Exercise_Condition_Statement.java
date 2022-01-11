package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_06_Exercise_Condition_Statement {
	Scanner scanner = new Scanner(System.in);

	@Test
	public void TC_01() {
		int n = scanner.nextInt();

		if (n % 2 == 0) {
			System.out.println("So " + n + " la so chan");
		} else {
			System.out.println("So " + n + " la so le");
		}

		scanner.close();
	}

	@Test
	public void TC_02() {
		System.out.println("Nhap:");
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		System.out.println(a >= b ? "a lon hon hoac bang b" : "a nho hon hoac bang b");

		scanner.close();
	}

	@Test
	public void TC_03() {
		System.out.println("Nhap:");
		String firstName = scanner.next();
		String secondtName = scanner.next();

		System.out.println(firstName.equals(secondtName) ? "2 nguoi la cung ten" : "2 nguoi la khac ten");

		scanner.close();
	}
	
	@Test
	public void TC_04() {
		System.out.println("Nhap:");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		int max = a;
		
		if ( b > max ) max = b;
		if ( c > max ) max = c;
		System.out.println(max);
		
		scanner.close();
	}
	
	@Test
	public void TC_05() {
		System.out.println("Nhap:");
		int a = scanner.nextInt();
		
		if ( 10 <= a && a <= 100 ) {			
			System.out.println(a + " nam trong [10, 100]");
		} else {
			System.out.println(a + " khong nam trong [10, 100]");
		}
		
		scanner.close();
	}
	
	@Test
	public void TC_06() {
		System.out.println("Nhap:");
		float point = scanner.nextFloat();
		String type = null;
		
		if( point >= 0 && point < 5) {
			type = "D";
		} else if( point >= 5 && point < 7.5) {
			type = "C";
		} else if( point >= 7.5 && point < 8.5) {
			type = "B";
		} else if( point >= 8.5 && point <= 10) {
			type = "A";
		} else {
			System.out.println("Ban vui long nhap lai");
		}

		System.out.println(type);
		scanner.close();
	}
	
	@Test
	public void TC_07() {
		System.out.println("Nhap:");
		int month = scanner.nextInt();
		int date;
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: {
			date = 31;
			break;
		}
		case 2: {
			date = 28;
			break;
		}
		default:
			date = 30;	
		}
		
		System.out.println(date);
		scanner.close();
	}
}
