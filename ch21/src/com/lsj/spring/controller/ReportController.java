package com.lsj.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ReportController {
	@RequestMapping(value = "/report/reportForm.do", method = RequestMethod.GET)
	public String form(){
		return "report/reportForm";
	}
	
	@RequestMapping(value = "/report/submitReport1.do", method = RequestMethod.POST)
	public String submitReport1(@RequestParam("studentNumber") String studentNumber, @RequestParam("report") MultipartFile report){
		printInfo(studentNumber, report);
		return "report/reportComplete";
	}
	
	private void printInfo(String studentNumber, MultipartFile report){
		System.out.println(studentNumber + "가 업로드한 파일: " + report.getOriginalFilename());
	}
	
	@RequestMapping(value = "/report/submitReport2.do", method = RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request){
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		
		printInfo(studentNumber, report);
		return "report/reportComplete";
	}
	
	@RequestMapping(value = "/report/submitReport3.do", method = RequestMethod.POST)
	public String submitReport3(ReportCommand reportCommand){		
		printInfo(reportCommand.getStudentNumber(), reportCommand.getReport());
		return "report/reportComplete";
	}
}
