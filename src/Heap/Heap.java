package Heap;

public class Heap<E> {
//    class Node<E>{
//        E data;
//        Node<E> next_l,next_r,previous;
//
//        public Node(E obj){
//            next_l = next_r = previous = null;
//            data = obj;
//        }
//    }

    private int lastPosition;
    private E[] array;
//    private Node<E> root;
    private int size ;
    public Heap(){
        size = 0;
        lastPosition = -1;
        array = (E[]) new Object();
//        root = null ;
    }

    public void add(E obj){
        array[++lastPosition] = obj;
        trickleUp(lastPosition);
    }

    public void trickleUp(int pos){
        if(pos == 0) // if it's empty go out of here.
            return ;
        int parent =(int) Math.floor((pos-1)/2);

        // iterative solution
//        while(((Comparable<E>)array[pos]).compareTo(array[parent])>0){
//            swap(parent, pos);
//            pos = parent ;
//            parent = ((parent-1)/2);
//        }

        // recursive solution
        if(((Comparable<E>)array[pos]).compareTo(array[parent])>0){
            swap(pos, parent);
            trickleUp(parent);
        }
    }

    public void swap(int from, int to){
        E tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }

    public void trickleDown(int pos){
        
    }

}
