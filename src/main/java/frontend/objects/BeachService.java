package frontend.objects;



import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BeachService")
public class BeachService {
	
	private String Id;
	private char BeachId;
	private int NbrOfSeats;
	
	
	
	
	public BeachService(String Id, char BeachId, int NbrOfSeats ) {
		this.Id = Id;
		this.BeachId = BeachId;
		this.NbrOfSeats = NbrOfSeats;
	}
	
	public BeachService() {
		
	}
	
	public void setId(String Id) {
		this.Id = Id;
	}
	public String getId() {
		return Id;
	}
	
	
	public void setBeachId(char BeachId) {
		this.BeachId = BeachId;
	}
	public char getBeachId() {
		return BeachId;
	}
	
	
	public void setNbrOfSeats(int NbrOfSeats) {
		this.NbrOfSeats = NbrOfSeats;
	}
	public int getNbrOfSeats() {
		return NbrOfSeats;
	}
}