package Queue;

import priority.ArrayPriorityQue;

public class Test {
    public static void main(String [] args){
        SingleRQue<Integer> pq = new SingleRQue<Integer>();
//        pq.add(5);
//        pq.add(3);
//        pq.add(1);

        System.out.println(pq.remove());
//        System.out.println(pq.getSize());

        System.out.println(pq.remove());
//        System.out.println(pq.getSize());

        System.out.println(pq.remove());
    }
}
