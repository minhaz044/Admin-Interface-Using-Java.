package Services;

public class Forms {
	
	private String formsup= "<form>";
	private String formsdown= "<button type=\"submit\" class=\"btn btn-primary\">Submit</button></form>";
	

			
			
			
			
	public void varchar(String levelName, String type,String name,String value) {
		char doubleQuote ='"';
		System.out.println("************Form bFunction  Is Called**************");
		formsup+=  "<div class="+doubleQuote+"form-group"+doubleQuote+">"
				 +"<label for="+doubleQuote+name+doubleQuote+">"+levelName+"</label>"
				 +"<input type="+doubleQuote+type+doubleQuote+"class="+doubleQuote+"form-control"
				 +doubleQuote+"id="+doubleQuote+name+doubleQuote+ "value="+doubleQuote+value+doubleQuote+"aria-describedby="
				 +doubleQuote+"emailHelp"+doubleQuote+" placeholder="+doubleQuote+"Enter email"+doubleQuote+"></div>";
		System.out.println(formsup);
				 
	}
	public  void radio() {
		
	}
	public  void integer() {
		
	}
	public String getForm() {
		System.out.println(formsup);
		return formsup+formsdown;
	}

}
