package Lab6;

import java.util.ArrayList;

public class Lab6_Driver {
    public static void main(String[] args) {

        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        String[] names = { "john", "jake", "jack", "jason", "jesse", "james", "jacob", "jessica", "jenifer", "jesus",
                "jordan" };

        Position<String> A = tree.addRoot("jason");
        Position<String> B = tree.addLeft(A, "john");
        Position<String> E = tree.addRight(B, "jacob");
        Position<String> D = tree.addLeft(B, "jack");
        Position<String> H = tree.addLeft(D, "jesse");
        Position<String> I = tree.addRight(D, "james");
        Position<String> C = tree.addRight(A, "jessica");
        Position<String> F = tree.addLeft(C, "jenifer");
        Position<String> G = tree.addRight(C, "jesus");
        Position<String> K = tree.addRight(G, "jordan");
        Position<String> J = tree.addLeft(G, "jake");

        // The descendants of A
        ArrayList<String> results = new ArrayList<>();
        System.out.print("The descendants of " + A.getElement() + ": ");
        allDescendants(tree, A, results);
        System.out.println(String.join(", ", results));

        // The descendants of C
        results.clear();
        System.out.print("The descendants of " + tree.right(A).getElement() + ": ");
        allDescendants(tree, tree.right(A), results);
        System.out.println(String.join(", ", results));

        // path to root on leftmost node at the deepest level
        pathToRoot(tree, H);

        // Display the height of the tree
        System.out.println("Tree Height: " + tree.height(A));

        // Display the depth of the tree left child of the root node **must use left()
        System.out.println(
                "Depth of left child of the root (" + tree.left(A).getElement() + "): " + tree.depth(tree.left(A)));

        // Remove the node at the leftmost position of the deepest level!
        String removed = tree.remove(H);
        System.out.println("Removed node with: " + removed);

        // Display the final sie of the tree
        int size = tree.size();
        System.out.println("Final tree size: " + size);
    }

    public static void allDescendants(LinkedBinaryTree<String> tree, Position<String> p, ArrayList<String> list) {
        for (Position<String> node : tree.children(p)) {
            if (tree.numChildren(node) != 0) {
                // System.out.print(node.getElement() + ", ");
                list.add(node.getElement());
                allDescendants(tree, node, list);
            } else {
                // System.out.print(node.getElement() + ", ");
                list.add(node.getElement());
            }
        }
        // System.out.println();
    }

    public static void pathToRoot(LinkedBinaryTree<String> tree, Position<String> p) {
        ArrayList<String> list = new ArrayList<>();
        System.out.print("path from " + p.getElement() + " to root (" + tree.root().getElement() + ") : ");

        System.out.print(p.getElement() + ", ");
        while (!(tree.isRoot(p))) {
            list.add(tree.parent(p).getElement());
            p = tree.parent(p);
        }
        System.out.println(String.join(", ", list));
    }
}
