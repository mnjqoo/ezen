package com.edu.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/util")
public class UtilController {

	private static final Logger logger = LoggerFactory.getLogger(UtilController.class);
	
	@RequestMapping(value="/zipcode/address", method=RequestMethod.GET)
	public String address() throws Exception {
		logger.info("UtilController의 address() 불러오기...");
		
		return "/util/zipcode/address";
	}
	
	@RequestMapping(value="/datepicker/datepicker", method=RequestMethod.GET)
	public String datepicker() throws Exception {
		logger.info("UtilController의 datepicker() 불러오기...");
		
		return "/util/datepicker/datepicker";
	}
	
	@RequestMapping(value="/selectrow/selectRow1", method=RequestMethod.GET)
	public void selectRow1() throws Exception {
		logger.info("UtilController의 selectRow1() 불러오기...");
		
	}
	
	@RequestMapping(value="/selectrow/selectRow2", method=RequestMethod.GET)
	public void selectRow2() throws Exception {
		logger.info("UtilController의 selectRow2() 불러오기...");
		
	}
}
