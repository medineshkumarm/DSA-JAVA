import java.util.*;

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements in the linked list:");
        int n = scanner.nextInt();

        ListNode head = null;
        ListNode tail = null;

        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            ListNode newNode = new ListNode(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.println("Original linked list:");
        print(head);

        // Reverse the linked list
        head = reverse(head);

        System.out.println("\nReversed linked list:");
        print(head);

        System.out.println("middle element: " + middleNode(head));
        System.out.println(isPalindrome(head));
        System.out.println();
        System.out.println("Enter the value of K: ");

        int k = scanner.nextInt();

        System.out.println("Reverse" + k + "nodes");
        print(kReverse(head, k));


        scanner.close();
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // preserving curr.next node

            curr.next = prev; // updating current.next postion address with previous address

            // moving prev and curr pointers
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static int middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = reverse(slow.next);
        ListNode first = head;

        while (first != null && second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;

    }

    public static ListNode kReverse(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pointer = dummy;

        while (pointer != null) {
            // check if there are k nodes present:
            ListNode node = pointer;
            for (int i = 0; i < k && node != null; i++) {
                node = node.next;
            }
            if (node == null) {
                // there are less than k nodes available
                break;
            }

            // reverse k nodes
            ListNode prev = null;
            ListNode curr = pointer.next;

            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;

                prev = curr;
                curr = next;
            }
            ListNode tail = pointer.next;
            pointer.next = prev;

            tail.next = curr;
            pointer = tail;

        }
        return dummy.next;
    }

}