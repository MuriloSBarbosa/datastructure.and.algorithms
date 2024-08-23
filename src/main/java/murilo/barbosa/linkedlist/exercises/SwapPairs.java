package murilo.barbosa.linkedlists.exercises;


import murilo.barbosa.common.leetcode.Node;

public class SwapPairs {

    public static void main(String[] args) {
        Node node = new Node();
        var result = node;

        for(int i = 1; i <= 4; i++) {
            node.val = i;
            if(i == 4) break;
            node.next = new Node();
            node = node.next;
        }
        node.next = null;

        swapPairs(result);
    }

    public static Node swapPairs(Node head) {
        var result = head;

        while(head != null && head.next != null) {
            var next =  head.next;

            var aux = head.val;
            head.val = next.val;
            next.val = aux;

            head = next.next;
        }

        return result;
    }
}
