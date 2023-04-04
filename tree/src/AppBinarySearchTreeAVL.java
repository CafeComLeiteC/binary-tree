import edu.edii.binarysearchtreeavl.BinarySearchTreeAVL;

public class AppBinarySearchTreeAVL {
    public static void main(String[] args) {
        BinarySearchTreeAVL<String> bt = new BinarySearchTreeAVL<>();
        bt.put(50, "A");
        bt.put(40, "B");
        bt.put(30, "C");
        bt.put(45, "D");
        bt.put(60, "E");
        // bt.remove(40);
        bt.inOrder();

        // System.out.println(bt.get(10));

    }
}
