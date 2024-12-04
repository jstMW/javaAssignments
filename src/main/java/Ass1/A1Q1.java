Package Ass1;
public class A1Q1 {
    public static String prettyBrackets(String s) {
        final String opening = "({[";
        final String closing = ")}]";
        LinkedStack<Character> stk = new LinkedStack<>();
        StringBuilder prettyS = new StringBuilder();

        for (char c: s.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                stk.push(c);
                prettyS.append("\t".repeat(stk.size()-1) + c + "\n");
            } else if (closing.indexOf(c) != -1) {
                if (stk.isEmpty()) {
                    continue;
                }
                if (stk.top() != opening.charAt(closing.indexOf(c))) {
                    continue; //ignore!
                } else {
                    prettyS.append("\t".repeat(stk.size()-1) + c + "\n");
                    stk.pop();
                }
            }

        }

        return prettyS.toString();
    }

    public static void main(String[] args) {
        System.out.println(prettyBrackets("{[{}{}{()}]}"));
        System.out.println(prettyBrackets("{(abc)def{ghi))}]}"));
        System.out.println(prettyBrackets(""));
        System.out.println(prettyBrackets("{(dsf){(){dfaads(){sdf(){sdf[]sdf}}asdfahahsdafa}}}"));
    }

}
