import edu.edii.binarysearchtree.BinarySearchTree;

public class AppBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.put(100, "A");
        bst.put(90, "B");
        bst.put(80, "C");
        bst.put(120, "D");
        bst.put(110, "E");
        bst.put(8, "F");
        bst.put(12, "G");
        bst.put(33, "H");

        bst.remove(10);

        bst.preOrder();

        // System.out.println(bst.get(33) != null ? bst.get(33) : "Não encontrado");

        
    }
}
