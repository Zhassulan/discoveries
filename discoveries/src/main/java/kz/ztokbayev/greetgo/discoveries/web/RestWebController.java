package kz.ztokbayev.greetgo.discoveries.web;

import java.util.List;

import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import kz.ztokbayev.greetgo.discoveries.App;
import kz.ztokbayev.greetgo.discoveries.model.Discoverer;

@RestController
public class RestWebController {
		
	@RequestMapping(value = "discoverers.html/getdiscoverers", method = RequestMethod.GET)
	public Response getDiscoverers() {
		List<Discoverer> discoverers = App.dbmanager.GetAllDiscoverers();
		Response response = new Response("Done", discoverers);
		return response;
	}

	@RequestMapping(value = "discoverers.html/postdiscoverer", method = RequestMethod.POST,
			consumes="application/json", headers = {"content-type=text/plain"})
	public Response postDiscoverer(@RequestBody String jsonString) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Discoverer discoverer = objectMapper.readValue(jsonString, Discoverer.class);
			App.dbmanager.addDiscoverer(discoverer);
		}
		catch (Exception e)
		{
			System.err.println("Caught IOException: " + e.getMessage());
		}
	Response response = new Response("Done", null);
	return response;
	}
	
	@RequestMapping(value = "discoverers.html/deldiscoverer", method = RequestMethod.POST)
	public Response delDiscoverer(@RequestParam(value="id") Integer id) {
		App.dbmanager.delDiscovererById(id);
		Response response = new Response("Done", null);
		return response;
	}
	
	@RequestMapping(value = "discoverers.html/getdiscoverer", method = RequestMethod.GET)
	public Response getDiscovererById(@RequestParam(value="id") Integer id) {
		Discoverer discoverer = App.dbmanager.getDiscovererById(id);
		Response response = new Response("Done", discoverer);
		return response;
	}
}
