package com.hanul.laundry.command;

import org.springframework.ui.Model;

import com.hanul.laundry.dao.KangDao;
import com.hanul.laundry.dto.KangDTO;


public class KangLoginCommand implements AnCommand{

	@Override
	public void execute(Model model) {
		// 6. controller���� �Ѱܹ��� model���� �� ����
		String id = (String)model.asMap().get("id");
		String passwd = (String)model.asMap().get("passwd");
		
		// 7. ������ ���� Dao�� �Ѱ��ش�.
		KangDao adao = new KangDao();
		// 10. Dao���� �Ѱ��� ���� �޴´�
		KangDTO memberDTO = adao.kangJoin(name, passwd);
				 
		// 11. jsp���� ����ϱ� ���� �𵨿� �����Ѵ�
		model.addAttribute("anLogin", memberDTO);				
		
	}

}
