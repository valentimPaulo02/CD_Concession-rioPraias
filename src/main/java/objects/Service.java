package objects;

import java.io.Serializable;

public class Service implements Serializable{
		
	private String Id;
	private String BeachId;
	private int NbrOfSeats;
	
	
	public Service(String Id, String BeachId, int NbrOfSeats ) {
		this.Id = Id;
		this.BeachId = BeachId;
		this.NbrOfSeats = NbrOfSeats;
	}
	public Service() {
	}
	
	
	public String getId() {
		return Id;
	}
	
	public String getBeachId() {
		return BeachId;
	}
	
	public int getNbrOfSeats() {
		return NbrOfSeats;
	}
}
