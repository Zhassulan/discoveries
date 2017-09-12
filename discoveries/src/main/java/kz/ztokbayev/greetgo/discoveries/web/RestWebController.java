package kz.ztokbayev.greetgo.discoveries.web;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sun.media.jfxmedia.logging.Logger;

import kz.ztokbayev.greetgo.discoveries.App;
import kz.ztokbayev.greetgo.discoveries.model.Discoverer;

@RestController
public class RestWebController {
	List<Discoverer> discoverers = null; 
	
	@RequestMapping(value = "/getalldiscoverers", method = RequestMethod.GET)
	public Response getResource() {
		discoverers = App.dbmanager.GetAllDiscoverers();
		Response response = new Response("Done", discoverers);
		return response;
	}

	@RequestMapping(value = "/postdiscoverer", method = RequestMethod.POST)
	public Response postCustomer(@RequestBody Discoverer discoverer) {
		discoverers.add(discoverer);
		// Create Response Object
		Response response = new Response("Done", discoverer);
		return response;
	}
}
