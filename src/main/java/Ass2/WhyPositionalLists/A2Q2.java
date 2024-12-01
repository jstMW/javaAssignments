package WhyPositionalLists;

public class A2Q2 {
    public static void main(String[] args) {

        UnsafePositionalList<Integer> unsafeList = new UnsafePositionalList<Integer>();

        for (int i = 0; i < 10; i++) {
            unsafeList.addLast(i);
        }

        // set test on the first node!
        PLNode<Integer> test = unsafeList.first();

        System.out.println("header --> " + test.getPrev().getElement());

        // iterating over regular nodes
        for (int i = 0; i < 10; i++) {
            System.out.println(test.getElement());
            test = test.getNext();
        }

        System.out.println("trailer --> " + test.getElement());
        System.out.println(
                "here we see that the sentinels are exposed to the user without existence of position() method\n");
        System.out.println("If you try to go more we will get the null pointer exception though");
        test = test.getNext();
        System.out.println(
                "this is not actually plnode just a null **can't even use getClass() we only get error when we want to dereferencing it --> "
                        + test + "\n");

        // uncomment for null pointer exception
        // test.getNext();
        // System.out.println(test.getClass());

        System.out.println("as explained above one of the ways is to check whether the node is sentinel or not");
        System.out.println("I still don't understand why positions!!");

        PLNode<Integer> outsider = new PLNode<Integer>(null, null, 200);
        PLNode<Integer> randomInsider = unsafeList.first().getNext().getNext().getNext().getNext().getNext();

        randomInsider.setNext(outsider);
        System.out.println("do the exact same loop!");

        // set test on the first node!
        PLNode<Integer> test2 = unsafeList.first();
        System.out.println("header --> " + test2.getPrev().getElement());
        // iterating over regular nodes
        /*
         * I comment it since it generate an exception!
         * for (int i = 0; i < 10; i++) {
         * // it should raise the null pointer exception right after it want to
         * dereference
         * // the outsider plnode!!
         * System.out.println(test2.getElement());
         * test2 = test2.getNext();
         * }
         */
        // output: 0 1 2 3 4 5 200(new invalid node) NUllPointerException!
        // how to fix: 1--> don't give the user ability to user to use the PLNode
        // methods!
        // 2--> wrapp the node in a higher level class and implement some checkpoints!

        // since previous time we add an invalid node we kind of messed up the list so
        // let's refresh it first
        unsafeList = new UnsafePositionalList<Integer>();

        for (int i = 0; i < 10; i++) {
            unsafeList.addLast(i);
        }

        unsafeList.last().setNext(unsafeList.first());
        // yes it is allowed
        // set test on the first node!
        PLNode<Integer> test3 = unsafeList.first();
        // iterating over regular nodes
        for (int i = 0; i < 50; i++) {
            // It will be like a ring(circularly) and never gets out of bound!
            System.out.println(test3.getElement());
            test3 = test3.getNext();
        }
        // also sentinels doesn't really make sense at this point since we get rid of
        // them technically ***we can retrieve the header though
        System.out.println("header --> " + unsafeList.first().getPrev().getElement());

    }

}
