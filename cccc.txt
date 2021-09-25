public class BinarySearchTree {
    static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    static Node root = null;
二叉搜索树插入
    public static void put(int key) {
        Node node = new Node(key);
        if(root == null) {
            root = node;
            return;
        }
        Node parent = null;
        Node cur = root;
        while (cur != null) {
            if(cur.data < key) {
                parent = cur;
                cur = cur.right;
            }else if(cur.data > key) {
                parent = cur;
                cur = cur.left;
            }else {
                cur.data = key;
                return;
            }
        }
        //cur == null parent = cur的父亲
        if(parent.data < key) {
            parent.right = node;
        }else {
            parent.left = node;
        }
    }

二叉搜索树查找
    public static Node findVal(int val) {
        if(root == null) return null;
        Node cur = root;
        while (cur != null) {
            if(c
        }
        return null;
    }
中序遍历
    pur.data == val) {
                return cur;
            }else if(cur.data < val){
                cur = cur.right;
            }else {
                cur = cur.left;
            }ublic static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
前序遍历
    public static void preorder(Node root) {
        if(root == null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int[] array = {15,23,19,67,4,19,10};
        for (int i = 0; i < array.length; i++) {
             put(array[i]);
        }
        put(15);
        inorder(root);
        System.out.println("=====================");
        preorder(root);
        System.out.println("===================");
        try {
            System.out.println(findVal(167).data);
        }catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("没有这个节点");
        }
    }
}
二叉搜索树删除
public static boolean remove(int key) {
        Node cur = root;
        Node parent = null;
        while (cur != null) {
            if(cur.data == key) {
                removeNode(parent,cur);
                return true;
            }else if(cur.data < key) {
                parent = cur;
                cur = cur.right;
            }else {
                parent = cur;
                cur = cur.left;
            }
        }
        return false;
    }

    /**
     * @param parent  要删除节点的父亲节点
     * @param cur   当前需要删除的节点
     */
    public static void removeNode(Node parent,Node cur){
        if(cur.left == null) {
            if(cur == root) {
                root = cur.right;
            }else if(parent.left == cur) {
                parent.left = cur.right;
            }else {
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root) {
                root = cur.left;
            }else if(cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else {
            Node targetParent = cur;
            Node target = targetParent.right;
            while(target.left != null) {
                targetParent = target;
                target = target.left;
            }
            cur.data = target.data;
            if(target == targetParent.left) {
                targetParent.left = target.right;
            }else {
                targetParent.right = target.right;
            }
        }
    }