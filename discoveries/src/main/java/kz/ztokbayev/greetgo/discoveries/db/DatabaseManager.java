package kz.ztokbayev.greetgo.discoveries.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kz.ztokbayev.greetgo.discoveries.App;
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
		catch	(Exception ex)
		{
			App.logger.info("Error message: " + ex.getMessage());
			App.logger.error("Stack trace: ", ex);
		}
	}
	
	public DatabaseManager()	{
		Initialize();
	}
	
	public void Initialize()	{
		try(SqlSession session = sqlSessionFactory.openSession()) {
			reader = Resources.getResourceAsReader("static/sql/schema.sql");
			ScriptRunner runner = new ScriptRunner(session.getConnection());
			runner.setLogWriter(null);
			runner.setErrorLogWriter(null);
			runner.runScript(reader);
			session.commit();
			reader.close();
			App.logger.info("Database is initialized.");
			}
			catch	(Exception ex)
			{
				App.logger.info("Error message: " + ex.getMessage());
				App.logger.error("Stack trace: ", ex);
			}
	}
	
	public List<Discoverer> GetAllDiscoverers()	{
		List <Discoverer> discoverers = null;
		try	(SqlSession session = sqlSessionFactory.openSession())	{
			//session.getConfiguration().addMapper(DiscovererMapper.class);
			discovererMapper = session.getMapper(DiscovererMapper.class);
			discoverers = discovererMapper.getAll();
		}
		catch	(Exception ex)
		{
			App.logger.info("Error message: " + ex.getMessage());
			App.logger.error("Stack trace: ", ex);
		}	
		return discoverers;
	}
	
	public void addDiscoverer(Discoverer discoverer)	{
		try(SqlSession session = sqlSessionFactory.openSession()) {
			discovererMapper = session.getMapper(DiscovererMapper.class);
			discovererMapper.add(discoverer);
			session.commit();
		}
		catch	(Exception ex)
		{
			App.logger.info("Error message: " + ex.getMessage());
			App.logger.error("Stack trace: ", ex);
		}
	}
	
	public void delDiscovererById(Integer id)	{
		try(SqlSession session = sqlSessionFactory.openSession()) {
			discovererMapper = session.getMapper(DiscovererMapper.class);
			discovererMapper.delById(id);
			session.commit();
		}
		catch	(Exception ex)
		{
			App.logger.info("Error message: " + ex.getMessage());
			App.logger.error("Stack trace: ", ex);
		}
	}
	
	public Discoverer getDiscovererById(Integer id)	{
		Discoverer discoverer = null;
		try(SqlSession session = sqlSessionFactory.openSession()) {
			discovererMapper = session.getMapper(DiscovererMapper.class);
			discoverer = discovererMapper.getById(id); 
		}
		catch	(Exception ex)
		{
			App.logger.info("Error message: " + ex.getMessage());
			App.logger.error("Stack trace: ", ex);
		}
		return discoverer;
	}
	
	public void update(Discoverer discoverer)	{
		try(SqlSession session = sqlSessionFactory.openSession()) {
			discovererMapper = session.getMapper(DiscovererMapper.class);
			discovererMapper.update(discoverer);
			session.commit();
		}
		catch	(Exception ex)
		{
			App.logger.info("Error message: " + ex.getMessage());
			App.logger.error("Stack trace: ", ex);
		}
	}
	
	public List <Star> GetStars()	{
		List <Star> stars = null;
		try(SqlSession session = sqlSessionFactory.openSession()) {
			starMapper = session.getMapper(StarMapper.class);
			stars = starMapper.getStars();
		}
		catch	(Exception ex)
		{
			App.logger.info("Error message: " + ex.getMessage());
			App.logger.error("Stack trace: ", ex);
		}
       return stars;
	}
}
