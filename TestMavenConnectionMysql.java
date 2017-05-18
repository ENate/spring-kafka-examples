package de.packagename.mysqlMaven;

public class TestMavenConnectionMysql {	
		// Define the driver and the connection string
		public static final String jdbc_driver = "com.mysql.jdbc.Driver";
		//public static final String jdbc_url = "jdbc:mysql://hostIP/dbasename"
            //    +"?user=username&password=password";
		public static String dbName = "SHDatabase";
		public static String dbUserName = "username";
		public static final String dbPassword = "password";
		public static final String jdbc_url = "dbase location" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
		// Define object of mysql class, call the appropriate methods
		public static void main(String[] args)  throws Exception{
		JavaMavenMysql dao = new JavaMavenMysql(jdbc_url, jdbc_driver);
		dao.readData();
		
	}

}
