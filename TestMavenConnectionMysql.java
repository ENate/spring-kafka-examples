package de.nath.mysqlMaven;

public class TestMavenConnectionMysql {	
		// Define the driver and the connection string
		public static final String jdbc_driver = "com.mysql.jdbc.Driver";
		//public static final String jdbc_url = "jdbc:mysql://192.168.0.104:3306/SHDatabase"
            //    +"?user=nate&password=natlucy";
		public static String dbName = "SHDatabase";
		public static String dbUserName = "root";
		public static final String dbPassword = "natlucy1";
		public static final String jdbc_url = "jdbc:mysql://localhost/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
		// Define object of mysql class, call the appropriate methods
		public static void main(String[] args)  throws Exception{
		JavaMavenMysql dao = new JavaMavenMysql(jdbc_url, jdbc_driver);
		dao.readData();
		
	}

}
