package kz.ztokbayev.greetgo.discoveries;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWebController {
	List<Discoverer> cust = new ArrayList<Discoverer>();

	@RequestMapping(value = "/getalldiscoverers", method = RequestMethod.GET)
	public Response getResource() {
		Response response = new Response("Done", cust);
		return response;
	}

	@RequestMapping(value = "/postdiscoverer", method = RequestMethod.POST)
	public Response postCustomer(@RequestBody Discoverer discoverer) {
		cust.add(discoverer);
		// Create Response Object
		Response response = new Response("Done", discoverer);
		return response;
	}
}
