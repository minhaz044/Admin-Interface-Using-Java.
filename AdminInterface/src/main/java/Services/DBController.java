package Services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBController {
	private static Connection DBcon=null;
	public static Connection getConnection() throws Exception{
		if(/*DBcon==null*/ 1==1){
			String url="jdbc:sqlserver://vNTDACWSSQLD002:1433;databaseName=DEV_TEST";
			String userName="dev_test_dbo";
			String password="dev_test_dbo123";
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 DBcon=DriverManager.getConnection(url, userName, password);
			return DBcon;
		}
			else {
				return  DBcon;
		}
			
		}
	
	
	
	
	}
	
	
	


