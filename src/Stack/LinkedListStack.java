package Stack;

class LinkedListStack<E> {
    private class Node<E> {
        private E data;
        private Node<E> next;
        public Node(E obj){
            data = obj;
            next = null;
        }
    }
    private Node<E> top;
    private int currentSize;
    public LinkedListStack(){
        top = null;
        currentSize = 0;
    }

    public void push(E obj) {
        Node<E> node = new Node<E>(obj);
        if(top == null){
            top = node;
            return;
        }
        node.next = top;
        top = node;
        currentSize++;
    }

    public E pop() {
        if(top == null){
            return null;
        }
        E ans = top.data;
        top = top.next;
        currentSize--;
        return ans;
    }
    public E peek() {
        // just return the data in the first node without removing the node

        if(top == null){
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public boolean isFull() {
        return false;
    }


}
