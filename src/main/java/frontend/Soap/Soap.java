package frontend.Soap;

import javax.jws.WebService;

@WebService(targetNamespace = "http://Soap.frontend/", portName = "SoapPort", serviceName = "SoapService")
public class Soap {
    public int addIntegers(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }    
}
