import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DFSGraph {

    static class Node {
        int data;
        List<Node> nodes;

        Node(int data) {
            this.data = data;
            nodes = new ArrayList<>();
        }
    }

    static boolean dfs(Node root, int value, Set<Node> visited) {
        if (visited.contains(root))
            return false;

        visited.add(root);

        if (root.data == value)
            return true;

        for (Node node : root.nodes) {
            if (dfs(node, value, visited))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(2);
        root.nodes.add(new Node(3));
        root.nodes.add(new Node(5));

        System.out.println(dfs(root, 3, new HashSet<Node>()));
    }
}