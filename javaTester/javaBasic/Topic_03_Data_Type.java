package javaBasic;

public class Topic_03_Data_Type {
	String address = "Ha Noi";

	public static void main(String[] args) {
		int a = 5;
		int b = a;
		
		System.out.println("Before = " + a);
		System.out.println("Before = " + b);
		
		b = 10;
		System.out.println("After = " + a);
		System.out.println("After = " + b);
	
		Topic_03_Data_Type firstTopic = new Topic_03_Data_Type();
		Topic_03_Data_Type secondTopic = new Topic_03_Data_Type();
	
		System.out.println("Before = " + firstTopic.address);
		System.out.println("Before = " + secondTopic.address);
		
		secondTopic.address = "Ho Chi Minh";
		
		System.out.println("After = " + firstTopic.address);
		System.out.println("After = " + secondTopic.address);
	}
}
