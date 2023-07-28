package medium;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}

class CustomStack {
    Node head;
    Node tail;

    CustomStack() {
        head = null;
        tail = null;
    }

    public void push(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            tail = newnode;
            tail.next = null;
            head.prev = null;
        } else {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }


    public int pop() {
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        return temp.data;
    }

    public void merge(CustomStack s) {
        head.prev = s.tail;
        s.tail.next = head;
        head = s.head;
        s.tail = null;
        s.head = null;
    }
}

public class MergeableStack {
    public static void main(String[] args) {
        CustomStack st1 = new CustomStack();
        CustomStack st2 = new CustomStack();
        st1.push(1);
        st1.push(2);
        st1.push(3);
        st1.push(4);

        st2.push(1);
        st2.push(2);
        st2.push(3);
        st2.push(4);
        st1.merge(st2);
        Node temp = st1.head;
        while(temp!=null){
            System.out.print(temp.data);
            temp=temp.next;
        }
    }
}
