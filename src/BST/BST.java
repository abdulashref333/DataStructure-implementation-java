package BST;

import java.lang.Math;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BST<E>{

    private class Node<E>{
         E data;
         Node<E> left;
         Node<E> right;
         public Node(E obj){
             data = obj;
             left = null;
             right = null;
         }
    }
    private Node<E> root;
    private int size;
//    public int count = 0;
    public interface CallBack{
        public void callBack(Object obj);
    }
    public BST(){
        root = null;
        size  = 0 ;
    }

    private void addHelper(Node<E> tmp, E obj){
        if((((Comparable<E>)tmp.data).compareTo(obj)) < 0 ){
            if(tmp.right == null){
                Node<E> n = new Node<E>(obj);
                tmp.right = n;
                size++ ;
            }else{
                addHelper(tmp.right, obj);
            }
        }else{
            if(tmp.left == null){
                Node<E> n = new Node<E>(obj);
                tmp.left = n;
                size ++;
            }else{
                addHelper(tmp.left, obj);
            }
        }
    }
    public void add(E obj){
        Node<E> n = new Node<E>(obj);
        if(root == null){
            root = n;
            size++;
            return ;
        }
        /*
        // iterative solution..

        Node<E> tmp = root;
        Node<E> parent = null;
        while(tmp != null){
            parent = tmp;
            if((((Comparable<E>)tmp.data).compareTo(obj)) < 0 ){
                tmp = tmp.right;
            }else{
                tmp = tmp.left;
            }
        }
        if((((Comparable<E>)parent.data).compareTo(obj)) < 0 ){
            parent.right = n;
        }else{
            parent.left = n;
        }
        size ++;

         */
        // recursive solution ..
        addHelper(root, obj);

    }
    public E getMax(){
        Node<E> tmp = root;
        if(root == null)    return null;
        while(tmp.right != null) {
            tmp = tmp.right;
        }
        return tmp.data;
    }

    public E getMin(){
        Node<E> tmp = root;
        if(root == null)    return null;
        while(tmp.left != null) {
            tmp = tmp.left;
        }
        return tmp.data;
    }

    private int getHeightHelper(Node<E> tmp){
        if(tmp.left == null)    return -1;
        if(tmp.right ==null)    return -1;
        int lHeigte = getHeightHelper(tmp.left);
        int rHeighte = getHeightHelper(tmp.right);

        return 1+Math.max(lHeigte,rHeighte);
    }
    public int getHeight(){
        if(root == null)    return -1;
        // this equation for binary search tree..
        return (int)(Math.log10(size+1)/Math.log10(2))-1;
        // this solution is general for all sort of trees.
//        return getHeightHelper(root);
    }

    private void traverseHelp(Node<E> tmp,CallBack cb){
//  for printing in prefix way with DFS
//        System.out.println(tmp.data);
//        cb.callBack(tmp.data);
//
        if(tmp.left != null)    {
            traverseHelp(tmp.left, cb);
        }
//      for printing in inorder way.. note that inorder will print sorted elements.
//        System.out.println(tmp.data);
        cb.callBack(tmp.data);
        if(tmp.right != null)   {
            traverseHelp(tmp.right, cb);
        }
    }
    public void travers(CallBack cb){
        if(root == null)    return ;
        traverseHelp(root , cb);
    }

    public void traversWithBFS(){
        Queue<Node<E>> q = new LinkedList();
        q.add(root);
        Node<E> current = null;
        while(!q.isEmpty()){
            current = q.poll();
            System.out.println(current.data);
            if(current.left != null)    q.add(current.left);
            if(current.right != null)    q.add(current.right);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isFound(E obj){
        Node<E> tmp = root;
        while(tmp != null){
            if((((Comparable<E>)tmp.data).compareTo(obj)) < 0 ){
                tmp = tmp.right;
//                count++;
            }else if((((Comparable<E>)tmp.data).compareTo(obj)) > 0 ){
                tmp = tmp.left;
//                count++;
            }else{
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }


}
