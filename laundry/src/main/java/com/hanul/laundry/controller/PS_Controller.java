package com.hanul.laundry.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.hanul.laundry.command.AnCommand;
import com.hanul.laundry.command.PS_QRCommand;
import com.hanul.laundry.command.PS_SearchCommand;

@Controller
public class PS_Controller {
	
	AnCommand command;	

	@RequestMapping(value="/anSearch", method = {RequestMethod.GET, RequestMethod.POST})
	public String psSearch(HttpServletRequest req, Model model) {
		System.out.println("anSearch");
		
		// 1. �ȵ���̵忡�� ���� �����͸� req�� �޾Ƽ� ������ ����	
		// 2. ���ô�
		// 3. �ȵ���̵忡�� ���� ���� �ޱ� : ������ ���� ��쿡�� ����
		// �����̸��� ������ ���� �ȵ���̵忡�� �޾Ƽ� ��ü ��θ� �ϼ��Ѵ�	
		// 4. AnJoinCommand ���� model�� ��Ƽ� �����͸� �����ش�.
		// 5. AnJoinCommand�� �����ؼ� �����Ͱ� ��� model�� �Ѱ��ش�.
		command = new PS_SearchCommand();
		command.execute(model);				
		
		// ������ ���� views���� anLogin.jsp�� ã�� �����Ѵ�.
		return "anSearch";
		
	}

	
	/*
	 * @RequestMapping(value="/psQRCode", method = {RequestMethod.GET,
	 * RequestMethod.POST}) public String psQRCode(HttpServletRequest req, Model
	 * model) { System.out.println("psQRCode");
	 * 
	 * // 1. �ȵ���̵忡�� ���� �����͸� req�� �޾Ƽ� ������ ���� // 2. ���ô� // 3. �ȵ���̵忡�� ���� ���� �ޱ� :
	 * ������ ���� ��쿡�� ���� // �����̸��� ������ ���� �ȵ���̵忡�� �޾Ƽ� ��ü ��θ� �ϼ��Ѵ� // 4. AnJoinCommand ����
	 * model�� ��Ƽ� �����͸� �����ش�. // 5. AnJoinCommand�� �����ؼ� �����Ͱ� ��� model�� �Ѱ��ش�. command
	 * = new AnSelectMemberCommand(); command.execute(model);
	 * 
	 * // ������ ���� views���� anLogin.jsp�� ã�� �����Ѵ�. return "anSelectMember";
	 * 
	 * }
	 */
	@RequestMapping(value="/psQRCode", method = {RequestMethod.GET, RequestMethod.POST})
	public String psQRCode(HttpServletRequest req, Model model) {
		System.out.println("psQRCode");
		
		// 1. �ȵ���̵忡�� ���� �����͸� req�� �޾Ƽ� ������ ����
		String name = req.getParameter("name");
		//String name = "������";
		// 2. ���ô�
		System.out.println("name: " + name );
					
		// 3. �ȵ���̵忡�� ���� ���� �ޱ� : ������ ���� ��쿡�� ����
		// �����̸��� ������ ���� �ȵ���̵忡�� �޾Ƽ� ��ü ��θ� �ϼ��Ѵ�		
			
		
		// 4. AnJoinCommand ���� model�� ��Ƽ� �����͸� �����ش�.
		model.addAttribute("name", name);
		
		// 5. AnJoinCommand�� �����ؼ� �����Ͱ� ��� model�� �Ѱ��ش�.
		command = new PS_QRCommand();
		command.execute(model);				
		
		// ������ ���� views���� anLogin.jsp�� ã�� �����Ѵ�.
		return "psQRCode";
		
	}
	
	
}
