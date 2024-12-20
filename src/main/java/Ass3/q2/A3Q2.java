package Ass3.q2;
import java.util.Scanner;
public class A3Q2 {
    public static void main(String[] args) {
         
        Scanner kbd = new Scanner(System.in);
        HeapPriorityQueue<Passenger, String> hpq = new HeapPriorityQueue<>();

        Passenger  test  = new Passenger("test");
        System.out.println(test);
        System.out.println("Passport: " + test.getPassportNo() + ", Fare: " + test.getFareCode() + ", FlyerStatus: " + test.getFlyerStatusCode() + ", Time: " + test.getRegisterationDate());
        //Add 10 passengers and Add them to queue
        for (int i=0; i<10; i++) {
            System.out.println("----------------------------------");
            Passenger p = add_passenger(kbd, hpq);
            System.out.println("Adding Passenger: ");
            printQ(hpq, p);
            System.out.println("----------------------------------");
        }

        //Board 5 Passenger
        for (int i=0; i<5; i++) {
            System.out.println("----------------------------------");
            System.out.println("Boarding Passenger: ");
            printQ(hpq, hpq.removeMin().getKey());
            System.out.println("----------------------------------");
        }

        //Add 5 more passenger
        for (int i=0; i<5; i++) {
            System.out.println("----------------------------------");
            Passenger p = add_passenger(kbd, hpq);
            System.out.println("Adding Passenger: ");
            printQ(hpq, p);
            System.out.println("----------------------------------");
        }

        //Board the rest
        for (int i=0; i<10; i++) {
            System.out.println("----------------------------------");
            System.out.println("Boarding Passenger: ");
            printQ(hpq, hpq.removeMin().getKey());
            System.out.println("----------------------------------");
        }

    }

    public static Passenger add_passenger(Scanner kbd, HeapPriorityQueue hpq) {
        System.out.println("Enter passport no of new passenger: ");
        Passenger p = new Passenger(kbd.next());
        hpq.insert(p, p.getPassportNo());
        return p;
    }

    public static void printQ(HeapPriorityQueue hpq, Passenger p) {
        System.out.println("Passport: " + p.getPassportNo() + ", Fare: " + p.getFareCode() + ", FlyerStatus: " + p.getFlyerStatusCode() + ", Time: " + p.getRegisterationDate());
        System.out.print("Standby list: " + hpq);
    }

}