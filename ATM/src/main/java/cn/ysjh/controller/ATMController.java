package cn.ysjh.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import cn.ysjh.service.ATMService;

@Controller
public class ATMController {

	@Autowired
	private ATMService atmservice;
	@RequestMapping("list")
	public String list() {
		return "register";
		
	}
	@Autowired
	@RequestMapping("list1")
	public String list1() {
		return "redirect:/login.jsp";
		
	}
	@RequestMapping("register")
	public String register(@RequestParam("name")String name,@RequestParam("password")String password,Model model) {
		String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		atmservice.register(name, password,uuid);
		int balance=0;
		atmservice.account(uuid, balance);
		model.addAttribute("uuid", uuid);
		return "redirect:/hello.jsp";
	}
	@RequestMapping("login")
	public String login(@RequestParam("name")String name,@RequestParam("password")String password,Model model,HttpServletRequest request) {

		Integer test=atmservice.login(name, password);
		if(test==0) {
		
		 return "redirect:/fail.jsp";
		}
		String uuid=atmservice.get(name);
		 HttpSession session=request.getSession();
		session.setAttribute("uuid",uuid); 
		return "redirect:/input.jsp";
	}
	@RequestMapping("update")
	public String update(String password,HttpServletRequest request) {
		 HttpSession session=request.getSession();
		 String uuid=(String) session.getAttribute("uuid");
		atmservice.update(password,uuid);
		return "redirect:/modifyApw.jsp";
	}
	@RequestMapping("input")
	public String input(int num,HttpServletRequest request) {
		 HttpSession session=request.getSession();
		 String uuid=(String) session.getAttribute("uuid");
      atmservice.input(num,uuid);
		return "redirect:/input.jsp";
	}
	@RequestMapping("output")
	public String output(int num,HttpServletRequest request) {
		HttpSession session=request.getSession();
		 String uuid=(String) session.getAttribute("uuid");
		atmservice.output(num, uuid);
		return "redirect:/output.jsp";
	}
	@RequestMapping("trans")
	public String trans(String account,int money) {
		atmservice.input(money, account);
		return "redirect:/transferAccount.jsp";
	}
	@RequestMapping("balance")
	public String balance(HttpServletRequest request,Model model) {
		HttpSession session=request.getSession();
		 String uuid=(String) session.getAttribute("uuid");
		String balance=atmservice.balance(uuid);
		System.out.println(balance);
		model.addAttribute("money", balance);
		model.addAttribute("uuid", uuid);
		return "redirect:/query.jsp";
	}
}
