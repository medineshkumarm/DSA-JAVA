import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;

    public MedianFinder() {
        pq1 = new PriorityQueue<>(Collections.reverseOrder());
        pq2 = new PriorityQueue<>();
    }

    void add(int val) {
        if (pq1.size() == 0 && pq2.size() == 0) {
            pq1.add(val);
        } else {
            if (val < pq1.peek()) {
                pq1.add(val);
            } else {
                pq2.add(val);
            }
        }

        int diff = Math.abs(pq1.size() - pq2.size());
        if (diff > 1) {
            if (pq1.size() > pq2.size()) {
                pq2.add(pq1.remove());
            } else {
                pq1.add(pq2.remove());
            }
        }
    }

    int findMedian() {
        if (pq1.size() >= pq2.size()) {
            return pq1.peek();
        } else {
            return pq2.peek();
        }
    }

    int remove() {
        if (pq1.size() >= pq2.size()) {
            return pq1.remove();
        } else {
            return pq2.remove();
        }
    }
}

public class Median {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();

        medianFinder.add(1);
        medianFinder.add(2);
        medianFinder.add(16);
        medianFinder.add(3);

        System.out.println("Final Median: " + medianFinder.findMedian());
        medianFinder.add(9);
        System.out.println("Final Median: " + medianFinder.findMedian());
        medianFinder.add(6);
        medianFinder.add(4);
        System.out.println("Removed element: " + medianFinder.remove());
        System.out.println("Final Median: " + medianFinder.findMedian());

    }

}
