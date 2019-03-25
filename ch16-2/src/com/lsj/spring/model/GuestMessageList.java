package com.lsj.spring.model;
import java.util.List;

//모델클래스
public class GuestMessageList {
	private int totalCount;
	private int pageNum;
	private int begin;
	private int end;
	private List<GuestMessage> messages;
	
	public GuestMessageList(int totalCount, int pageNum, int begin, int end, List<GuestMessage> messages){
		this.totalCount = totalCount;
		this.pageNum = pageNum;
		this.begin = begin;
		this.end = end;
		this.messages = messages;
	}
	
	private void setTotalCount() {
		this.totalCount = totalCount;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	private void setEnd() {
		this.end = end;
	}
	private void setMessages() {
		this.messages = messages;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public int getBegin() {
		return begin;
	}
	public int getEnd() {
		return end;
	}
	public List<GuestMessage> getMessages() {
		return messages;
	}
	
}
