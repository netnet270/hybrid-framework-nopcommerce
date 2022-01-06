package javaBasic;

public class Topic_11_Exercise_Object {
	String id, name;
	int age;
	Float score;
	
	public Topic_11_Exercise_Object(String id, String name, int age, Float score) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	public void displayed() {
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Score: " + score);
	}


	public static void main(String[] args) {
		Topic_11_Exercise_Object topic = new Topic_11_Exercise_Object("B121787", "Nguyen Van A", 25, 8.5f);
		topic.displayed();
	}
}
