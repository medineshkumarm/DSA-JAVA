import java.util.*;

class Pair implements Comparable<Pair> {
    int val;
    int li;
    int di;

    Pair(int val, int li, int di) {
        this.val = val;
        this.li = li;
        this.di = di;
    }

    public int compareTo(Pair o) {
        return this.val - o.val;
    }
}

public class MergeSortedKList {
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                int n = input.nextInt();
                ArrayList<Integer> l = new ArrayList<>();
                while (n-- > 0) {
                    l.add(input.nextInt());
                }
                lists.add(l);
            }

            ArrayList<Integer> ans = mergeSortedLists(lists);
            System.out.println(ans);
        }

        // try (Scanner input = new Scanner(System.in)) {
        // int[][] arr = new int[6][2];
        // for (int i = 0; i < 6; i++) {
        // arr[i][0] = input.nextInt();
        // arr[i][1] = input.nextInt();
        // }
        // int[][] ans = KClosestPoints(arr, 3);
        // for (int[] a : ans) {
        // System.out.println("{" + a[0] + " " + a[1] + "}");
        // }
        // }
    }

    public static ArrayList<Integer> mergeSortedLists(ArrayList<ArrayList<Integer>> lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {
            pq.add(new Pair(lists.get(i).get(0), i, 0));
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (pq.size() != 0) {
            Pair rp = pq.remove();
            ans.add(rp.val);

            if (rp.di + 1 < lists.get(rp.li).size()) {
                pq.add(new Pair(lists.get(rp.li).get(rp.di + 1), rp.li, rp.di + 1));
            }
        }
        return ans;
        // 10 22 28 35 40
        // 4
        // 6 11 15 18
        // 4
        // 3 9 21 36
        // 5
        // 1 2 3 4 5

        // Sol'n: [1, 2, 3, 3, 4, 5, 6, 9, 10, 11, 15, 18, 21, 22, 28, 35, 36, 40]
    }

    public static int[][] KClosestPoints(int[][] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        int[][] ans = new int[k][2];

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        for (int i = 0; i < k; i++) {
            ans[i] = pq.remove();
        }
        return ans;
        // PS C:\Users\dines\Desktop\DSA Coursera\scalar_Java\Heap> java
        // MergeSortedKList
        // 3 3 5 -1 -2 4 1 4 -2 3 4 3
        // sol:
        // {3 3}
        // {1 4}
        // {-2 3}
    }
}