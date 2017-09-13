package kz.ztokbayev.greetgo.discoveries.web;

import java.util.List;

import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

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
			consumes="application/json", headers = {"content-type=text/plain"})
	public String postDiscoverer(@RequestBody String jsonString) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Discoverer discoverer = objectMapper.readValue(jsonString, Discoverer.class);
			App.dbmanager.addDiscoverer(discoverer);
		}
		catch (Exception e)
		{
			System.err.println("Caught IOException: " + e.getMessage());
		}
		return jsonString;
	}
}
