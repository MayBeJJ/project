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
		
		// 1. 안드로이드에서 보낸 데이터를 req로 받아서 변수에 저장
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
				
		
		// 2. 찍어봅시다
		System.out.println(name + ", " + email + ", " + phonenumber + ", " 
					+  id + ", " + profileimage );
					
		// 3. 안드로이드에서 보낸 파일 받기 : 파일을 보낸 경우에만 실행
		// 파일이름만 저장해 놓고 안드로이드에서 받아서 전체 경로를 완성한다
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
//				// 이미지 파일을 서버에 저장
//				try {
//					file.transferTo(new File(realImgPath, fileName));
//				} catch (Exception e) {
//					e.getMessage();
//				} 
//				
//			}
//		}			
//			
		
		// 4. AnJoinCommand 에게 model에 담아서 데이터를 보내준다.
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phonenumber", phonenumber);
		model.addAttribute("profileimage", profileimage);
		
		// 5. AnJoinCommand를 생성해서 데이터가 담긴 model을 넘겨준다.
		command = new KangJoinCommand();
		command.execute(model);				
		
		// 응답을 위해 views에서 anJoin.jsp를 찾아 실행한다.
		return "kangJoin";
		
	}
	
	
	

	
}
	
