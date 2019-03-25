package com.lsj.spring;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter{
	private String filePath;
	
	@Override
	public void output(String msg) throws IOException{
		FileWriter out = new FileWriter(filePath);
		out.write(msg);
		out.close();
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
