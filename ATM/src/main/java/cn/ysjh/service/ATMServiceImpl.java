package cn.ysjh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ysjh.dao.ATMMapper;

@Service
public class ATMServiceImpl implements ATMService{

	@Autowired
	private ATMMapper atmmapper;
	public void register(String name, String password,String uuid) {
		atmmapper.register(name, password,uuid);
	}
	public Integer login(String name, String password) {
		
		return atmmapper.login(name, password);
	}
	public void account(String uuid, int balance) {
		atmmapper.account(uuid, balance);
		
	}
	public void input(int num,String uuid) {
		atmmapper.input(num,uuid);
		
	}
	public String get(String name) {
		
		return atmmapper.get(name);
	}
	public void output(int num, String uuid) {
		atmmapper.output(num, uuid);
		
	}
	public void update(String password,String uuid) {
		atmmapper.update(password,uuid);
		
	}
	public String balance(String uuid) {
		return atmmapper.balance(uuid);
		
	}

	
}
