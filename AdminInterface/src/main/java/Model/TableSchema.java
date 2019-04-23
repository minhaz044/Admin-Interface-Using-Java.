package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Services.DBController;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class TableSchema {

	public static ResultSet getAllTableName() {
		try {
			Connection connection =DBController.getConnection();
			if(connection !=null) {
				String query="SELECT * FROM INFORMATION_SCHEMA.TABLES";
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
	
	
	public static ResultSet getAllColumnName(String tableName) {
		try {
			Connection connection =DBController.getConnection();
			if(connection !=null) {
String query="SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='"+tableName+"' AND TABLE_CATALOG='DEV_TEST'" ;
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
	
	public static ResultSet getAllData(String tableName) {
		System.out.println("getAllData Function Called");
		try {
			Connection connection =DBController.getConnection();
			if(connection !=null) {
				//System.out.println("Table Name:"+ tableName );
				String query="SELECT * FROM  "+tableName ;
				Statement statement=connection.createStatement();
				ResultSet result=statement.executeQuery(query);
			
				return result;
			}
			
		}catch(Exception e) {
			log.error("Tables @getAll @Connection "+e);
			return null;
		}
		return null;
	}		
	
}


