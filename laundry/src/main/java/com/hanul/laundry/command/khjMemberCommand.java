package com.hanul.laundry.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.hanul.laundry.dao.khjDao;
import com.hanul.laundry.dto.khjMemberDTO;


public class khjMemberCommand implements khjAnCommand{

	@Override
	public void execute(Model model) {
		khjDao adao = new khjDao();
		ArrayList<khjMemberDTO> adtos = adao.anSelectMember();		
		model.addAttribute("anMemberSelect", adtos); 	
		
	}

}