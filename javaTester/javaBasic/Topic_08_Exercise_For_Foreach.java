package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_Exercise_For_Foreach {
	Scanner scanner = new Scanner(System.in);

	@Test
	public void TC_01() {
		int n = scanner.nextInt();

		for(int i = 1; i <= n; i++) {
			System.out.print(i+ " ");
		}
		
		System.out.print("\n");
	}
	
	@Test
	public void TC_02() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		for(int i = a; i <= b; i++) {
			System.out.print(i+ " ");
		}
		
		System.out.print("\n");
	}
	
	@Test
	public void TC_03() {
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) {	
				sum += i;
			}
		}		
		System.out.println(sum);
	}
	
	@Test
	public void TC_04() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();		
		int sum = 0;
		
		for(int i = a; i <= b; i++) {
			sum += i;
		}		
		System.out.println(sum);
	}
	
	@Test
	public void TC_05() {
		int n = scanner.nextInt();	
		int sum = 0;
		
		for(int i = 0; i <= n; i++) {
			if(i % 2 != 0) {	
				sum += i;
			}
		}		
		System.out.println(sum);
	}
	
	@Test
	public void TC_06() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();	
		
		for(int i = a; i <= b; i++) {
			if(i % 3 == 0) {	
				System.out.print(i+ " ");
			}
		}
		System.out.print("\n");
	}
	
	@Test
	public void TC_07() {
		int n = scanner.nextInt();
		int giaithua = 1;
		
		for(int i = 1; i <= n; i++) {
			giaithua *= i;
		}
		System.out.println(giaithua);
	}
}
