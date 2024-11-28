package WhyPositionalLists;

public class Driver {
    public static void main(String[] args) {

        UnsafePositionalList<Integer> unsafeList = new UnsafePositionalList<Integer>();

        for (int i = 0; i < 10; i++) {
            unsafeList.addLast(i);
        }

        //set test on the first node!
        PLNode<Integer> test = unsafeList.first();

        System.out.println("header --> " + test.getPrev().getElement());

        //iterating over regular nodes
        for (int i = 0; i < 10; i++) {
            System.out.println(test.getElement());
            test = test.getNext();
        }

        System.out.println("trailer --> " + test.getElement());
        System.out.println("here we see that the sentinels are exposed to the user without existence of position() method\n");
        System.out.println("If you try to go more we will get the null pointer exception though");
        test = test.getNext();
        System.out.println("this is not actually plnode just a null **can't even use getClass() we only get error when we want to dereferencing it --> " + test + "\n");


        //uncomment for null pointer exception
        //test.getNext();
        //System.out.println(test.getClass());

        System.out.println("as explained above one of the ways is to check whether the node is sentinel or not");
        System.out.println("I still don't understand why positions!!");

    }

}
