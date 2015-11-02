import java.io.Serializable;
import java.util.Date;


public class Review implements Serializable{
	private String rating;
	private String comment;
	private Date date;
	public Review()
	{
		
	}
	public Review(String rating, String comment, Date date) {
		super();
		this.rating = rating;
		this.comment = comment;
		this.date = date;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
