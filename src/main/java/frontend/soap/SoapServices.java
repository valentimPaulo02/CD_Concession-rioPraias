package frontend.soap;

import javax.jws.WebService;

@WebService(targetNamespace = "http://soap.frontend/", portName = "SoapServicesPort", serviceName = "SoapServicesService")
public class SoapServices {
	
	public int AddIntegers(int a, int b) {
		return a+b;
	}
}
