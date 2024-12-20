package Ass3.q2;
import java.util.Date;

public class Passenger implements Comparable<Passenger>{
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



    public static int PassengerComparator(Passenger a, Passenger b) {
        int compareFare = (a.getFareCode()).compareTo(b.getFareCode());
        if ( compareFare != 0) {
            return compareFare;
        }
        int compareFlyerStatus = (a.getFlyerStatusCode()).compareTo(b.getFlyerStatusCode());
        if (compareFlyerStatus != 0) {
            return compareFlyerStatus;
        }

        //nothing was mentioned for a case that two passenger could have the same Date so, no need to check if != 0
        int compareDate = (a.getRegisterationDate()).compareTo(b.getRegisterationDate());
        if (compareDate != 0) {
            return compareDate;
        }
        return 0;

    }
    public int compareTo(Passenger p) {
       return PassengerComparator(this, p);
    }

    public String toString() {
        return getPassportNo();
    }

}
