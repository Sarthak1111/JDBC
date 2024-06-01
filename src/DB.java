import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DB {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host="localhost";
		String port="3306";

		Connection con= DriverManager.getConnection("jdbc:mysql://"+ host +":"+ port +"/Qadb", "root","saru");
		Statement s= con.createStatement();
		ResultSet rs= s.executeQuery("Select * from Employee where location='abc2'");
		while (rs.next()) {
	        System.setProperty("webdriver.chrome.driver","D:\\webdrivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

			WebDriver driver= new ChromeDriver();
			driver.get("https://login.salesforce.com/?locale=eu");
			
			String data= rs.getString("name");
			System.out.println(data);
			
			//just to fetch data from db without hardcoding
			driver.findElement(By.id("username")).sendKeys(rs.getString("name"));
			driver.findElement(By.id("password")).sendKeys(rs.getString("location"));
			
		}
		
	}

}
