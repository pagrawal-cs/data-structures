import java.util.ArrayList;
import java.util.List;

/**
    Add a method void depthFirst(Visitor v) to the Tree class of
    Section 17.4 (below).
    Keep visiting until the visit method returns false.
*/
public class Tree
{
    private Node root;

    class Node
    {
        public Object data;
        public List<Node> children;

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int sum = 0;
            for (Node child : children) { sum = sum + child.size(); }
            return 1 + sum;
        }
    }

    /**
        Constructs an empty tree.
    */
    public Tree()
    {
        root = null;
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<>();
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size()
    {
        if (root == null) { return 0; }
        else { return root.size(); }
    }

    // Additional methods will be added in later sections.
    
    /**
        Performs a depth-first traversal (pre-order).
        @param v the visitor to process each node
    */
    public void depthFirst(Visitor v)
    {
        if (root != null) {
            depthFirstHelper(root, v);
        }
    }

    // Helper method for depthFirst traversal
    private void depthFirstHelper(Node node, Visitor v)
    {
        if (node == null || !v.visit(node.data)) {
            return;
        }
        for (Node child : node.children) {
            depthFirstHelper(child, v);
        }
    }

    /**
        Performs a postorder traversal.
        @param v the visitor to process each node
    */
    public void postorder(Visitor v)
    {
        if (root != null) {
            postorderHelper(root, v);
        }
    }

    // Helper method for postorder traversal
    private void postorderHelper(Node node, Visitor v)
    {
        if (node == null) {
            return;
        }
        for (Node child : node.children) {
            postorderHelper(child, v);
        }
        v.visit(node.data); // Visit after children
    }
}
