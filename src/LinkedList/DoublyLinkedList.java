package LinkedList;

public class DoublyLinkedList<E>{

    class Node<E>{
        E data;
        Node<E> next, previous;
        // this is the constructor ..just for initializing the node
        public Node(E obj){
            data = obj;
            next = previous = null;
        }
    }
    // this is the main fields needed to build a doubly linked list
    private Node<E> head, tail;
    private int currentSize;


    public DoublyLinkedList() {
        head = tail = null;
        currentSize = 0;
    }

    public void addAfter(int pos, E obj) {

        if(head==null || pos>currentSize){
            System.out.println("There is no element in this position.");
            return;
        }
        Node<E> node = new Node<E>(obj);
        Node<E> tmp = head;
        for (int i=1; i<pos; i++){
            tmp = tmp.next;
        }

        node.previous = tmp;
        node.next = tmp.next;
        tmp.next = node;
        if(tmp != tail){
            node.next.previous = node;
        }else{
            tail = node;
        }
        currentSize ++;
    }

    public E remove(E obj) {
        Node<E> current = head, previous = null;
        while(current != null){
            if((((Comparable<E>)current.data).compareTo(obj)) == 0 ){
                currentSize--;
                // if (single element or in the beginning) the case is the same behavior >> removeFirst.
                if(head == tail || current == head){
                    return removeFirst();
                }else if(current == tail){
                    return removeLast();
                }else{
                    previous.next = current.next;
                    current.next.previous = current.previous;
                    return current.data;
                }
            }
            previous = current;
            current = current.next;
        }
        System.out.println("This isn't a valid argument.");
        return null;
    }
    public void addFirst(E obj){
        Node<E> node = new Node<E>(obj);
        //if list is empty -> then you made the tail point to the new node.
        if(head == null){
            tail = head = node;
            currentSize ++;
            return;
        }
        node.next = head;
        head.previous = node;
        head = node;
        currentSize++;
    }

    public void addLast(E obj){
        Node<E> node = new Node<E>(obj);
        //if empty.
        if(tail==null){
            head = tail = node;
        }else{
            // if you haven't  tail object you need to loop to access the last element.
//            Node<E> tmp = head;
//            while( tmp.next!=null){
//                tmp=tmp.next;
//            }
//            tmp.next = node;
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
        currentSize++;
    }

    public E removeFirst(){
        if(head == null){
            return null;
        }
        E data = head.data;
        // if it has a single element we should check that condition.
        if(head == tail){
            head = tail = null;
        }else {
            head = head.next;
        }
        currentSize--;
        return data;
    }

    public E removeLast(){

        if(head == null){
            return null;
        }

        if(head==tail){
            currentSize --;
            return removeFirst();
        }

        Node<E> tmp = head;
        for(int n =1; n<currentSize-1; n++){
            tmp = tmp.next;
        }

        tail = tmp;
        tmp.next = null;
        currentSize--;

        return tmp.data;
    }
    // to see the first element in the list.
    public E peekFirst(){
        if(head == null){
            return null;
        }
        return head.data;
    }
    // to see the last element in the list.
    public E peekLast(){
        if(head == null){
            return null;
        }
        return tail.data;
    }

    public int getCurrentSize(){
        return currentSize;
    }
    // pass element to this function and see if the list contained this element or not.
    public boolean contains(E obj){
        Node<E> current = head;
        while(current != null){
            if((((Comparable<E>)current.data).compareTo(obj)) == 0 ){
                return true;
            }
            current = current.next;
        }
        return false;
    }
}