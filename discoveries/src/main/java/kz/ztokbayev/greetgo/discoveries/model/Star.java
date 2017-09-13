package kz.ztokbayev.greetgo.discoveries.model;

public class Star {
	
	private Integer id;
	private String title;
	private String classification;
	private int x;
	private int y;
	private Integer id_discoverer;
	
	public Star()	{
		
	}
	
	public Star(Integer id, String title, String classification, Integer x, Integer y, Integer id_discoverer) {
		super();
		this.id = id;
		this.title = title;
		this.classification = classification;
		this.x = x;
		this.y = y;
		this.id_discoverer = id_discoverer;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public Integer getId_discoverer() {
		return id_discoverer;
	}

	public void setId_discoverer(Integer id_discoverer) {
		this.id_discoverer = id_discoverer;
	}	
	
	
}
