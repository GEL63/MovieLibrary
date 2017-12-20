package movieslibrary;

public class Rating {

	private int date;
	private String user;
	private int rate;
	
	public Rating(int date,String user,int rate){
		
		this.setDate(date);
		this.setUser(user);
		this.setRate(rate);
		
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}
