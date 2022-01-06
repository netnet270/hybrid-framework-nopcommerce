package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_Exercise_While_Do_While {
	Scanner scanner = new Scanner(System.in);

	@Test
	public void TC_01_For() {
		int n = scanner.nextInt();

		for (int i = n; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}

	}

	@Test
	public void TC_01_While() {
		int n = scanner.nextInt();

		int i = n;
		while (n <= 100) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
			i++;
		}
	}

	@Test
	public void TC_02_For() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		for (int i = a; i <= b; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println(i);
			}
		}
	}

	@Test
	public void TC_02_While() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		int i = a;
		while (i <= b) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println(i);
			}
			i++;
		}
	}

	@Test
	public void TC_03() {
		int n = scanner.nextInt();
		int sum = 0;

		int i = n;
		while (i > 0) {
			if (i % 2 != 0) {
				sum += i;
			}
			i--;
		}
		System.out.println(sum);
	}

	@Test
	public void TC_04() {
		int n = scanner.nextInt();

		int i = n;
		while (i > 0) {
			if (i % 3 == 0) {
				System.out.println(i);
			}
			i++;
		}
	}

	@Test
	public void TC_05() {
		int n = scanner.nextInt();
		int giaithua = 1;

		int i = n;
		while (i > 0) {
			giaithua *= i;
			i--;
		}
		System.out.println(giaithua);
	}

	@Test
	public void TC_06() {
		int sum = 0;

		int i = 1;
		while (i <= 10) {
			if (i % 2 == 0) {
				sum += i;
			}
			i++;
		}
		System.out.println(sum);
	}
}
