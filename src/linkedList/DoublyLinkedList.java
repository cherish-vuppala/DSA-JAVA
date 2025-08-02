package linkedList;

public class DoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node back;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }


        @Override
        public String toString() {
            return STR."Node{data=\{data}, next=\{next != null ? next.data : "null"}, back=\{back != null ? back.data : "null"}\{'}'}";
        }

    }

    private Node head;
    private Node tail;

    public void addLast(int data) {
        var newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }

       tail.next = newNode;
        newNode.back = tail;

        tail = newNode;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.back = newNode;

        head = newNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        var curr = head;
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null) {
                sb.append("<->");
            }
            curr = curr.next;
        }

        return sb.toString();
    }
}
