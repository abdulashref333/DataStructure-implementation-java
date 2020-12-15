package priority;

import Queue.LinkedQueue;
// question 5
public class PriorityQue<E> extends LinkedQueue {
    private class Node<E>{
        E data;
        int priority;
        Node<E> next;
        public Node(E item,int pr){
            data = item;
            priority = pr;
        }
    }
    Node<E> front, rear;
    public PriorityQue(){
        front = rear = null;
    }

    public void add(E item, int pr) {
        Node<E> node = new Node<E>(item, pr);
        size++;
        if(front == null){
            front = rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }
    public E remove(){
        if(isEmpty())   return null;

        Node<E> tmp = front, highest ,cursor, chighe;
        highest = cursor = chighe = null;
        int highest_num = 0;

        while(tmp != null){
            if(tmp.priority > highest_num){
                highest_num = tmp.priority;
                highest = tmp;
                chighe = cursor;
            }
            cursor = tmp;
            tmp = tmp.next;
        }

        size --;
        if(chighe == null){ // if the highest priority at front , or priority == 0 or has one item
            highest = front;
            front = front.next; // move front to next
            if(front == null)   rear = null;
            return  highest.data;
        }

        chighe.next = highest.next;
        return highest.data;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
