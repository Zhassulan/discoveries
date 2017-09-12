package kz.ztokbayev.greetgo.discoveries;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

@SpringBootApplication
public class App 
{
	final static Logger logger = Logger.getLogger(App.class);
	 
    public static void main( String[] args )
    {
		/*for (Classification cName : Classification.values()) {
			System.out.println(cName + ") " + cName.getValue());
		}*/

    	//System.out.println(new File("mybatis-config.xml").getAbsolutePath());
    	
		SqlSessionFactory sqlSessionFactory;
        DiscovererMapper discovererMapper;
        Reader reader = null;
        SqlSession session = null;
        
        try {
            reader = Resources.getResourceAsReader("static/xml/mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
           
            session = sqlSessionFactory.openSession();
            discovererMapper = session.getMapper(DiscovererMapper.class);
            List <Discoverer> discoverers = discovererMapper.getDiscoverers();
            //System.out.println("Firstname " + discoverers.get(0).getFirstname());
            Discoverer discoverer = discovererMapper.getDiscovererById(1);
            //System.out.println("Firstname " + discoverer.getFirstname());
            discoverer.setFirstname("Александр");
            //System.out.println(discoverer.getFirstname());
            //discovererMapper.updateDiscoverer(discoverer);
            Discoverer dsc = new Discoverer(0, "Георгий", "Авасян", "Мишелович");
            discovererMapper.addDiscoverer(dsc);
            session.commit();
            discoverer = discovererMapper.getDiscovererById(1);
            
            logger.info("Firstname " + discoverer.getFirstname());
            
            SpringApplication.run(App.class, args);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
        	 if (session != null) {
                 session.close();
             }
        }
    }
}
