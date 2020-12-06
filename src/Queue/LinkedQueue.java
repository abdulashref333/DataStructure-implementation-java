package Queue;

//import node.Node;

import node.Node;
//
//public class LinkedQueue<E> {
//    private Node<E> front;
//    private Node<E> rear;
//    private int NumOfElements;
//    public LinkedQueue(){
//        front=null;
//        rear=null;
//        NumOfElements=0;
//    }
//    public boolean IsEmpty(){
//        if(NumOfElements==0)
//            return true;
//        else
//            return false;
//    }
//    public void Add(E element)
//    {
//        if(IsEmpty())
//        {
//            front=new Node<E>(element,null);
//            rear=front;
//        }
//        else
//        {
//            rear.addAfter(element);
//            rear=rear.getLink();
//        }
//        NumOfElements++;
//    }
//    public E remove()
//    {
//        E temp;
//        if(IsEmpty())
//        {
//            System.out.println("Queue IS Empty");
//            return null;
//        }
//        else
//        {
//            temp= front.getData();
//            front=front.getLink();
//            NumOfElements--;
//            if (NumOfElements==0)
//                rear=null;
//            return temp;
//        }
//
//    }
//    public int getNumOfElements()
//    {
//        return NumOfElements;
//    }
//    public E getfront()
//    {
//
//        if(IsEmpty())
//        {
//            System.out.println("Queue IS Empty");
//            return null;
//        }
//        else
//        {
//
//         return front.getData();
//        }
//
//    }
//    public E getrear()
//    {
//
//        if(IsEmpty())
//        {
//            System.out.println("Queue IS Empty");
//            return null;
//        }
//        else
//        {
//
//            return rear.getData();
//        }
//
//    }
//}

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
    private int size;

    public LinkedQueue(){
        front = rear = null;
        size = 0;
    }

    
}