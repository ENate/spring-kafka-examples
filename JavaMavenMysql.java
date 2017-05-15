package de.nath.mysqlMaven;

//import java.sql.DriverManager;
//import java.sql.ResultSet;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class JavaMavenMysql {
	// enumeration of columns
	enum TestTableEnums{
		id,name;
	}

	private final String JdbcUrl;
	private final String JdbcDriverStr;

	// Connection, statement, prepared and result set initialization
	private Connection conn;
	private Statement stmt;
	private ResultSet rst;
	private PreparedStatement prdStmnt;

	//Define the constructor here
	public JavaMavenMysql(String JdbcUrl, String JdbcDriverStr){
		this.JdbcDriverStr = JdbcDriverStr;
		this.JdbcUrl = JdbcUrl;
	}
	
	// Read after connecting to the data base here:
	public void readData() throws Exception {
		try{
			Class.forName(JdbcDriverStr);
			conn = DriverManager.getConnection(JdbcUrl);
			stmt = conn.createStatement();
			rst = stmt.executeQuery("Select * from SHDatabase.user_name");
			getResultSet(rst);
			prdStmnt = conn.prepareStatement("insert into SHDatabase.user_name values (default,?)");
			 prdStmnt.setString(1,"Doncaster Ray");
			 prdStmnt.executeUpdate();
		}
		finally{
			close();
		}
	}
	private void getResultSet(ResultSet rst) throws Exception{
		while (rst.next()){
			Integer id = rst.getInt(TestTableEnums.id.toString());
			String text = rst.getString(TestTableEnums.name.toString());
			System.out.print("Field " + id + " is: " + id);
			System.out.print(" ");
			System.out.println("Name: "+ text);
		}
	}
	//close connections
	private void close(){
		try{
			if (rst != null) rst.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		}catch(Exception e){e.printStackTrace();}
	}
}
