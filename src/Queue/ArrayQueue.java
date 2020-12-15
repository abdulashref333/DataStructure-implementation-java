package Queue;

public class ArrayQueue<E> {
    private interface CallBack{
        public void callBack(Object obj);
    }
    private Object[] data;
    private int front, rear, size;
    public ArrayQueue(){
        front = rear = size = 0;
        data = new Object[10];
    }

    public ArrayQueue(int initialSize){
        this();
        if(initialSize < 0){
            System.out.println("it's too small size");
            return;
        }
        data = new Object[initialSize];
    }

    public void add(E obj){
        if(!isFull()){
            if(rear == data.length) rear = 0;
            data[rear++] = obj;
            size ++;
            return;
        }
        System.out.println("The Queue is full!");
    }

    public E remove() {
        if(isEmpty())   return null;
        if(front == data.length)    front = 0;
        size --;
        return (E)data[front++];
    }

    public void traverse(CallBack cb){
        if(front >= rear){
            //will travers through two sections front:end && start:rear
            int i =front;
            while(i++<data.length){
                cb.callBack(data[i]);
            }
            i = 0;
            while(i++<rear){
                cb.callBack(data[i]);
            }
        }else{
            for(int i=front;i<rear;i++){
                cb.callBack(data[i]);
            }
        }
    }
    public E getFront() {
        if(isEmpty())   return null;
        return (E) data[front];
    }

    public E getRear() {
        if(isEmpty())   return null;
        return (E) data[rear-1];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int getSize() {
        return size;
    }
    public boolean isFull() {
        return size == data.length-1;
    }
}