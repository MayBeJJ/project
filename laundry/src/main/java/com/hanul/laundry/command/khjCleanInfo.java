package com.hanul.laundry.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.google.gson.Gson;
import com.hanul.laundry.dao.khjDao;
import com.hanul.laundry.dto.khjCleanDTO;

public class khjCleanInfo implements khjAnCommand{

	@Override
	public void execute(Model model) {
//		AnDao adao = new AnDao();
//		ArrayList<CleanDTO> adtos = adao.anSelectClean();
//		model.addAttribute("anCleanInfo", adtos); 
		ArrayList<khjCleanDTO> adtos = new khjDao().kimSelectClean();
		model.addAttribute("anCleanInfo", new Gson().toJson( adtos ) ); 
	}
	

}
