import java.io.Serializable;
import java.util.ArrayList;


public class User implements Serializable{
	private String fullName;
	private String email;
	private String zipCode;
	private ArrayList<Review> reviews;
	public User()
	{
		
	}
	
	public User(String fullName, String email, String zipCode,
			ArrayList<Review> reviews) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.zipCode = zipCode;
		this.reviews = reviews;
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}
	
}
