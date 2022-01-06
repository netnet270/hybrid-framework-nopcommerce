package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_12_String {
	Scanner scanner = new Scanner(System.in);

	@Test
	public void TC_05() {
		String str = scanner.nextLine();
		int count = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				count++;
			}
		}
		System.out.println(count);
	}
	
	@Test
	public void TC_02() {
		String str = "Automation Testing 345 Tutorials Online 789";
		int countCharA = 0;
		int countNumber = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a') {
				countCharA++;
			}
			if(str.charAt(i) <= '9' && str.charAt(i) >= '0') {
				countNumber++;
			}
		}
		System.out.println("So luong ky tu 'a' = " + countCharA);
		System.out.println("Kiem tra chuoi co chua tu 'Testing' hay khong = " + str.contains("Testing"));
		System.out.println("Kiem tra chuoi co bat dau bang tu 'Automation' hay khong = " + str.startsWith("Automation"));
		System.out.println("Kiem tra chuoi co ket thuc bang tu 'Online' hay khong = " + str.endsWith("Online"));
		System.out.println("Vi tri cua tu 'Tutorials' co trong chuoi = " + str.indexOf("Tutorials"));
		System.out.println("Thay the 'Online' bang 'Offline' = " + str.replace("Online", "Offline"));
		System.out.println("So luong ky tu la so trong chuoi = " + countNumber);
	}

	@Test
	public void TC_03() {
		String str = scanner.nextLine();
		String reverse = "";
		
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse+= str.charAt(i);
		}
		System.out.println(reverse);
	}
}
