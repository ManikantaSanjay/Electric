import java.sql.*;
import java.io.*;

public class Connect
{
	Connection con;
	Statement stat;
	ResultSet rs;
	public Connect()
	{
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con = DriverManager.getConnection("jdbc:odbc:KSEB","sa","");
		stat = con.createStatement();
		}catch(Exception ex){System.out.println("COnnect class 1:" +ex);}
	}
	public Connection getConnect()
	{
		return con;
	}
	public ResultSet getRecords(String query)
	{
		try{
		ResultSet rs =stat.executeQuery(query);
		}catch(Exception ex){System.out.println("COnnect class 2:"+ ex);}
		return rs;
	}
	
}