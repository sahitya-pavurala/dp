package gfg.ds.linkedlist;

public class LinkedList {

    Node head;

    class Node{

        int val;
        Node next = null;

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public LinkedList(Node head){
        this.head = head;
    }


}
