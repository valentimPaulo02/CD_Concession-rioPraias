package frontend.Rest;

import java.util.Arrays;
import java.util.stream.IntStream;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ReserveShadowContent")
public class ReserveShadowContent {

    private String Beach;
    private String Date;
    private int NumberOfPersons;

    public ReserveShadowContent() {
    }

    public ReserveShadowContent(String Beach, String Date, int NumberOfPersons) {
        this.Beach = Beach;
        this.Date = Date;
        this.NumberOfPersons = NumberOfPersons;
    }

    public String getBeach() {
        return Beach;
    }

    public void setBeach(String Beach) {
        this.Beach = Beach;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getNumberOfPersons() {
        return NumberOfPersons;
    }

    public void setNumberOfPersons(int NumberOfPersons) {
        this.NumberOfPersons = NumberOfPersons;
    }
}
