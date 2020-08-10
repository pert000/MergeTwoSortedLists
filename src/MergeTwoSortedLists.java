import org.w3c.dom.Node;

public class MergeTwoSortedLists {

    public static void main(String[] args) {



        int[] keys = { 1, 2, 3, 4, 5, 6, 7 };

        ListNode a = null, b = null;
        for (int i = keys.length - 1; i >= 0; i = i - 2) {
            a = new ListNode(keys[i], a);
        }

        for (int i = keys.length - 2; i >= 0; i = i - 2) {
            b = new ListNode(keys[i], b);
        }

        printList("First: ", a);
        printList("Second: ", b);

        ListNode head = mergeTwoLists(a, b);
        printList("After Merge : ", head);


    }

    public static void printList(String msg, ListNode head)
    {
        System.out.print(msg);

        ListNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val + " -> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp_node = new ListNode(0);
        ListNode current_node = temp_node;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                current_node.next = l1;
                l1 = l1.next;
            } else {
                current_node.next = l2;
                l2 = l2.next;
            }
            current_node = current_node.next;
        }

        if (l1 != null) {
            current_node.next = l1;
            l1 = l1.next;
        }
        if (l2 != null) {
            current_node.next = l2;
            l2 = l2.next;
        }
        return temp_node.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}

