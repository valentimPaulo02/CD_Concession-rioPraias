package frontend.soap.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "listarReservas", namespace = "http://soap.frontend/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarReservas", namespace = "http://soap.frontend/")


public class ListarReservas {

    @XmlElement(name = "arg0")
    private int arg0;

    public int getArg0() {
        return this.arg0;
    }

    public void setArg0(int newArg0)  {
        this.arg0 = newArg0;
    }

}
