package frontend.Rest;

import java.util.ArrayList;
import java.util.List;

public class ReturnBeachService {

	
	private String Operation;
	private List<BeachService> BeachServices = new ArrayList<BeachService>();
	
	
	
	public ReturnBeachService() {
		
	}
	
	
	public ReturnBeachService(String Operation, List<BeachService> BeachServices) {
		this.Operation = Operation;
		this.BeachServices = BeachServices;
	}
	
	public void setBeachServices(List<BeachService> BeachServices) {
		this.BeachServices = BeachServices;
	}
	
	public List<BeachService> getBeachServices(){
		return BeachServices;
	}
	
	
	public String getOperation() {
		return Operation;
	}
	
	public void setOperation(String operation) {
		this.Operation = operation;
	}
	
	
	
	
	
	
	
	
}