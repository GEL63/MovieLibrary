package movieslibrary;

public class AverageScore {
	
	private String source;
	private int numOfScore;
	public enum score{CRITICS,AUDIENCE}
	
	public AverageScore(String source,int numoOfScore, int numOfScore){
		
		this.setSource(source);
		this.setNumOfScore(numOfScore);
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getNumOfScore() {
		return numOfScore;
	}

	public void setNumOfScore(int numOfScore) {
		this.numOfScore = numOfScore;
	}
	
}