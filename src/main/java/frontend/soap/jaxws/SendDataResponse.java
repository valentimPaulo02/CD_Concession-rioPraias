
package frontend.soap.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.6.2
 * Tue Dec 05 21:56:25 GMT 2023
 * Generated source version: 3.6.2
 */

@XmlRootElement(name = "SendDataResponse", namespace = "http://soap.frontend/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SendDataResponse", namespace = "http://soap.frontend/")

public class SendDataResponse {

    @XmlElement(name = "return")
    private java.lang.String _return;

    public java.lang.String getReturn() {
        return this._return;
    }

    public void setReturn(java.lang.String new_return)  {
        this._return = new_return;
    }

}