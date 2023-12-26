package frontend.Rest;

import java.util.ArrayList;
import java.util.List;




import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ReturnBeachService")
public class ReturnBeachService {

	
	private String Operation;
	//private List<BeachService> BeachServices = new ArrayList<BeachService>();
	private String BeachServices;
	
	
	
	
	public ReturnBeachService() {
		
	}
	
	
	public ReturnBeachService(String Operation, String BeachServices) {
		this.Operation = Operation;
		this.BeachServices = BeachServices;
	}
	
	public void setBeachServices(String BeachServices) {
		this.BeachServices = BeachServices;
	}
	
	public String getBeachServices(){
		return BeachServices;
	}
	
	
	public String getOperation() {
		return Operation;
	}
	
	public void setOperation(String operation) {
		this.Operation = operation;
	}
	
	
	
	
	
	
	
	
}