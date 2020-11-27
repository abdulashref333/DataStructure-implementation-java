package LinkedList;

public class LinkedList<E>   {
    class Node<E>{
        E data;
        Node<E> next;
        // this is the constructor ..just for initializing the node
        public Node(E obj){
            data = obj;
            next = null;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public LinkedList(){
        head = tail = null;
        currentSize = 0;
    }

    public void addFirst(E obj){
        Node<E> node = new Node<E>(obj);
        if(head == null){
            tail = node;
        }
        node.next = head;
        head = node;
        currentSize++;
    }

    public void addLast(E obj){
        Node<E> node = new Node<E>(obj);
        if(tail==null){
            head = tail = node;
        }else{
//            Node<E> tmp = head;
//            while( tmp.next!=null){
//                tmp=tmp.next;
//            }
//            tmp.next = node;
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
        Node<E> tmp = head;
        for(int n =1; n<currentSize-1; n++){
            tmp = tmp.next;
        }
        tail = tmp;
        tmp.next = null;
        currentSize--;
        return tmp.data;
    }

    public E remove(E obj){
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
                    return current.data;
                }
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    //[1,2,3].contains(3) >> true
    //Note i mean [1,2,3] this is your linkedList not an array.
    public boolean contains(E obj){
        Node<E> current = head;
        while(current != null){
            if((((Comparable<E>)current.data).compareTo(obj)) == 0 ){
                return true;
            }
        }
        return false;
    }

    public E peekFirst(){
        if(head == null){
            return null;
        }
        return head.data;
    }

    public E peekLast(){
        if(head == null){
            return null;
        }
        return tail.data;
    }
}