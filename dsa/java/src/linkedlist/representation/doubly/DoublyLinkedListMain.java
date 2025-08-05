package linkedlist.representation.doubly;

/**
 * @author Ripan Baidya
 * @date 31-07-2025
 *
 * In this class, we will create a Doubly Linked List and perform various operations on it.
 * add - add element at first, addLast, addAt
 * delete - deleteFirst, deleteLast, deleteAt
 * display
 */
class DoublyLinkedList {
    private ListNode head = null;
    private int len = 0;

    // add element at first
    public void addFirst(int data) {
        ListNode newNode = new ListNode(data);

        // when ll is empty
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        len ++;
    }

    // add element at last
    public void addLast(int data) {
        ListNode newNode = new ListNode(data);

        if(head == null) {
            head = newNode;
        } else {
            ListNode curr = head;

            // move to the last element
            while(curr.next != null) {
                curr = curr.next;
            }

            curr.next = newNode;
            newNode.prev = curr;

            len ++;
        }
    }

    // add element at specific positon, 0-based indexing
    public void addAt(int data, int idx) {
        ListNode newNode = new ListNode(data);
        if(idx < 0 || idx >= len) {
            System.out.println("Invalid Index.");
            return;
        } else if (idx == 0) {
            addFirst(data);
        } else if (idx == len-1) {
            addLast(data);
        } else {
            ListNode curr = head;
            for(int i = 1; i <= idx-1; i ++) {
                curr = curr.next;
            }

            newNode.next = curr.next;
            curr.next.prev = newNode;
            newNode.prev = curr;
            curr.next = newNode;

            len ++;
        }
    }

    // delete first node
    public void deleteFirst() {
        if(len == 0) {
            System.out.println("List is empty");
        } else if(len == 1) {
            System.out.println("Node " + head.data + " deleted");
            head = head.next;
        } else {
            System.out.println("Node " + head.data + " deleted");
            head = head.next;
            head.next.prev = null;
        }
        len --;
    }

    // delete last node
    public void deleteLast() {
        if(len == 0) {
            System.out.println("List is empty");
        } else if (len == 1) {
            deleteFirst();
        } else {
            ListNode curr = head;

            while(curr.next.next != null) {
                curr = curr.next;
            }

            System.out.println("Node " + curr.next.data + " deleted");
            curr.next.prev = null;
            curr.next = null;
        }
        len --;
    }

    // delete node at specific index, 0 based
    public void deleteAt(int idx) {
        if (idx < 0 || idx >= len) {
            System.out.println("Invalid index");
            return;
        } else if (idx == 0) {
            deleteFirst();
        } else if (idx == len-1) {
            deleteLast();
        } else {
            ListNode curr = head;

            for(int i = 1; i <= idx-1; i ++) {
                curr = curr.next;
            }

            // store the element that need to be delete
            ListNode delElement = curr.next;
            System.out.println("Node " + delElement.data + " deleted");

            curr.next = delElement.next;
            delElement.next.prev = curr;
        }

        len --;
    }

    // find the length of doubly ll
    public int getLength() {
        return len;
    }

    // display elements
    public void display() {
        ListNode curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}
public class DoublyLinkedListMain {
    public static void main(String[] args) {
        DoublyLinkedList li = new DoublyLinkedList();

        // add method
        li.addFirst(10);
        li.addLast(20);
        li.addLast(30);
        li.addLast(40);
        li.addAt(100, 1);

        System.out.print("current elements: ");
        li.display();

        // delete method
//        li.deleteFirst();
//        li.deleteLast();
        li.deleteAt(6);

        System.out.print("current elements: ");
        li.display();

        System.out.println("current length: "+ li.getLength());
    }
}