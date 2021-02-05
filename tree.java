
public class Tree {

    private Node root;   


    public ArrayList<ArrayList<Node>> getPathsFromRootToAnyLeaf() {
        ArrayList<ArrayList<Node>> paths = new ArrayList<ArrayList<Node>>();
        ArrayList<Node> currentPath = new ArrayList<Node>();
        getPath(root, currentPath, paths);

        return paths;
    }

    private void getPath(Node node, ArrayList<Node> currentPath,
                         ArrayList<ArrayList<Node>> paths) {
        if (currentPath == null)
            return;

        currentPath.add(node);

        if (node.getChildren().size() == 0) {
            // This is a leaf
            paths.add(clone(currentPath));
        }
        for (Node child : node.getChildren())
            getPath(child, currentPath, paths);

        int index = currentPath.indexOf(node);
        for (int i = index; i < currentPath.size(); i++)
            currentPath.remove(index);
    }

    private ArrayList<Node> clone(ArrayList<Node> list) {
        ArrayList<Node> newList = new ArrayList<Node>();
        for (Node node : list)
            newList.add(new Node(node));

        return newList;
    }
}
