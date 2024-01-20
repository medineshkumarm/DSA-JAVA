import java.util.*;

public class RevPolNum {
    public static void main(String[] args) {
        String[] exp = { "2", "3", "*", "4", "+" };
        System.out.println(calculateRN(exp));
    }

    public static int calculateRN(String[] exp) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < exp.length; i++) {
            String str = exp[i];

            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int pop1 = st.pop();
                int pop2 = st.pop();

                st.push(solve(pop2, pop1, str));
            } else {
                st.push(Integer.parseInt(str));
            }

        }
        return st.pop();
    }

    public static int solve(int pop2, int pop1, String optr) {
        if (optr.equals("*")) {
            return pop2 * pop1;
        } else if (optr.equals("+")) {
            return pop2 + pop1;
        } else if (optr.equals("-")) {
            return pop2 - pop1;
        } else {
            return pop2 / pop1;
        }
    }
}

//T.C = O(n)
//S.C = O(d) --> no.of.operands