package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Services.DBController;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Getter
public class Tables {
	
private int id;
private String name;
private int active ;
private String created_at;


public static ResultSet getAll() {
	 
	try {
		Connection connection =DBController.getConnection();
		if(connection !=null) {
			String query="EXEC spTablesGetAll ";
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery(query);
			//connection.close();
			return result;
		}
		
	}catch(Exception e) {
		log.error("Tables @getAll @Connection "+e);
		return null;
	}
	return null;
	


}


	
	

}
