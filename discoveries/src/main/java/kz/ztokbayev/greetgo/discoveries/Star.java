package kz.ztokbayev.greetgo.discoveries;

public class Star {
	
	private String title;
	private String classification;
	private int x;
	private int y;
	private Discoverer discoverer;
	
	public Star(String title, String classification, int x, int y, Discoverer discoverer) {
		super();
		this.title = title;
		this.classification = classification;
		this.x = x;
		this.y = y;
		this.discoverer = discoverer;
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
	public Discoverer getDiscoverer() {
		return discoverer;
	}
	public void setDiscoverer(Discoverer discoverer) {
		this.discoverer = discoverer;
	}
	
		
	
}
