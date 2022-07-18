package com.hanul.laundry.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.hanul.laundry.command.AnCommand;
import com.hanul.laundry.command.KangJoinCommand;


@Controller
public class KangController {
	
	AnCommand command;
	
	@RequestMapping(value="/kangJo", method = {RequestMethod.GET, RequestMethod.POST})
	public String kangJoin(HttpServletRequest req, Model model) {
		System.out.println("KangJoin");
		
		// 1. �ȵ���̵忡�� ���� �����͸� req�� �޾Ƽ� ������ ����
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phonenumber = req.getParameter("phonenumber");
		String id = req.getParameter("id");
		String profileimage = req.getParameter("profileimage");
		
//		String name = "1";
//		String email = "2";
//		String phonenumber = "3";
//		String id = "4";
//		String profileimage = "5";
				
		
		// 2. ���ô�
		System.out.println(name + ", " + email + ", " + phonenumber + ", " 
					+  id + ", " + profileimage );
					
		// 3. �ȵ���̵忡�� ���� ���� �ޱ� : ������ ���� ��쿡�� ����
		// �����̸��� ������ ���� �ȵ���̵忡�� �޾Ƽ� ��ü ��θ� �ϼ��Ѵ�
//		String fileName = "";
//		
//		MultipartRequest multi = (MultipartRequest)req;
//		MultipartFile file = multi.getFile("imgrealpath");
//		
//		if(file != null) {
//			fileName = file.getOriginalFilename();
//			System.out.println("fileName : " + fileName);
//			
//			if(file.getSize() > 0) {
//				String realImgPath = req.getSession().getServletContext()
//						.getRealPath("/resources/");
//				
//				System.out.println("realpath : " + realImgPath);
//				System.out.println("fileSize : " + file.getSize());
//				
//				// �̹��� ������ ������ ����
//				try {
//					file.transferTo(new File(realImgPath, fileName));
//				} catch (Exception e) {
//					e.getMessage();
//				} 
//				
//			}
//		}			
//			
		
		// 4. AnJoinCommand ���� model�� ��Ƽ� �����͸� �����ش�.
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phonenumber", phonenumber);
		model.addAttribute("profileimage", profileimage);
		
		// 5. AnJoinCommand�� �����ؼ� �����Ͱ� ��� model�� �Ѱ��ش�.
		command = new KangJoinCommand();
		command.execute(model);				
		
		// ������ ���� views���� anJoin.jsp�� ã�� �����Ѵ�.
		return "kangJoin";
		
	}
	
	
	

	
}
	
