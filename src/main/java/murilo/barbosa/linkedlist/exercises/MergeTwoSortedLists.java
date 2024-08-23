package murilo.barbosa.linkedlists.exercises;

import murilo.barbosa.common.leetcode.Node;

public class MergeTwoSortedLists {

    public Node mergeTwoLists(Node list1, Node list2) {
        Node current = new Node();
        var r = current;
        while (list1 != null && list2 != null) {
            var value1 = list1.val;
            var value2 = list2.val;

            int value;

            if (value1 < value2) {
                value = value1;
                list1 = list1.next;
            } else {
                value = value2;
                list2 = list2.next;
            }

            current.next = new Node(value);
            current = current.next;
        }

        return r;
    }
}
