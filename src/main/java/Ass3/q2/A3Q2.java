import java.util.Scanner;
public class A3Q2 {
    public static void main(String[] args) {
         
        //Add 10 passengers
        Scanner kbd = new Scanner(System.in);
        Passenger p1 = new Passenger(kbd.next());
        Passenger p2 = new Passenger(kbd.next());
        Passenger p3 = new Passenger(kbd.next());
        Passenger p4 = new Passenger(kbd.next());
        Passenger p5 = new Passenger(kbd.next());
        Passenger p6 = new Passenger(kbd.next());
        Passenger p7 = new Passenger(kbd.next());
        Passenger p8 = new Passenger(kbd.next());
        Passenger p9 = new Passenger(kbd.next());
        Passenger p10 = new Passenger(kbd.next());

        //Add them to queue
        HeapPriorityQueue hpq = new HeapPriorityQueue();

        hpq.add(p1);
        hpq.add(p2);
        hpq.add(p3);
        hpq.add(p4);
        hpq.add(p5);
        hpq.add(p6);
        hpq.add(p7);
        hpq.add(p8);
        hpq.add(p9);
        hpq.add(p10);


        //Board 5 Passenger
        hpq.removeMin();
        hpq.removeMin();
        hpq.removeMin();
        hpq.removeMin();
        hpq.removeMin();

        //Add 5 more passenger
        Passenger p11 = new Passenger(kbd.next());
        Passenger p12 = new Passenger(kbd.next());
        Passenger p13 = new Passenger(kbd.next());
        Passenger p14 = new Passenger(kbd.next());
        Passenger p15 = new Passenger(kbd.next());

        hpq.add(p11);
        hpq.add(p12);
        hpq.add(p13);
        hpq.add(p14);
        hpq.add(p15);

        //Board the rest
        hdq.removeMin();
        hdq.removeMin();
        hdq.removeMin();
        hdq.removeMin();
        hdq.removeMin();
        hdq.removeMin();
        hdq.removeMin();
        hdq.removeMin();
        hdq.removeMin();
        hdq.removeMin();

    }
}
