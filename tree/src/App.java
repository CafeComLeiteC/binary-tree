import edu.edii.treegeneric.Node;
import edu.edii.treegeneric.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        Tree<String> tree = new Tree<>();
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");
        Node<String> f = new Node<>("F");
        Node<String> g = new Node<>("G");

        tree.addRoot(a);
        System.out.println(tree.isEmpty());
        try {
            System.out.println(tree.root().toString());
        } catch (Exception msg) {
            System.out.println(msg.getMessage());
        }
       
        tree.addChild(a, b);
        tree.addChild(a, c);
        tree.addChild(a, d);
        tree.addChild(b, e);
        tree.addChild(b, f);
        tree.addChild(d, g);

        System.out.println("Vericando se B é interno:" + tree.isInternal(b));
        System.out.println("Vericando se E é interno:" + tree.isInternal(e));
        
        System.out.println("Vericando se G é um nó folha:" + tree.isExternal(g));
        System.out.println("Vericando se D é um nó folha:" + tree.isExternal(d));
        try {
            System.out.println("Verificando o pai de F: " + tree.parent(f));
        } catch (Exception m) {
            System.out.println(m.getMessage());
        }
        
        System.out.println("Filhos de A:");
        for (Node<String> n : tree.children(a)) {
            System.out.println(n);
        }

        System.out.println("Filhos de B:");
        for (Node<String> n : tree.children(b)) {
            System.out.println(n);
        }

    }
}
