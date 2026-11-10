public class Tree {
    private Node root;

    public void insert(int value)
    {
        if (root == null)
        {
            root = new Node(value);
        }
        else
        {
            root.insert(value);
        }
    }

    public void traverseInOrder()
    {
        if (root != null)
        {
            root.traverseInOrder();
        }
    }

    public void traverseInOrderDescending()
    {
        if (root != null)
        {
            root.traverseInOrderDescending();
        }
    }

    public Node get(int value)
    {
        if (root != null)
        {
            return root.get(value);
        }
        return null;
    }

    public Node getMin()
    {
         if (root.getLeftChild() == null)
         {
             return root;
         }
         return root.getLeftChild().getMin();
    }

    public Node getMax()
    {
        if (root.getRightChild() == null)
        {
            return root;
        }
        return root.getRightChild().getMax();
    }
}
