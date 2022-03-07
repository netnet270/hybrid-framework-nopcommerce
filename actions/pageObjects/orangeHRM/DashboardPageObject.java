package pageObjects.orangeHRM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.MySQLConnection;

public class DashboardPageObject extends BasePage {
	WebDriver driver;

	public DashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public int getEmployeeListNumberUI() {
		// wait Employee List Visiable
		// Get size Employee List
		return 18;
	}

	public int getEmployeeListNumberDB() throws SQLException {
		List<String> listNumber = new ArrayList<String>();
		String sql = "SELECT * FROM EMPLOYEE";
		Connection conn = null;
		
		try {
			conn = MySQLConnection.getMySQLConnection();
			System.out.println("Opened connection: "+ conn);

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				listNumber.add(rs.getString("FIRST_NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
		return listNumber.size();
	}
}
