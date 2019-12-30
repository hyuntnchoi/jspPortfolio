package qna;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Article {
	
	private int articleNo;
	private String title;
	private String content;
	private String date_pattern1;
	private String date_pattern2;
	
	public Article(int articleNo, String title, String content, Date date1, Date date2) {
		
		this.date_pattern1 = dateFormat1.format(date1);
		this.date_pattern2 = dateFormat2.format(date2);					
		this.articleNo = articleNo;
		this.title = title;
		this.content = content;
	}
	
	// Date Format to yyyy-MM-dd
	SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
	// Date Format to yyyy-mm-dd hh:mm:ss
	SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	
	// 아래 getter는 아직 필요성을 못느끼는데 일단 만들어 놓음..
	public int getArticleNo() {
		return articleNo;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getDate1() {
		return date_pattern1;
	}
	
	public String getDate2() {
		return date_pattern2;
	}
}
