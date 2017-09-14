package kz.ztokbayev.greetgo.discoveries;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kz.ztokbayev.greetgo.discoveries.db.DatabaseManager;

@SpringBootApplication
public class App 
{
	public static Logger logger = Logger.getLogger(App.class);
	public static DatabaseManager dbmanager = new DatabaseManager();
	
	
    public static void main( String[] args )
    {
		/*for (Classification cName : Classification.values()) {
			System.out.println(cName + ") " + cName.getValue());
		}*/
        //logger.info("Firstname " + discoverers.get(0).getFirstname());
            
        //Discoverer discoverer = discovererMapper.getDiscovererById(1);
        //System.out.println("Firstname " + discoverer.getFirstname());
        //discoverer.setFirstname("Александр");
        //System.out.println(discoverer.getFirstname());
        //discovererMapper.updateDiscoverer(discoverer);
        //Discoverer dsc = new Discoverer(0, "Георгий", "Авасян", "Мишелович");
        //discovererMapper.addDiscoverer(dsc);
        //session.commit();
        //discoverer = discovererMapper.getDiscovererById(1);
        
        //logger.info("Firstname " + discoverer.getFirstname());
        
        SpringApplication.run(App.class, args);

        //dbmanager.CloseSession();
        }
}
