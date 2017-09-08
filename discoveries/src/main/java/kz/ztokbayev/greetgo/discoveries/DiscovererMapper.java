package kz.ztokbayev.greetgo.discoveries;

import java.util.List;

import kz.ztokbayev.greetgo.discoveries.Discoverer;

public interface DiscovererMapper {
	
	Discoverer getDiscovererById(Integer id);
	List<Discoverer> getDiscoverers();
}
