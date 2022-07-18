package com.hanul.laundry.command;

import org.springframework.ui.Model;

import com.hanul.laundry.dao.KangDao;

public class KangJoinCommand implements AnCommand{

	@Override
	public void execute(Model model) {
		// 6. controller���� �Ѱܹ��� model���� �� ����
		String name = (String)model.asMap().get("name");
		String email = (String)model.asMap().get("email");
		String phonenumber = (String)model.asMap().get("phonenumber");
		String id = (String)model.asMap().get("id");
		String profileimage = (String)model.asMap().get("profileimage");
		
		// 7. ������ ���� Dao�� �Ѱ��ش�.
		KangDao kangdao = new KangDao();
		// 10. Dao���� �Ѱ��� ���� �޴´�
		int state = kangdao.kangJoin(name, email, phonenumber, id, profileimage);
				 
		// 11. jsp���� ����ϱ� ���� �𵨿� �����Ѵ�
		model.addAttribute("kangJoin", String.valueOf(state));				
		
	}

}
