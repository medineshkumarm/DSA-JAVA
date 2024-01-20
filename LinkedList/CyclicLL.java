import java.util.Scanner;

public class CyclicLL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ListNode head = new ListNode(scanner.nextInt());
        ListNode temp = head;
        ListNode temp1 = head, temp2 = head;

        while (n-- > 1) {
            temp.next = new ListNode(scanner.nextInt());
            temp = temp.next;

            if (n == 4) {
                temp1 = temp;
            }
            temp2 = temp;
        }
        temp2.next = temp1;

        System.out.println("Does it has a cycle:" + hasCycle(head));
        System.out.println("First node of the cycle in LL: " + firstNodeOfCycle(head));
        scanner.close();
    }

    public static int firstNodeOfCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            return -1;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        if (fast.next == null || fast.next.next == null) {
            return false;
        }
        return true;
    }
}
