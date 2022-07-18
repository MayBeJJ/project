package com.hanul.laundry.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.hanul.laundry.dao.KangDao;
import com.hanul.laundry.dto.KangDTO;


public class KangSelectMemberCommand implements AnCommand{

	@Override
	public void execute(Model model) {
		// 6. controller���� �Ѱܹ��� model���� �� ����	
		// 7. ������ ���� Dao�� �Ѱ��ش�.
		KangDao adao = new KangDao();
		// 10. Dao���� �Ѱ��� ���� �޴´�
		ArrayList<KangDTO> dtos = adao.anSelectMember();
				 
		// 11. jsp���� ����ϱ� ���� �𵨿� �����Ѵ�
		model.addAttribute("anSelectMember", dtos);				
		
	}

}
