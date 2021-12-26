package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_Exercise_Switch_Case {
	Scanner scanner = new Scanner(System.in);

	@Test
	public void TC_01() {
		int number = scanner.nextInt();
		
		switch (number) {
		case 1: {
			System.out.println("One");
			break;
		}
		case 2: {
			System.out.println("Two");
			break;
		}
		case 3: {
			System.out.println("Three");
			break;
		}
		case 4: {
			System.out.println("Four");
			break;
		}
		case 5: {
			System.out.println("Five");
			break;
		}
		case 6: {
			System.out.println("Six");
			break;
		}
		case 7: {
			System.out.println("Seven");
			break;
		}
		case 8: {
			System.out.println("Eight");
			break;
		}
		case 9: {
			System.out.println("Nine");
			break;
		}
		case 10: {
			System.out.println("Ten");
			break;
		}
		default:
			System.out.println("Nhap mot so trong khoang tu 1-10");
			break;		
		}
	}
	
	@Test
	public void TC_02() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String operator = scanner.next();
		
		switch (operator) {
		case "+": {
			System.out.println("A + B = " + ( a + b ));
			break;
		}
		case "-": {
			System.out.println("A - B = " + ( a - b ));
			break;
		}
		case "*": {
			System.out.println("A * B = " + ( a * b ));
			break;
		}
		case "/": {
			System.out.println("A / B = " + ( a / b ));
			break;
		}
		case "%": {
			System.out.println("A % B = " + ( a % b ));
			break;
		}
		default:
			System.out.println("Chi thuc hien phep toan +, -, *, /, %");
			break;		
		}
	}
	
	@Test
	public void TC_03() {
		int month = scanner.nextInt();
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: {
			System.out.println("Thang co 31 ngay");
			break;
		}
		case 2: {
			System.out.println("Thang co 28 hoac 29 ngay");
			break;
		}
		case 4:
		case 6:
		case 9:
		case 11: {
			System.out.println("Thang co 30 ngay");
			break;
		}
		default:
			System.out.println("Vui long nhap thang tu 1-12");
		}
	}
}
