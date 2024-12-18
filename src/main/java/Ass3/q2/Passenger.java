public class Passenger {
    private String passportNo;
    private String fareCode;
    private String flyerStatusCode;
    private Date registerationDate;

    public Passenger(String passportNo, String fareCode, String flyerStatusCode, Date registerationDate) {
        this.passportNo = passportNo;
        this.fareCode = fareCode;
        this.flyerStatusCode = flyerStatusCode;
        this.registerationDate = new Date();
    }
}
