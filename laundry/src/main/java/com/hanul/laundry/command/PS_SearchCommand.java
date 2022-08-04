package com.hanul.laundry.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.hanul.laundry.dao.PS_Dao;
import com.hanul.laundry.dto.PS_SearchDTO;

public class PS_SearchCommand implements AnCommand{

	@Override
	public void execute(Model model) {
		// 6. controller���� �Ѱܹ��� model���� �� ����	
		// 7. ������ ���� Dao�� �Ѱ��ش�.
		PS_Dao adao = new PS_Dao();
		// 10. Dao���� �Ѱ��� ���� �޴´�
		ArrayList<PS_SearchDTO> dtos = adao.anSearch();
				 
		// 11. jsp���� ����ϱ� ���� �𵨿� �����Ѵ�
		model.addAttribute("anSearch", dtos);				
		
	}

}
