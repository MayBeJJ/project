package com.hanul.laundry.command;

import org.springframework.ui.Model;

import com.hanul.laundry.dao.kkbAnDao;
import com.hanul.laundry.dto.kkbLocationDTO;

public class kkbAnlocationCommand implements kkbAnCommand {

	@Override
	public void execute(Model model) {
		//5. controller 에서 넘겨받은 model에서 값 추출
				String userid = (String) model.asMap().get("userid");
				String storeid = (String)model.asMap().get("storeid");
				String lc = (String)model.asMap().get("lc");
				
				
				
				kkbAnDao dao = new kkbAnDao();
				//6. 추출한 값을 Dao에 넘겨준다
//				int state = dao.anlocation(userid,  storeid , lc);
				int dtos = dao.anlocation(userid,  storeid , lc);
				//9. Dao에서 넘겨준 값을 같은 타입으로 받는다
				
				//10. jsp에서 사용하기 위해 모델에 저장한다.
//				model.addAttribute("anBookmark", String.valueOf(state));
				model.addAttribute("kkbanBookmark", dtos);
				
			}
			
		}