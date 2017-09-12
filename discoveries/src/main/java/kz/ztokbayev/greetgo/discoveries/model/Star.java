package kz.ztokbayev.greetgo.discoveries.model;

public class Star {
	
	private Integer id;
	private String title;
	private String classification;
	private int x;
	private int y;
	
	public Star(Integer id, String title, String classification, int x, int y) {
		super();
		this.id = id;
		this.title = title;
		this.classification = classification;
		this.x = x;
		this.y = y;
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
}
