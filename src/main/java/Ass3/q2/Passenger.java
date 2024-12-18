public class Passenger {
    private String passportNo;
    private String fareCode;
    private String flyerStatusCode;
    private Date registerationDate;

    public Passenger(String passportNo, String fareCode, String flyerStatusCode, Date registerationDate) {
        this.passportNo = passportNo;
        this.fareCode = Fare.randomValue();
        this.flyerStatusCode = FlyerStatus.randomValue();
        this.registerationDate = new Date();
    }

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
}
