import java.util.*;

public class SmallestElement {
    public static void main (String args[]){
        try (Scanner input = new Scanner (System.in)) {
            int n = input.nextInt();
            System.out.println(solution(n));
        }
    }

    public static int solution(int n){
        String ans = "";
        for(int div = 9; div >=2 ; div--){
            while(n % div == 0){
                n = n / div;
                ans = div + ans;
            }

        }
        if(n != 1){
            return -1;
        }else{
            return Integer.parseInt(ans);
        }
    }
}

// Time Complexity: O(logbase2 n)
// Space Complexity: O(1)