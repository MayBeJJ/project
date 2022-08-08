package com.hanul.laundry.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.hanul.laundry.dao.khjAnDao;
import com.hanul.laundry.dto.khjRecentDTO;

public class khjRecentCommand implements khjAnCommand{

	@Override
	public void execute(Model model) {
		khjAnDao adao = new khjAnDao();
		ArrayList<khjRecentDTO> adtos = adao.anSelectRecent();
		model.addAttribute("anRecentSelect", adtos);
		new khjAnDao().anSelectRecent();
		
	}
	
	

}