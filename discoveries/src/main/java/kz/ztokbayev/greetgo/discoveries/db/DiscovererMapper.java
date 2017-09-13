package kz.ztokbayev.greetgo.discoveries.db;

import java.util.List;

import kz.ztokbayev.greetgo.discoveries.model.Discoverer;

public interface DiscovererMapper {
	
	List<Discoverer> getDiscoverers();
	Discoverer getDiscovererById(Integer id);
	void updateDiscoverer(Discoverer dsc);
	void addDiscoverer(Discoverer dsc);
	void delDiscovererById(Integer id);
	
}
