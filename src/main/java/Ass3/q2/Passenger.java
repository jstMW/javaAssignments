package Ass3.q2;
import java.util.Date;

public class Passenger {
    private String passportNo;
    private Fare fareCode;
    private FlyerStatus flyerStatusCode;
    private Date registerationDate;

    public Passenger(String passportNo) {
        this.passportNo = passportNo;
        this.fareCode = Fare.randomValue();
        this.flyerStatusCode = FlyerStatus.randomValue();
        this.registerationDate = new Date();
    }

    public String getPassportNo() {return passportNo;}
    public Fare getFareCode() {return fareCode;}
    public FlyerStatus getFlyerStatusCode() {return flyerStatusCode;}
    public Date getRegisterationDate() {return registerationDate;}


    public Passenger PassengerComparator(Passenger a, Passenger b) {
        int compareFare = compare(a.getFare(), b.getFare());
        if ( compareFare != 0) {
            return compareFare > 0 ? a : b;
        }
        int compareFlyerStatus = compare(a.getFlyerStatus(), b.getFlyerStatus());
        if (compareFlyerStatus != 0) {
            return compareFlyerStatus > 0 ? a : b;
        }

        //nothing was mentioned for a case that two passnger could have the same Date so, no need to check if != 0
        int compareDate = comaper(a.getDate(), b.getDate()); 
        return compareDate > 0 ? a : b;

    }

}
