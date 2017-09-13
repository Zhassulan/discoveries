package kz.ztokbayev.greetgo.discoveries.web;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kz.ztokbayev.greetgo.discoveries.App;
import kz.ztokbayev.greetgo.discoveries.model.Discoverer;

@RestController
public class RestWebController {
	List<Discoverer> discoverers = null; 
	
	@RequestMapping(value = "discoverers.html/getdiscoverers", method = RequestMethod.GET)
	public Response getDiscoverers() {
		discoverers = App.dbmanager.GetAllDiscoverers();
		Response response = new Response("Done", discoverers);
		return response;
	}

	@RequestMapping(value = "discoverers.html/postdiscoverer", method = RequestMethod.POST,
			consumes="application/json")
	public String  postDiscoverer(@RequestBody String string) {
		//App.dbmanager.addDiscoverer(discoverer);
		return string;
	}
}
