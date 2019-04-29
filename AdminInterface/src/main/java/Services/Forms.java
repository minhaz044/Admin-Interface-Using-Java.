package Services;

public class Forms {
	
	private String formsup= "<form>";
	private String formsdown= "<button type=\"submit\" class=\"btn btn-primary\">Submit</button></form>";
	
	public Forms(String METHOD,String action){
		formsup= "<form action=\"/"+ action+"\" method=\""+METHOD+"\">";
	}
			
			
	public void setTableName(String tableName,String id) {
	
		
	}
			
	public void varchar(String levelName, String type,String name,String value,String attribute) {
		char doubleQuote ='"';
		//System.out.println("************Form bFunction  Is Called**************");
		if(type.toLowerCase().equals("hidden")) {
			formsup+=" <input type=\"hidden\" id=\""+name+"\" name=\""+name+"\" value=\""+value+"\">";

		}else {
			
			formsup+=  "<div class="+doubleQuote+"form-group"+doubleQuote+">"
					 +"<label for="+doubleQuote+name+doubleQuote+">"+levelName+"</label>"
					 +"<input type="+doubleQuote+type+doubleQuote+"class="+doubleQuote+"form-control"
					 +doubleQuote+"id="+doubleQuote+name+doubleQuote+ "name="+doubleQuote+name+doubleQuote+ "value="+doubleQuote+value+doubleQuote+"aria-describedby="
					 +doubleQuote+"emailHelp"+doubleQuote+" placeholder="+doubleQuote+"Enter "+levelName+doubleQuote+" "+attribute+"></div>";
		}		 
	}
	public  void radio() {
		
	}
	public  void integer() {
		
	}
	public String getForm() {
		//System.out.println(formsup);
		return formsup+formsdown;
	}

}
