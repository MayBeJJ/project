package com.hanul.laundry.command;

import java.util.ArrayList;

import org.springframework.ui.Model;


import com.hanul.laundry.dao.PS_Dao;
import com.hanul.laundry.dto.PS_SearchDTO;

public class PS_QRCommand implements AnCommand{

	@Override
	public void execute(Model model) {
		// 6. controller에서 넘겨받은 model에서 값 추출
		String name = (String)model.asMap().get("name");
		
		// 7. 추출한 값을 Dao에 넘겨준다.
		PS_Dao adao = new PS_Dao();
		// 10. Dao에서 넘겨준 값을 받는다
		PS_SearchDTO ps_searchdto = adao.psQRCode(name);
				 
		// 11. jsp에서 사용하기 위해 모델에 저장한다
		model.addAttribute("psQRCode", ps_searchdto);
	}

}