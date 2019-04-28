package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import Services.DBController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TableSchema {

	public static ResultSet getAllTableName() {
		try {
			Connection connection = DBController.getConnection();
			if (connection != null) {
				String query = "SELECT * FROM INFORMATION_SCHEMA.TABLES";
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(query);
				// connection.close();
				return result;
			}

		} catch (Exception e) {
			log.error("Tables @getAll @Connection " + e);
			return null;
		}
		return null;
	}

	public static ResultSet getAllColumnName(String tableName) {
		try {
			Connection connection = DBController.getConnection();
			if (connection != null) {
				String query = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='" + tableName
						+ "' AND TABLE_CATALOG='DEV_TEST'";
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(query);
				// connection.close();
				return result;
			}

		} catch (Exception e) {
			log.error("Tables @getAll @Connection " + e);
			return null;
		}
		return null;
	}

	public static ResultSet getAllColumnInfo(String tableName) {
		try {
			Connection connection = DBController.getConnection();
			if (connection != null) {
				String query = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS where TABLE_NAME='" + tableName
						+ "' AND TABLE_CATALOG='DEV_TEST'";
				// System.out.println("Query:"+query);
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(query);
				// System.out.println("The Result is: "+result.getString("COLUMN_NAME"));
				// connection.close();
				return result;
			}

		} catch (Exception e) {
			log.error("Tables @getAll @Connection " + e);
			return null;
		}
		return null;
	}

	public static ResultSet getAllData(String tableName) {

		try {
			Connection connection = DBController.getConnection();
			if (connection != null) {
				// System.out.println("Table Name:"+ tableName );
				String query = "SELECT * FROM  " + tableName;
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(query);

				return result;
			}

		} catch (Exception e) {
			log.error("Tables @getAll @Connection " + e);
			return null;
		}
		return null;
	}

	public static ResultSet get(String tableName, String id) {

		try {
			Connection connection = DBController.getConnection();
			if (connection != null) {
				ResultSet columnName = getAllColumnName(tableName);
				System.out.println("*******Name" + tableName);
				if (columnName.next()) {
					String query = "SELECT * FROM  " + tableName + " WHERE " + columnName.getString("COLUMN_NAME")
							+ "='" + id + "'";
					// System.out.println(query);
					Statement statement = connection.createStatement();
					ResultSet result = statement.executeQuery(query);
					/*
					 * if(result.next()) { System.out.println(result.getString("password")); }else {
					 * System.out.println("wRONG"); }
					 */

					return result;
				}

			}

		} catch (Exception e) {
			log.error("Tables @getAll @Connection " + e);
			return null;
		}
		return null;
	}

	public static Boolean update(String tableName, ArrayList<String> index, ArrayList<String> data) {

		int length=data.size();
		if ( length>0 && index.size() == length) {

			try {
				Connection connection = DBController.getConnection();
				if (connection != null) {
					 String query="UPDATE "+tableName +" SET ";
					 for(int i=1;i<length;i++) {
						 query+=index.get(i)+"='"+data.get(i).trim()+"' , ";
					 }
					 query=query.substring(0, query.length()-2);
					 query+="WHERE "+index.get(0)+"='"+data.get(0)+"'";
						
					 System.out.println(query); 
					 Statement statement=connection.createStatement();
					 int result=statement.executeUpdate(query);
					 if(result>0) {
						 return true;
					 }
					 	 
				}

			} catch (Exception e) {
				log.error("Tables @update @Connection " + e);

			}

		} else {
			log.info("Data and Index are not Same: Upadate Failed:try Again  ");

		}

		return false;

	}

}
