package cn.ysjh.dao;

import org.apache.ibatis.annotations.Param;

public interface ATMMapper {

	public void register(@Param("name")String name,@Param("password")String password,@Param("uuid")String uuid);
	public void account(@Param("uuid")String uuid,@Param("balance")int balance);
	public Integer login(@Param("name")String name,@Param("password")String password);
	public String get(String name);
	public void update(@Param("password")String password,@Param("uuid")String uuid);
	public String balance(String uuid);
	public void input(@Param("num")int num,@Param("uuid")String uuid);
	public void output(@Param("num")int num,@Param("uuid")String uuid);
}
