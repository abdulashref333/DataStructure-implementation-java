package priority;

import Queue.ArrayQueue;
import Queue.LinkedQueue;
// question 4

public class ArrayPriorityQue<E> {
    private int size;
    private ArrayQueue<E>[] queues;
    private int highest;

    public ArrayPriorityQue(){
        size = 0;
        highest = 0;
        queues = (ArrayQueue<E>[]) new ArrayQueue[5];
    }

    public ArrayPriorityQue(int highest){
        this();
        queues = (ArrayQueue<E>[]) new ArrayQueue[highest+1];
    }

    public void add(E item,int priority) {

        if(priority >= queues.length){
            System.out.println("it's high priority");
            return ;
        }
        if(priority >= highest) highest = priority; //the highest always up to date..
        //if this place don't have any que yet ,define a new que then add item.
        if(queues[priority] == null){
            queues[priority] = new ArrayQueue<E>();
        }
        queues[priority].add(item);
        size ++;
    }

    public E remove() {
        if(size == 0) {
            System.out.println("it's empty que!");
            return null;
        }
        E element = queues[highest].remove();
        // must update the highest if the highest que become empty.
        if(queues[highest].getSize() == 0) {
            for (int i = highest-1; i>=0; i--){
                if(queues[i]==null) continue;
                if(queues[i].getSize()>0){
                    highest = i;
                    break;
                }
            }
        }
        size --;
       return element;
    }

    public int getSize() {
        return size;
    }
}
