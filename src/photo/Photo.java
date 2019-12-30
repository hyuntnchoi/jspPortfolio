package photo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Photo {
	
	private String content;
	private String base64Image;
	private String date_pattern1;
	private String date_pattern2;
	
	public Photo() {
	}
	
	public Photo(String content, String base64Image, Date date1, Date date2) {
		this.content = content;
		this.base64Image = base64Image;
		this.date_pattern1 = dateFormat1.format(date1);
		this.date_pattern2 = dateFormat2.format(date2);
	}
	
	// Date Format to yyyyMMdd
	SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMdd");
	// Date Format to yyyy-mm-dd hh:mm:ss
	SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	
	public String getDate1() {
		return date_pattern1;
	}
	public void setDate1(Date date1) {
		this.date_pattern1 = dateFormat1.format(date1);
	}
	
	public String getDate2() {
		return date_pattern2;
	}
	public void setDate2(Date date2) {
		this.date_pattern2 = dateFormat1.format(date2);
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}

