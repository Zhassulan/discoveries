package kz.ztokbayev.greetgo.discoveries.model;

public class Discoveries {
	
	private Integer id;
	private Discoverer discoverer;
	private Star star;
	
	public Discoveries (Integer id, Discoverer discoverer, Star star)	{
		this.id = id;
		this.discoverer = discoverer;
		this.star = star;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Discoverer getDiscoverer() {
		return discoverer;
	}

	public void setDiscoverer(Discoverer discoverer) {
		this.discoverer = discoverer;
	}

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}
	
	
}
