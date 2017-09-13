package kz.ztokbayev.greetgo.discoveries.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kz.ztokbayev.greetgo.discoveries.model.Discoverer;
import kz.ztokbayev.greetgo.discoveries.model.Star;

import java.io.Reader;
import java.util.List;

public class DatabaseManager {
	
	private static SqlSessionFactory sqlSessionFactory;
	private static DiscovererMapper discovererMapper;
	private static StarMapper starMapper;
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
	
	public void delDiscovererById(Integer id)	{
		try(SqlSession session = sqlSessionFactory.openSession()) {
			discovererMapper = session.getMapper(DiscovererMapper.class);
			discovererMapper.delDiscovererById(id);
			session.commit();
		}
	}
	
	public Discoverer getDiscovererById(Integer id)	{
		Discoverer discoverer;
		try(SqlSession session = sqlSessionFactory.openSession()) {
			discovererMapper = session.getMapper(DiscovererMapper.class);
			discoverer = discovererMapper.getDiscovererById(id); 
		}
		return discoverer;
	}
	
	public void updateDiscoverer(Discoverer discoverer)	{
		try(SqlSession session = sqlSessionFactory.openSession()) {
			discovererMapper = session.getMapper(DiscovererMapper.class);
			discovererMapper.updateDiscoverer(discoverer);
			session.commit();
		}
	}
	
	public List <Star> GetStars()	{
		List <Star> stars;
		try(SqlSession session = sqlSessionFactory.openSession()) {
			starMapper = session.getMapper(StarMapper.class);
			stars = starMapper.getStars();
		}
       return stars;
	}
}
