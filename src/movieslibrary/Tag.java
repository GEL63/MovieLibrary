package movieslibrary;

public class Tag {

	private String date;
	private String user;
	private String value;

	public Tag(String date, String user, String value) {

		this.date = date;
		this.user = user;
		this.value = value;

	}

	public String getUser() {
		
		return user;
		
	}

	public void setUser(String user) {
		
		this.user = user;
		
	}

	public String getValue() {
		
		return value;
		
	}

	public void setValue(String value) {
		
		this.value = value;
		
	}

	public String getDate() {
		
		return date;
		
	}

	public void setDate(String date) {
		
		this.date = date;
		
	}
}
