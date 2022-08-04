package com.hanul.laundry.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanul.laundry.command.kkbAnlocationCommand;



@Controller
public class kkbAnController {

	@RequestMapping(value="/anBookmark", method = {RequestMethod.GET, RequestMethod.POST} )
	public String anBookmark(HttpServletRequest req, Model model, kkbAnlocationCommand command) {
		System.out.println("anBookmark()");
		
		//1. �ȵ���̵忡�� ���� ���� req�� �޾Ƽ� ������ ����
		String userid = (String) req.getParameter("userid");	
		String storeid = (String)req.getParameter("storeid");
		String lc = (String)req.getParameter("lc");
		

		
		//2. �ѹ� ����
		System.out.println(userid);
		System.out.println(storeid);
		System.out.println(lc);
		
		
		
		//3. command ���� ����ϱ� ���� model�� ����
				model.addAttribute("userid", userid);
				model.addAttribute("storeid", storeid);
				model.addAttribute("lc", lc);
				
				//4. AnJoinCommand�� �����ؼ� �𵨿� ��� �����͸� �Ѱ��ش�
				command = new kkbAnlocationCommand();
				command.execute(model);
				
				//11. ������ ���� views���� anJoin.jsp�� ã�� �����Ѵ�.
				return "anBookmark";
		
		//3. command ���� ����ϱ� ���� model�� ���� 
		/*
		 * model.addAttribute("like", like); model.addAttribute("pw", pw);
		 * 
		 * //4. AnJoinCommand�� �����ؼ� �𵨿� ��� �����͸� �Ѱ��ش� command = new AnLoginCommand();
		 * command.execute(model);
		 * 
		 * //11. ������ ���� views���� anLogin.jsp�� ã�� �����Ѵ�. return "anLogin";
		 */
		 
		
	}
	
}
