package kz.ztokbayev.greetgo.discoveries.web;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import kz.ztokbayev.greetgo.discoveries.model.Discoverer;
import kz.ztokbayev.greetgo.discoveries.App;
import kz.ztokbayev.greetgo.discoveries.db.DatabaseManager;
import kz.ztokbayev.greetgo.discoveries.model.Star;

@RestController
public class RestWebController {
		
	private DatabaseManager dbmanager = new DatabaseManager();
	
	@RequestMapping(value = "discoverers.html/getdiscoverers", method = RequestMethod.GET)
	public Response getDiscoverers() {
		//List<Discoverer> discoverers = dbmanager.GetAllDiscoverers();
		List<Discoverer> discoverers = dbmanager.GetAllDiscoverers();
		Response response = new Response("Done", discoverers);
		return response;
	}

	@RequestMapping(value = "discoverers.html/postdiscoverer", method = RequestMethod.POST,
			consumes="application/json", headers = {"content-type=text/plain"})
	public Response postDiscoverer(@RequestBody String jsonString) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Discoverer discoverer = objectMapper.readValue(jsonString, Discoverer.class);
			dbmanager.addDiscoverer(discoverer);
		}
		catch (Exception ex)
			{
				App.logger.info("Error message: " + ex.getMessage());
				App.logger.error("Stack trace: ", ex);
			}
	Response response = new Response("Done", null);
	return response;
	}
	
	@RequestMapping(value = "discoverers.html/deldiscoverer", method = RequestMethod.POST)
	public Response delDiscoverer(@RequestParam(value="id") Integer id) {
		dbmanager.delDiscovererById(id);
		Response response = new Response("Done", null);
		return response;
	}
	
	@RequestMapping(value = "discoverers.html/getdiscoverer", method = RequestMethod.GET)
	public Response getDiscovererById(@RequestParam(value="id") Integer id) {
		Discoverer discoverer = dbmanager.getDiscovererById(id);
		Response response = new Response("Done", discoverer);
		return response;
	}
	
	@RequestMapping(value = "discoverers.html/updatediscoverer", method = RequestMethod.POST,
			consumes="application/json", headers = {"content-type=text/plain"})
	public Response updateDiscoverer(@RequestBody String jsonString) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Discoverer discoverer = objectMapper.readValue(jsonString, Discoverer.class);
			dbmanager.update(discoverer);
		}
		catch (Exception ex)
		{
			App.logger.info("Error message: " + ex.getMessage());
			App.logger.error("Stack trace: ", ex);
		}
	Response response = new Response("Done", null);
	return response;
	}
	
	@RequestMapping(value = "/getstars", method = RequestMethod.GET)
	public Response getStars() {
		List<Star> stars = dbmanager.GetStars();
		Response response = new Response("Done", stars);
		return response;
	}
}
