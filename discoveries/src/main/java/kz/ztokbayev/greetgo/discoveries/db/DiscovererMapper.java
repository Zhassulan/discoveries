package kz.ztokbayev.greetgo.discoveries.db;

import java.util.List;

import org.apache.ibatis.annotations.*;

import kz.ztokbayev.greetgo.discoveries.model.Discoverer;

public interface DiscovererMapper {
	
	final String getAll = "select * from discoverers";
	
	@Select(getAll)
	
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="firstname", column="firstname"),
			@Result(property="lastname", column="lastname"),
			@Result(property="middlename", column="middlename")
	})
	List<Discoverer> getAllDiscoverers();

	Discoverer getDiscovererById(Integer id);
	void updateDiscoverer(Discoverer dsc);
	void addDiscoverer(Discoverer dsc);
	void delDiscovererById(Integer id);
	
}
