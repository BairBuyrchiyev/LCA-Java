
import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    private ArrayList<Node> children = new ArrayList<Node>();

    Node(int value) {
        data = value;
    }

    void addChild(Node node) {
        children.add(node);
    }

    boolean hasChildren() {
        if (children.isEmpty()) return false;
        return true;
    }

    int numChildren() {
        return children.size();
    }

    Node getChild(int i) {
        return children.get(i - 1);
    }
}

public class LCA
{

    Node root;
    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();

    int findLCA(int n1, int n2) {
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2);
    }

    private int findLCAInternal(Node root, int n1, int n2) {

        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
            return -1;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {

			if (!path1.get(i).equals(path2.get(i)))
				break;
        }

        return path1.get(i-1);
    }

    private boolean findPath(Node root, int n, List<Integer> path)
    {
        if (root == null) {
            return false;
        }

        path.add(root.data);

        if (root.data == n) {
            return true;
        }

        if (root.hasChildren()) {
            for (int i = 0; i < root.numChildren(); i++) {
                if (findPath(root.getChild(i + 1), n, path)) return true;
            }
        }

        path.remove(path.size()-1);

        return false;
    }
} 