package com.hanul.laundry.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.hanul.laundry.dao.khjDao;
import com.hanul.laundry.dto.khjMoneyDTO;

public class khjMoneyCommand implements khjAnCommand {

	@Override
	public void execute(Model model) {
		khjDao adao = new khjDao();
		ArrayList<khjMoneyDTO> adtos = adao.anSelectMoney();
		model.addAttribute("anMoneySelect", adtos);
		new khjDao().anSelectMoney();
		
	}

}
