package utilities;

import com.github.javafaker.Faker;

public class DataUtil {
	Faker faker = new Faker();
	
	public static DataUtil getDataHelper() {
		return new DataUtil();
	}
	
	public String getFirstName() {
		return faker.name().firstName();
	}
	
	public String getLastName() {
		return faker.name().lastName();
	}
	
	public String getPassword() {
		return faker.internet().password();
	}
	
	public String getEmail() {
		return faker.internet().emailAddress();
	}
}
