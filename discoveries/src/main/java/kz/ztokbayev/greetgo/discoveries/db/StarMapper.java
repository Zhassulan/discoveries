package kz.ztokbayev.greetgo.discoveries.db;

import java.util.List;
import kz.ztokbayev.greetgo.discoveries.model.Star;

public interface StarMapper {
	List<Star> getStars();
	Star getStarById(Integer id);
	void updateStar(Star star);
	void addStar(Star star);
	void delDStarById(Integer id);
	//ss
}
