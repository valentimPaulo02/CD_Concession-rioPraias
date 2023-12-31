package frontend.soap.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "listarSombrinhasResponse", namespace = "http://soap.frontend/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarSombrinhasResponse", namespace = "http://soap.frontend/")

public class ListarSombrinhasResponse {

    @XmlElement(name = "return")
    private java.util.ArrayList<objects.Service> _return;

    public java.util.ArrayList<objects.Service> getReturn() {
        return this._return;
    }

    public void setReturn(java.util.ArrayList<objects.Service> new_return)  {
        this._return = new_return;
    }


}