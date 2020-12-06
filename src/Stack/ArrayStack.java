package Stack;

public class ArrayStack<E> {
    private int top, currentSize; //currentSize same as top ;
    private Object data [];
    public ArrayStack(){
        top = currentSize = 0;
        data = new Object[10];
    }
    public ArrayStack(int initialCapacity){
        if(initialCapacity < 0){
            throw new IllegalArgumentException("initial capacity is to small.");
        }
        currentSize = top = 0;
        data = new Object[initialCapacity];
    }

    public void ensureCapacity(int minimumCapacity) {
        if(minimumCapacity < data.length);
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == data.length;
    }
    public void push(E obj){
        if(isFull()){
            System.out.println("the stack is full");
            return;
        }
        data[currentSize++] = obj;
    }

    public Object pop(){
        if(isEmpty()){
            System.out.println("the stack is empty");
            return null;
        }
        return data[--currentSize];
    }

    public E peek() {
        if(currentSize == 0){
            return null;
        }
        return (E)data[currentSize-1];
    }
    public E[] trimToSize() {
        E[] newData = (E[])new Object[currentSize];
        for (int i=0;i<currentSize;i++) {
            // copy the old array.
            newData[i] = (E)data[i];
        }
        data = newData;
        return newData;
    }
}
