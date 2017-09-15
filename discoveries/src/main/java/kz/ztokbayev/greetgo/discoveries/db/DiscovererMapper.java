package kz.ztokbayev.greetgo.discoveries.db;

import java.util.List;

import org.apache.ibatis.annotations.*;

import kz.ztokbayev.greetgo.discoveries.model.Discoverer;

public interface DiscovererMapper {
	
	final String getAll = "select * from discoverers";
	final String getById = "select * from discoverers where ID = #{id}";
	final String update = "update discoverers set firstname = #{firstname}, lastname = #{lastname}, middlename = #{middlename} where id = #{id}";
	final String add = "insert into discoverers (firstname, lastname, middlename) values (#{firstname}, #{lastname}, #{middlename})";
	final String delById = "delete from discoverers where id = #{id}";
	
	@Select(getAll)
	
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="firstname", column="firstname"),
			@Result(property="lastname", column="lastname"),
			@Result(property="middlename", column="middlename")
	})
	List<Discoverer> getAll();
	
	@Select(getById)
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="firstname", column="firstname"),
			@Result(property="lastname", column="lastname"),
			@Result(property="middlename", column="middlename")
	})
	Discoverer getById(Integer id);
	
	@Update(update)
	void update(Discoverer discoverer);
	
	@Insert(add)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void add(Discoverer discoverer);
	
	@Delete(delById)
	void delById(Integer id);
	
}
