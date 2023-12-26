package frontend.Rest;

import java.util.Arrays;
import java.util.stream.IntStream;


public class ReserveShadowContent {

    private char beach;
    private int spotNumber;
    private int numberOfPersons;

    public ReserveShadowContent() {
    }

    public ReserveShadowContent(char beach, int spotNumber, int numberOfPersons) {
        this.beach = beach;
        this.spotNumber = spotNumber;
        this.numberOfPersons = numberOfPersons;
    }

    public char getBeach() {
        return beach;
    }

    public void setBeach(char beach) {
        this.beach = beach;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }
}
