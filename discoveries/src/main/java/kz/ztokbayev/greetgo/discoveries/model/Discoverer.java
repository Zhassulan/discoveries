package kz.ztokbayev.greetgo.discoveries.model;

public class Discoverer {
	
	
	private Integer id;
	private String firstname;
	private String lastname;
	private String middlename;
	
	public Discoverer()	{
		
	}
			
	public Discoverer(Integer id, String firstname, String lastname, String middlename) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;
	}
	
	public Discoverer(String firstname, String lastname, String middlename) {
		super();
		this.id = 0;
		this.firstname = firstname;
		this.lastname = lastname;
		this.middlename = middlename;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
}
