package kz.ztokbayev.greetgo.discoveries.model;

//Reference
public enum Classification {
	id1("голубая"), id2("бело-голубая"), id3("белая"), id4("жёлто-белая"), 
	id5("жёлтая"), id6("оранжевая"), id7("оранжевая");
	
	private String value;
	
	private Classification(String value)	{
		this.value = value;
	}
	
	public String getValue()	{
		return value; 
	}
}
