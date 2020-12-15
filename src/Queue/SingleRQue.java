package Queue;
// question 6

public class SingleRQue<E> {
    private class Node<E> {
        E data;
        Node<E> next;
        public Node(E item, Node link) {
            data = item;
            next = link;
        }
    }
    private Node<E> rear;
    private int size;
    public SingleRQue(){
        rear = null;
        size = 0;
    }

    public void add(E item){
        Node<E> node = new Node<E>(item,rear);
        size++;
        if(rear == null){
            rear = node;
            node.next = rear;
            return;
        }
        node.next = rear.next;
        rear.next = node;
        rear = node;
    }

    public E remove() {
        if(rear == null)    return null;
        E e;
        if(size == 1){
            e = rear.data;
            rear = null;
            return e;
        }
        e = rear.next.data;
        rear.next = rear.next.next;
        return e;
    }
}
