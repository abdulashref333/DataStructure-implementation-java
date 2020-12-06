package LinkedList;

public class Main {
    public static void main(String[] args){
        //test DoublyLinkedList..
//        System.out.println("hi doubly linked list");
//        DoublyLinkedList<Integer> dList = new DoublyLinkedList<Integer>();
//        dList.addFirst(22);
//        dList.addLast(44);
//        dList.addAfter(2,55);
//        dList.removeFirst();
//        dList.removeLast();
//        System.out.println(dList.contains(22));
//        System.out.println(dList.getCurrentSize());
//        dList.remove(22);
//        System.out.println(dList.contains(55));
        int inversionCount = 0;
        int x[] = {1,5,4,3,2};
        for (int i=0 ; i < x.length - 1 ; i++)
        {
            for(int j=i+1;j<x.length;j++)
            {
                if (x[i] > x[j])
                    inversionCount++;
            }
        }

        System.out.println(inversionCount);
    }

    public static void generateFibonacci(int c){
        int n1=0, n2=1, n3, count=c;
        System.out.print(n1+" "+n2);

        for(int i=2; i<count; ++i) {
            n3 = n1+n2;
            System.out.print(" "+n3);
            n1=n2;
            n2=n3;
        }
    }

    public static void sumValue(int [] x) {
        int N = x.length;
        int sum = 0;
        System.out.print("X[K]: ");
        for (int k =0;k<N;k++){
            for(int i=0; i<N; i++) {
                double div = (-2 * Math.PI * i * k) / N;
                double exp = Math.exp(div);
                sum += x[i]*exp;
            }
            System.out.print(sum + " ");
            sum = 0;
        }
    }

    public static void descendingOrder(int []a) {
        int temp ;
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] < a[j])
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.print("Descending Order:");
        for (int i = 0; i < a.length - 1; i++)
        {
            System.out.print(a[i] + ",");
        }
        System.out.print(a[a.length - 1]);
    }

    public static int[] crossProduct(int []u, int[] v){
        int answer [] = new int[4];
        answer[1] = u[2] * (v[3] - v[2]) * u[3];
        answer[2] = v[1] * (u[3] - u[1]) * v[3];
        answer[3] = u[1] * (v[2] - v[1]) * u[2];

        return answer;
    }
}
