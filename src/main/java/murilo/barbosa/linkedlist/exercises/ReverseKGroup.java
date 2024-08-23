package murilo.barbosa.linkedlists.exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import murilo.barbosa.common.leetcode.Node;

public class ReverseKGroup {

    public static void main(String[] args) {
        Node node = new Node();
        var result = node;

        var count = 5;
        for (int i = 1; i <= count; i++) {
            node.val = i;
            if (i == count) {
                break;
            }
            node.next = new Node();
            node = node.next;
        }

        reverseKGroupBigN(result, 2);
    }


    public Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;

        return head;
    }


    public static Node reverseKGroupBigN(Node head, int k) {
        var result = head;

        while (head != null && head.next != null) {
            List<Integer> nodeArray = new ArrayList<>(k);

            var aux = head;
            var count = 0;
            for (int i = 0; i < k; i++) {
                if (aux != null) {
                    nodeArray.add(aux.val);
                    aux = aux.next;
                    count++;
                }
            }

            Collections.reverse(nodeArray);

            if (count == k) {
                for (int i = 0; i < k; i++) {
                    head.val = nodeArray.get(i);
                    head = head.next;
                }
            } else {
                break;
            }
        }

        return result;
    }
}
