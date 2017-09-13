package kz.ztokbayev.greetgo.discoveries.db;

import java.util.List;
import kz.ztokbayev.greetgo.discoveries.model.Star;

public interface StarMapper {
	List<Star> getStars();
	Star getStarById(Integer id);
	void updateStar(Star dsc);
	void addStar(Star dsc);
	void delDStarById(Integer id);
}
