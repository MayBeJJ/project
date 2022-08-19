package com.hanul.laundry.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.hanul.laundry.command.AnCommand;
import com.hanul.laundry.dao.KangDao;
import com.hanul.laundry.dao.khjDao;
import com.hanul.laundry.dto.UserDTO;
import com.hanul.laundry.dto.khjCleanDTO;


@Controller
public class KangController {
	
	AnCommand command;
	
	@ResponseBody  @RequestMapping(value="/kangJo", method = {RequestMethod.GET, RequestMethod.POST}, produces="text/plain; charset=utf-8")
	public String kangJoin(HttpServletRequest req, Model model) {
		System.out.println("KangJoin");
		
		// 1. 안드로이드에서 보낸 데이터를 req로 받아서 변수에 저장
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String id = req.getParameter("id");
		String profile = req.getParameter("profile");	
		
		
		// 2. 찍어봅시다
		System.out.println(name + ", " + email + ", " + phone + ", " +  id + ", " + profile );
					
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
		/*
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phonenumber", phonenumber);
		model.addAttribute("profileimage", profileimage);
		
		// 5. AnJoinCommand를 생성해서 데이터가 담긴 model을 넘겨준다.
		command = new KangJoinCommand();
		command.execute(model);				
		*/
		//2022.08.18 소셜로그인시 회원정보 처리 변경 by 조순섭
		KangDao dao = new KangDao();
		UserDTO userdto = dao.kangJoin(id, name, email, phone, profile); 
		
		System.out.println(userdto.getUserid() + ", " + userdto.getName() + ", " + userdto.getEmail() + ", " + userdto.getPhone() + ", " 
				+  userdto.getProfile() + ", " + userdto.getPoint() );
		
		
		model.addAttribute("kangJoin", userdto);		
		
		
		HashMap<String, String> bookmark = new KangDao().bookmark_store(id); //즐겨찾기 store목록 조회		
		HashMap<String, String> datas = new HashMap<String, String>();
		datas.put("user", new Gson().toJson(userdto) );
		datas.put("bookmark", new Gson().toJson(bookmark));
		String result = new Gson().toJson( datas );
		
		
		// 응답을 위해 views에서 anJoin.jsp를 찾아 실행한다.
		return result;
//		return "kangJoin";
		
	}
	
	
	

	
}
	
