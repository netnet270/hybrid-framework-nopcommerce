package javaBasic;

import org.testng.annotations.Test;

public class Topic_11_Exercise_Array {

	@Test
	public void TC_01() {
		int arr[] = { 2, 7, 6, 8, 9 };
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}

		System.out.println(max);
	}

	@Test
	public void TC_02() {
		int arr[] = { 2, 7, 6, 8, 9 };
		System.out.println(arr[0] + arr[arr.length - 1]);
	}

	@Test
	public void TC_03() {
		int arr[] = { 2, 7, 6, 8, 9, 16, 17, 20 };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0)
				System.out.println(arr[i]);
		}
	}

	@Test
	public void TC_04() {
		int arr[] = { 3, -7, 2, 5, 9, -6, 10, 12 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0 && arr[i] > 0)
				sum += arr[i];
		}
		System.out.println(sum);
	}
	
	@Test
	public void TC_05() {
		int arr[] = { 3, -7, 2, 5, 9, -6, 10, 12 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0 && arr[i] <= 10)
				System.out.println(arr[i]);
		}
	}
	
	@Test
	public void TC_06() {
		int arr[] = { 3, 5, 7, 30, 10, 5, 8, 23, 0, -5 };
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+= arr[i];
		}
		
		System.out.println("SUM = " + sum);
		System.out.println("TBC = " + sum/arr.length);
	}
}
