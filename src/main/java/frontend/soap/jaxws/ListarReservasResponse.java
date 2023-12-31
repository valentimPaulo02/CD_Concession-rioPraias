package frontend.soap.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "listarReservasResponse", namespace = "http://soap.frontend/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarReservasResponse", namespace = "http://soap.frontend/")

public class ListarReservasResponse {

    @XmlElement(name = "return")
    private java.util.ArrayList<frontend.objects.Booking> _return;

    public java.util.ArrayList<frontend.objects.Booking> getReturn() {
        return this._return;
    }

    public void setReturn(java.util.ArrayList<frontend.objects.Booking> new_return)  {
        this._return = new_return;
    }

}