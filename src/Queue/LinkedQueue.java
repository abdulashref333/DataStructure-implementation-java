package Queue;

public class LinkedQueue<E>{
    private class Node<E> {
         E data;
         Node<E> next;
        public Node(E item,Node link) {
            data = item;
            next = link;
        }
    }
    private Node<E> front, rear;
    protected int size;

    public LinkedQueue(){
        front = rear = null;
        size = 0;
    }

    public void add(E obj){
        Node<E> node = new Node<E>(obj,null);
        if(front == null){
            front = rear = node;
            size++;
            return;
        }
        rear.next = node;
        rear = node;
        size++;
    }

    public E remove(){
        if(front == null)   return null;
        E tmp = front.data;
        front = front.next;
        size--;
        if(size==0) rear = null;
        //if the queue is empty must make rear point to null,cause if not it still point to the first element.
        return tmp;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public boolean isFull() {
        return false;
    }
    public E getFront() {
        if(front==null) return null;
        return (E)front.data;
    }
    public E getRear() {
        if(front==null) return null;
        return (E) rear.data;
    }
    public int getSize() {
        return size;
    }

    public void setFront(Node<E> front) {
        this.front = front;
    }

    public void setRear(Node<E> rear) {
        this.rear = rear;
    }
}