package intro.linklist;

class MyLinkedList {
    Node head;
    Node tail;

    /** Initialize your data structure here. */
    public MyLinkedList() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (head == null){
            return -1;
        }
        Node cur = head ;
        for (int i = 1; i <= index; i++) {
            if (cur.next == null){
                return -1;
            }
            cur = cur.next;
        }
        return cur.value;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

    }

    public static class Node{
        private int value;
        private Node next;

        public Node(int value) { this.value = value; }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */