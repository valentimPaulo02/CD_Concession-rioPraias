package objects;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Service")
public class Service implements Serializable {
	
	private String Id;
	private String BeachId;
	private int NbrOfSeats;
	
	public Service(String Id, String BeachId, int NbrOfSeats) {
		this.Id = Id;
		this.BeachId = BeachId;
		this.NbrOfSeats = NbrOfSeats;
	}
	
	public Service() {
	}
	
	public String getId() {
		return Id;
	}
	
	public void setId(String Id) {
		this.Id = Id;
	}
	
	public String getBeachId() {
		return BeachId;
	}
	
	public void setBeachId(String BeachId) {
		this.BeachId = BeachId;
	}
	
	public int getNbrOfSeats() {
		return NbrOfSeats;
	}
	
	public void setNbrOfSeats(int NbrOfSeats) {
		this.NbrOfSeats = NbrOfSeats;
	}
}

