package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Services.DBController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
@NoArgsConstructor
@Getter
@Setter
@Slf4j
public class Users {
	private Integer id; 
	private String userName;
	private String password;
	//private String created_at;
	//private String updated_at;
	private String type;
	//private static Connection connection = null;
	public static ResultSet getAll(){
		
		try {
			Connection connection =DBController.getConnection();
			if(connection !=null) {
				String query="EXEC spusers_GetAll ";
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
	
	
	
	public Users get(int id){
		return null;
		
	}
	public static Users get(String userName,String password){
		try {
			Connection connection = DBController.getConnection();
			System.out.println("From Static Block "+connection);
			if(connection!=null){

					String query="EXEC spUsersGetUser @userName='"+userName+"',@password='"+password+"'";
					System.out.println(query);
					Statement s = connection.createStatement();
					ResultSet result=s.executeQuery(query);
					//System.out.println(result.getFetchSize());
						Users u=new Users();
						System.out.println("Out");
						while (result.next()) {
							System.out.println("Is in result");
							u.id = Integer.parseInt(result.getString("id"));
							u.userName = result.getString("userName");
							u.password=result.getString("password");
							u.type=result.getString("type");
							//connection.close();
							return u;
						}
						return null;
					
		
			}
			
		}catch(Exception e) {
			
			log.error("Users@ get @Connection : "+ e);
			return null;

		}
		
	return null;
		
	}

	
	

}
