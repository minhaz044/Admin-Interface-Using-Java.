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
	private String created_at;
	private String updated_at;
	private static Connection connection = null;
	static {
		try {
			connection = DBController.getConnection();
			System.out.println("From Static Block "+connection);
		}catch(Exception e) {
			System.out.println("\"Error :@Users.Static: ");
			log.error("Error :@Users.Static: "+ e);

		}
	
	}
	public Users get(int id){
		return null;
		
	}
	public static Users get(String userName,String password){
		if(connection!=null){
			try {
				
				String query="EXEC spUsersGetUser @userName='"+userName+"',@password='"+password+"'";
				Statement s = connection.createStatement();
				ResultSet result=s.executeQuery(query);
				System.out.println(result.getFetchSize());
					Users u=new Users();
					System.out.println("Out");
					while (result.next()) {
						System.out.println("Is in result");
						u.id = Integer.parseInt(result.getString("id"));
						u.userName = result.getString("userName");
						u.password=result.getString("password");
						u.created_at = result.getString("created_at");
						u.updated_at = result.getString("updated_at");
						return u;
					}
					return null;
				
			}catch(Exception e) {
				log.error("Error : @Users.Get(?,?)"+e);
				return null;
			}
		}else {
			log.info("Connection is not Studlished");
			return null;
		}
		

		

		
	}

	
	

}
