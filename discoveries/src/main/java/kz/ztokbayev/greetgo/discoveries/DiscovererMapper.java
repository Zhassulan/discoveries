package kz.ztokbayev.greetgo.discoveries;

import java.util.List;
import kz.ztokbayev.greetgo.discoveries.Discoverer;

public interface DiscovererMapper {
	
	List<Discoverer> getDiscoverers();
	Discoverer getDiscovererById(Integer id);
	void updateDiscoverer(Discoverer dsc);
	void addDiscoverer(Discoverer dsc);
}
