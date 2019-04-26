package com.lsj.spring.controller;

import org.springframework.web.multipart.MultipartFile;

public class ReportCommand {
	private String studentNumber;
	private MultipartFile report;
	
	public String getStudentNumber() {
		return studentNumber;
	}
	public MultipartFile getReport() {
		return report;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public void setReport(MultipartFile report) {
		this.report = report;
	}
}
