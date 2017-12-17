package movieslibrary;

public class Photo {
	private int id;
	private String URL;

	enum source {
		IMBD, ROTTEN_TOMATO
	}

	public Photo(int id, String URL) {

		this.id = id;
		this.URL = URL;

	}

	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	public String getURL() {

		return URL;

	}

	public void setURL(String uRL) {

		URL = uRL;
	}
	
}
