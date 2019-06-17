package board.model;

import java.util.Date;

public class BoardVO {
	private int num;
	private int readcount;
	private Date regdate;
	private String writer;
	private String email;
	private String subject;
	private String pass;
	private String content;
	private String article_type;
	
	public int getNum() {
		return num;
	}
	public int getReadcount() {
		return readcount;
	}
	public String getWriter() {
		return writer;
	}
	public String getEmail() {
		return email;
	}
	public String getSubject() {
		return subject;
	}
	public String getPass() {
		return pass;
	}
	public String getContent() {
		return content;
	}
	public String getArticle_type() {
		return article_type;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setArticle_type(String article_type) {
		this.article_type = article_type;
	}
}
