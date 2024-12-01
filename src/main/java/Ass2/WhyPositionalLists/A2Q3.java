package WhyPositionalLists;

import java.util.Random;

public class A2Q3 {
    static Random rand = new Random();
    public static void main(String[] args) {

        test(construct("test1", 10), "test1");
        test(construct("test1", 20), "test2");
        test(construct("test1", 30), "test3");


    }

    public static int removeConsecutiveDuplicates(UnsafePositionalList<String> list) {
        int size = list.size();
        PLNode<String> pred = list.first();
        for (int i = 0; i < size; i++) {
            PLNode<String> succ = pred.getNext();
            if (pred.getElement().equals(succ.getElement())) {
                System.out.println("removing duplicates " + succ.getElement());
                list.remove(succ);
            } else {
                pred = succ;
            }
        }
        return list.size();
    }

    public static String randomUpperCaseLetter() {
        char c = (char) rand.nextInt(65, 70);
        return Character.toString(c);
    }

    public static void printUnsafePositionalList(UnsafePositionalList<String> list) {
        PLNode<String> first =  list.first();
        for (int i=0; i<list.size(); i++) {
            System.out.print(first.getElement() + " ");
            first = first.getNext();
        }
        System.out.println();
    }

    public static UnsafePositionalList<String> construct(String name_of_test, int size) {
        UnsafePositionalList<String> test = new UnsafePositionalList<>();
        System.out.print("Constructing " + name_of_test + "...\n" + "[");
        for (int i = 0; i < size; i++) {
            String s = randomUpperCaseLetter();
            test.addLast(s);
            System.out.print("\"" + s + "\"" + ", ");
            if (rand.nextBoolean()) {
                test.addLast(s);
                System.out.print("\"" + s + "\"" + ", ");
            }
        }
        //just delete the last ", "
        System.out.println("\b\b" + "]");
        return test;
    }

    public static void test(UnsafePositionalList<String> list, String name_of_test) {
        System.out.println("Working on " + name_of_test + " UnsafePositionalList...");
        System.out.print("Before cleaning (number: " + list.size() + ") --> ");
        printUnsafePositionalList(list);
        int result1 = removeConsecutiveDuplicates(list);
        System.out.print("After cleaning (number: " + list.size() + ") --> ");
        printUnsafePositionalList(list);
        System.out.println("\n");
    }
}
