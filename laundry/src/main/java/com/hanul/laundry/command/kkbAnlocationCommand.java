package com.hanul.laundry.command;

import org.springframework.ui.Model;

import com.hanul.laundry.dao.kkbAnDao;

public class kkbAnlocationCommand implements kkbAnCommand {

	@Override
	public void execute(Model model) {
		//5. controller ���� �Ѱܹ��� model���� �� ����
		String userid = (String) model.asMap().get("userid");
		String storeid = (String)model.asMap().get("storeid");
		String lc = (String)model.asMap().get("lc");
		
		
		
		kkbAnDao dao = new kkbAnDao();
		//6. ������ ���� Dao�� �Ѱ��ش�
		int state = dao.anlocation(userid,  storeid , lc);
		//9. Dao���� �Ѱ��� ���� ���� Ÿ������ �޴´�
		
		//10. jsp���� ����ϱ� ���� �𵨿� �����Ѵ�.
		model.addAttribute("anBookmark", String.valueOf(state));
		
	}
	
}