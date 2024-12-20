package Ass3.q2;
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

        hpq.insert(p1, p1.getPassportNo());
        hpq.insert(p2, p2.getPassportNo());
        hpq.insert(p3, p3.getPassportNo());
        hpq.insert(p4, p4.getPassportNo());
        hpq.insert(p5, p5.getPassportNo());
        hpq.insert(p6, p6.getPassportNo());
        hpq.insert(p7, p7.getPassportNo());
        hpq.insert(p8, p8.getPassportNo());
        hpq.insert(p9, p9.getPassportNo());
        hpq.insert(p10, p10.getPassportNo());


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

        hpq.insert(p11, p11.getPassportNo());
        hpq.insert(p12, p12.getPassportNo());
        hpq.insert(p13, p13.getPassportNo());
        hpq.insert(p14, p14.getPassportNo());
        hpq.insert(p15, p15.getPassportNo());

        //Board the rest
        hpq.removeMin();
        hpq.removeMin();
        hpq.removeMin();
        hpq.removeMin();
        hpq.removeMin();
        hpq.removeMin();
        hpq.removeMin();
        hpq.removeMin();
        hpq.removeMin();
        hpq.removeMin();

    }

    public static void printQ(HeapPriorityQueue hpq) {
            int level = 0;
            int count = 0;
            int nodesInLevel = 1;

            System.out.println("----------------------------------");

            for (int i = 0; i < hpq.size(); i++) {
                if (count == 0) {
                    System.out.print("| Level " + level + " | ");
                }

                //System.out.print(hpq + " ");
                count++;

                if (count == nodesInLevel) {
                    System.out.println("|");
                    level++;
                    count = 0;
                    nodesInLevel = (int) Math.pow(2, level);
                }
            }

            if (count > 0) {
                System.out.println("|");
            }

            System.out.println("----------------------------------");
    }

}