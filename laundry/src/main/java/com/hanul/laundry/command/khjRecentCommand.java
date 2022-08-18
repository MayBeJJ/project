package com.hanul.laundry.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.hanul.laundry.dao.khjDao;
import com.hanul.laundry.dto.khjRecentDTO;

public class khjRecentCommand implements khjAnCommand{

	@Override
	public void execute(Model model) {
		khjDao adao = new khjDao();
		ArrayList<khjRecentDTO> adtos = adao.anSelectRecent();
		model.addAttribute("anRecentSelect", adtos);
		new khjDao().anSelectRecent();
		
	}
	
	

}