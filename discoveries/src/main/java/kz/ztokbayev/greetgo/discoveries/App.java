package kz.ztokbayev.greetgo.discoveries;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
import java.io.File;
import java.net.URL;
import java.util.List;

public class App 
{
	//final static Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	//PropertyConfigurator.configure("/resources/log4j.properties");
    	//logger.info("Classification: " + Classification.id1);
    	
		/*for (Classification cName : Classification.values()) {
			System.out.println(cName + ") " + cName.getValue());
		}*/

    	//System.out.println(new File("mybatis-config.xml").getAbsolutePath());
    	
		SqlSessionFactory sqlSessionFactory;
        DiscovererMapper discovererMapper;
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            discovererMapper = sqlSessionFactory.openSession().getMapper(DiscovererMapper.class); //Создаем маппер, из которого и будем вызывать методы getSubscriberById и getSubscribers
            List <Discoverer> discoverers = discovererMapper.getDiscoverers();
            System.out.println("Firstname " + discoverers.get(0).getFirstname());
            Discoverer discoverer = discovererMapper.getDiscovererById(1);
            System.out.println("Firstname " + discoverer.getFirstname());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
