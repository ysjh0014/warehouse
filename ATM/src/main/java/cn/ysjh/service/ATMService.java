package cn.ysjh.service;

public interface ATMService {

	public void register(String name,String password,String uuid);
	public void account(String uuid,int balance);
	public Integer login(String name,String password);
	public String get(String name);
	public void update(String password,String uuid);
	public String balance(String uuid);
	public void input(int num,String uuid);
	public void output(int num,String uuid);
}
