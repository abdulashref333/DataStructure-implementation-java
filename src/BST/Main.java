package BST;

public class Main {

    public interface Visitor{

        int doJob(int a, int b);

    }
    public static void main(String[] args) {
        // test code here..


        BST<Integer> l = new BST<Integer>();
//        System.out.println(Math.log10(2)/Math.log10(2));
        l.add(10);
        l.add(5);
        l.add(15);
        l.add(12);
        l.add(1);
        l.add(7);
        l.add(16);
        l.add(8);
        l.add(6);
        l.add(55);
//
//        l.travers((a) -> System.out.println(a));
//        l.traversWithBFS();
//        System.out.println("height is = "+l.getHeight());
//        System.out.println(l.getSize());
        System.out.println(l.isFound(7));
//        System.out.println(l.count);
        System.out.println(l.isFound(10));
//        System.out.println(l.count);

    }
}
