package AvoreBI;

// Classe Node representa um nó da árvore binária
class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        this.left = this.right = null;
    }
}

// Classe BinaryTree com inserção e percursos
class BinaryTree {
    Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) return new Node(value);
        if (value < root.value) root.left = insertRec(root.left, value);
        else if (value > root.value) root.right = insertRec(root.right, value);
        return root;
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.value + " ");
            inOrderRec(node.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.print(node.value + " ");
        }
    }
}

// Classe BSTValidator para validar se é uma árvore de busca
class BSTValidator {
    public boolean isBST(Node root) {
        return isBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTRec(Node node, int min, int max) {
        if (node == null) return true;
        if (node.value <= min || node.value >= max) return false;
        return isBSTRec(node.left, min, node.value) &&
               isBSTRec(node.right, node.value, max);
    }
}

// Classe Main para testar o programa
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(18);

        System.out.println("Pré-Ordem:");
        tree.preOrder(); // 10 5 3 7 15 12 18

        System.out.println("Em Ordem:");
        tree.inOrder(); // 3 5 7 10 12 15 18

        System.out.println("Pós-Ordem:");
        tree.postOrder(); // 3 7 5 12 18 15 10

        BSTValidator validator = new BSTValidator();
        boolean isBST = validator.isBST(tree.root);
        System.out.println("A árvore é uma BST? " + isBST); // true
    }
}
