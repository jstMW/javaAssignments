Package Ass1;
public class A1Q2 {
    public static String repeat1(char c, int n) {
        String result = "";
        for (int i=0; i<n; i++) {
            result = result + c;
        }
        return result;
    }
    public static String repeat2(char c, int n) {
        StringBuilder result = new StringBuilder();
        for (int i=0; i<n; i++) {
            result.append(c);
        }
        return result.toString();
    }

    public static void calculateRuntime(int n) {
        System.out.println("with n= " + n);
        long before = System.currentTimeMillis();
        repeat1('a', n);
        long after = System.currentTimeMillis();
        long difference = after-before;
        System.out.println("repeat1 method run in -->" + difference);


        before = System.currentTimeMillis();
        repeat2('a', n);
        after = System.currentTimeMillis();
        difference = after-before;
        System.out.println("repeat2 method run in -->" + difference + "\n");
    }

    public static void main(String[] args) {
        for (int j=1; j<=3; j++) {
            System.out.println("round number: " + j);
            for (int i = 1; i < 10000000; i *= 10) {
                calculateRuntime(i);
            }
        }
    }

}
