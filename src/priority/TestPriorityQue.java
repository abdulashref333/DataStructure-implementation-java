package priority;

public class TestPriorityQue {
    public static void main(String [] args){
        PriorityQue<String> pq = new PriorityQue<String>();
        pq.add("Ashraf ",0);
//        pq.add("Welcome, ", 3);
//        pq.add("Abdulrahman ", 0);

        System.out.println(pq.remove());
//        System.out.println(pq.getSize());

        System.out.println(pq.remove());
        System.out.println(pq.isFull());

        System.out.print(pq.remove());
    }
}
