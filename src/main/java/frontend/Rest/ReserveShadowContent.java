package frontend.Rest;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReserveShadowContent {
	
	private String Beach;
	private String Date;
	private int NumberofPersons;

	public ReserveShadowContent() {
	}

	public ReserveShadowContent(String Beach, String Date, int NumberofPersons) {
		this.Beach = Beach;
		this.Date = Date;
		this.NumberofPersons = NumberofPersons;
	}

	public String getBeach() {
		return Beach;
	}

	public void setBeach(String Beach) {
		this.Beach = Beach;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String Date) {
		this.Date = Date;
	}

	public int getNumberofPersons() {
		return NumberofPersons;
	}

	public void setNumberofPersons(int NumberofPersons) {
		this.NumberofPersons = NumberofPersons;
	}
	
	

}
