package kz.ztokbayev.greetgo.discoveries.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kz.ztokbayev.greetgo.discoveries.model.Discoverer;

import java.io.Reader;
import java.util.List;

public class DatabaseManager {
	
	private static SqlSessionFactory sqlSessionFactory;
	private static DiscovererMapper discovererMapper;
	private static Reader reader = null;
    
	static {
		try {
			reader = Resources.getResourceAsReader("static/xml/mybatis-config.xml");
	        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}
		catch	(Exception e)
		{
		e.printStackTrace();	
		}
	}
	
	public List <Discoverer> GetAllDiscoverers()	{
		List <Discoverer> discoverers;
		try(SqlSession session = sqlSessionFactory.openSession()) {
			discovererMapper = session.getMapper(DiscovererMapper.class);
	        discoverers = discovererMapper.getDiscoverers();
		}
       return discoverers;
	}
	
	public void addDiscoverer(Discoverer discoverer)	{
		try(SqlSession session = sqlSessionFactory.openSession()) {
			discovererMapper = session.getMapper(DiscovererMapper.class);
			discovererMapper.addDiscoverer(discoverer);
			session.commit();
		}
	}
	
}
