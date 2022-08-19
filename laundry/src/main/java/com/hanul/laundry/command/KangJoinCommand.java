package com.hanul.laundry.command;

import org.springframework.ui.Model;

import com.hanul.laundry.dao.KangDao;

public class KangJoinCommand implements AnCommand{

	@Override
	public void execute(Model model) {
		// 6. controller에서 넘겨받은 model에서 값 추출
		String name = (String)model.asMap().get("name");
		String email = (String)model.asMap().get("email");
		String phonenumber = (String)model.asMap().get("phonenumber");
		String id = (String)model.asMap().get("id");
		String profileimage = (String)model.asMap().get("profileimage");
		
		// 7. 추출한 값을 Dao에 넘겨준다.
		KangDao kangdao = new KangDao();
		// 10. Dao에서 넘겨준 값을 받는다
//		int state = kangdao.kangJoin(name, email, phonenumber, id, profileimage);
				 
		// 11. jsp에서 사용하기 위해 모델에 저장한다
//		model.addAttribute("kangJoin", String.valueOf(state));				
		
	}

}
