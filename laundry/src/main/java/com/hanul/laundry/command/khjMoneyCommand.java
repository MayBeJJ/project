package com.hanul.laundry.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.hanul.laundry.dao.khjAnDao;
import com.hanul.laundry.dto.khjMoneyDTO;

public class khjMoneyCommand implements khjAnCommand {

	@Override
	public void execute(Model model) {
		khjAnDao adao = new khjAnDao();
		ArrayList<khjMoneyDTO> adtos = adao.anSelectMoney();
		model.addAttribute("anMoneySelect", adtos);
		new khjAnDao().anSelectMoney();
		
	}

}
