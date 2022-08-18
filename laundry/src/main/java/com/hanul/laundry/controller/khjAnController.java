package com.hanul.laundry.controller;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hanul.laundry.command.khjAnCommand;
import com.hanul.laundry.command.khjCleanInfo;
import com.hanul.laundry.command.khjMemberCommand;
import com.hanul.laundry.command.khjMoneyCommand;
import com.hanul.laundry.command.khjRecentCommand;
import com.hanul.laundry.dao.khjDao;
import com.hanul.laundry.dto.khjCleanDTO;

@Controller
public class khjAnController {
	
	khjAnCommand command;
	
	@RequestMapping("/anRecentSelect")
	public String anRecentSelect(HttpServletRequest req, Model model) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		
		command = new khjRecentCommand();
		command.execute(model);
		
		return null;
		
	}
	
	@RequestMapping("/anMoneySelect")
	public String anMoneySelect(HttpServletRequest req, Model model) {
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
			
		command = new khjMoneyCommand();
		command.execute(model);
		
		return null;
		
	}
	
	@ResponseBody  @RequestMapping(value="/kimCleanInfo", produces="text/plain; charset=utf-8")
	public String anCleanInfo(HttpServletRequest req, Model model) throws Exception{
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		
		ArrayList<khjCleanDTO> adtos = new khjDao().kimSelectClean();
		String result = new Gson().toJson( adtos );
		
//		command = new CleanInfo();
//		command.execute(model);
//		
		return result;
//		return model.asMap().get("anCleanInfo").toString();
	}
	
	@RequestMapping(value="/anMemberSelect", method = {RequestMethod.GET, RequestMethod.POST}  )
	public String anSelectMulti(HttpServletRequest req, Model model){
		System.out.println("anMemberSelect()");
		
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 			
		
		command = new khjMemberCommand();
		command.execute(model);
		
		return "anMemberSelect";
	}
	
	/*@RequestMapping(value="/android", method = {RequestMethod.GET, RequestMethod.POST})
	public String anJoin(HttpServletRequest req, Model model) {
		System.out.println("android");
		
		
		
		// 1. �ȵ���̵忡�� ���� �����͸� req�� �޾Ƽ� ������ ����
		String id = req.getParameter("id");
		String money = req.getParameter("money");

		
		// 2. ���ô�
		System.out.println(id);
		System.out.println(money);
		
	
		
					
		// 3. �ȵ���̵忡�� ���� ���� �ޱ� : ������ ���� ��쿡�� ����
		// �����̸��� ������ ���� �ȵ���̵忡�� �޾Ƽ� ��ü ��θ� �ϼ��Ѵ�
		String fileName = "";
		
		MultipartRequest multi = (MultipartRequest)req;
		MultipartFile file = multi.getFile("imgrealpath");
		
		if(file != null) {
			fileName = file.getOriginalFilename();
			System.out.println("fileName : " + fileName);
			
			if(file.getSize() > 0) {
				String realImgPath = req.getSession().getServletContext()
						.getRealPath("/resources/");
				
				System.out.println("realpath : " + realImgPath);
				System.out.println("fileSize : " + file.getSize());
				
				// �̹��� ������ ������ ����
				try {
					file.transferTo(new File(realImgPath, fileName));
				} catch (Exception e) {
					e.getMessage();
				} 
				
			}
		}			
			
		
		// 4. AnJoinCommand ���� model�� ��Ƽ� �����͸� �����ش�.
		model.addAttribute("id", id);
		model.addAttribute("money", money);
		
		
		// 5. AnJoinCommand�� �����ؼ� �����Ͱ� ��� model�� �Ѱ��ش�.
		command = new AndroidCommand();
		command.execute(model);				
		
		// ������ ���� views���� anJoin.jsp�� ã�� �����Ѵ�.
		return "android";*/
		
	}
	
	


