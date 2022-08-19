package com.hanul.laundry.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanul.laundry.dao.TimeDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class iotController {
	
	private static final Logger logger = LoggerFactory.getLogger(iotController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/iotData", method = RequestMethod.GET)
	public String iotdata(HttpServletRequest request, Model model) {
		System.out.println("iotData 들어옴");
		
		String userid = request.getParameter("userid");
		String machineseq = request.getParameter("machineseq");
		String restTime = request.getParameter("restTime");
		System.out.println(userid);
		System.out.println(machineseq);
		System.out.println(restTime);
		
		TimeDao dao = new TimeDao();
		dao.kangTime(userid, machineseq, restTime);
		
	
		return "kangTime";
	}
	
}
