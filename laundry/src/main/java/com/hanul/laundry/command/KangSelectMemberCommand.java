package com.hanul.laundry.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.hanul.laundry.dao.KangDao;
import com.hanul.laundry.dto.KangDTO;


public class KangSelectMemberCommand implements AnCommand{

	@Override
	public void execute(Model model) {
		// 6. controller에서 넘겨받은 model에서 값 추출	
		// 7. 추출한 값을 Dao에 넘겨준다.
		KangDao adao = new KangDao();
		// 10. Dao에서 넘겨준 값을 받는다
		ArrayList<KangDTO> dtos = adao.anSelectMember();
				 
		// 11. jsp에서 사용하기 위해 모델에 저장한다
		model.addAttribute("anSelectMember", dtos);				
		
	}

}
