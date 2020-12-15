package Dequeue;

import Queue.LinkedQueue;

// question 7

public class Dequeue<E> extends LinkedQueue{
    private class Node<E> {
        E data;
        Node<E> next;
        public Node(E item, Node link) {
            data = item;
            next = link;
        }
    }
    private Node<E> front, rear;
    private int size;
    public Dequeue(){
       super();
    }
    public void addLast(E obj){
        Node<E> node = new Node<E>(obj,null);
        if(rear == null){
            front = rear = node;
        }else{
            rear.next = node;
            rear = node;
        }
        size++;
    }
    public E removeLast() {
        if(front == null){
            return null;
        }else{
            Node<E> tmp = front;
            Node<E> cursor = null;
            while(tmp.next != null){
                cursor = tmp;
                tmp = tmp.next;
            }
            if(cursor == null){ //if list have one item.
                front = rear = null;
                size --;
                return tmp.data;
            }
            cursor.next = null;
            rear = cursor;
            size --;
            return tmp.data;
        }
    }
}
