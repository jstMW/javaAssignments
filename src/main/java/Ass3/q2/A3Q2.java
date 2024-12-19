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

        hpq.insert(p1);
        hpq.insert(p2);
        hpq.insert(p3);
        hpq.insert(p4);
        hpq.insert(p5);
        hpq.insert(p6);
        hpq.insert(p7);
        hpq.insert(p8);
        hpq.insert(p9);
        hpq.insert(p10);


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

        hpq.insert(p11);
        hpq.insert(p12);
        hpq.insert(p13);
        hpq.insert(p14);
        hpq.insert(p15);

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

            for (int i = 0; i < heap.length; i++) {
                if (count == 0) {
                    System.out.print("| Level " + level + " | ");
                }

                System.out.print(heap[i] + " ");
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
}










