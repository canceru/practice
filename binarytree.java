import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14495
 * Date: 2021-02-27
 * Time: 13:12
 */

class Node{
    public char val;
    public Node left;
    public Node right;
    public Node(char val){
        this.val = val;
    }
}
public class BinaryTree {
    public Node createTree(){
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;
        return A;
    }
    // 前序遍历
    void preOrderTraversal(Node root){
        if(root == null)
            return;
        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    // 中序遍历
    void inOrderTraversal(Node root){
        if(root == null)
            return;
        preOrderTraversal(root.left);
        System.out.print(root.val+ " ");
        preOrderTraversal(root.right);
    }
    // 后序遍历
    void postOrderTraversal(Node root){
        if(root == null)
            return;
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.val+" ");
    }

    // 遍历思路-求结点个数
    static int size = 0;
    void getSize1(Node root){
        if(root == null)
            return;
        size++;
        getSize1(root.left);
        getSize1(root.right);
    }
    // 子问题思路-求结点个数
    int getSize2(Node root){
        if(root == null)
            return 0;
        return getSize2(root.left)+getSize2(root.right)+1;
    }

    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1(Node root){
        if(root == null)
            return ;
        if(root.left==null && root.left == null){
            leafSize++;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }
    // 子问题思路-求叶子结点个数
    int getLeafSize2(Node root){
        if(root == null)
            return 0;
        if(root.left==null && root.left == null){
            return 1;
        }
        return getLeafSize2(root.left)+getLeafSize2(root.right);
    }

    // 子问题思路-求第 k 层结点个数
    int getKLevelSize(Node root,int k){
        if(root == null)
            return 0 ;
        if(k == 1)
            return 1;
        return getKLevelSize(root.left,k-1)+getKLevelSize(root.right,k-1);
    }
    //给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
    //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的
    public boolean isSameTree(Node p, Node q) {
            if(p==null&&q!=null || p!=null&&q==null){
                return false;
            }
            if(p==null && q==null){
                return true;
            }
            if(p.val != q.val){
                return false;
            }
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    //给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
    public boolean isSubtree(Node s, Node t) {
        if(s == null && t == null){
            return false;
        }
        if(isSameTree(s,t)) return true;
        if(isSubtree(s.left,t)) return true;
        if(isSubtree(s.right,t)) return true;
        return false;
    }

    // 获取二叉树的高度
    int getHeight(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight>rightHeight ? leftHeight+1:rightHeight+1;
    }
    // 查找 val 所在结点，没有找到返回 null
    // 按照 根 -> 左子树 -> 右子树的顺序进行查找
   // 一旦找到，立即返回，不需要继续在其他位置查找
    Node find(Node root, int val){
        if(root == null)
            return null;
        if(root.val == val)
            return root;
        Node leftVal= find(root.left,val);
        if(leftVal != null){
            return leftVal;
        }
        Node rightVal = find(root.right,val);
        if(rightVal != null){
            return rightVal;
        }
        return null;
    }

    //给定一个二叉树，判断它是否是高度平衡的二叉树。
    public boolean isBalanced(Node root) {
        if(root == null)
            return true;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        Boolean ret = Math.abs(leftHeight-rightHeight)<2
                && isBalanced(root.left)
                && isBalanced(root.right);
        return ret;
    }
    //给定一个二叉树，检查它是否是镜像对称的。
    public boolean isSymmetricChild(Node leftTree,Node rightTree) {
        if(leftTree==null&&rightTree!=null || leftTree!=null&&rightTree==null){
            return false;
        }
        if(leftTree==null&&rightTree==null){
            return true;
        }
        if(leftTree.val == rightTree.val && isSymmetricChild(leftTree.left,rightTree.right) && isSymmetricChild(leftTree.right,rightTree.left)){
            return true;
        }
        return false;
    }

    public boolean isSymmetric(Node root) {
        if(root == null) return true;
        return isSymmetricChild(root.left,root.right);
    }

    // 层序遍历
    void levelOrderTraversal(Node root){
        if(root == null)
            return ;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.print(cur.val+" ");
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
    }

    public List<List<Character>> levelOrder(Node root) {
        List<List<Character>> ret = new LinkedList<>();
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Character> row = new ArrayList<>();
            int count = queue.size();
            while(count != 0){
                Node cur = queue.poll();
                row.add(cur.val);
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
                count--;
            }
            ret.add(row);
        }
        return ret;
    }
}


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14495
 * Date: 2021-02-27
 * Time: 13:12
 */
public class TestDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.createTree();
        binaryTree.preOrderTraversal(root);
        System.out.println();
        binaryTree.inOrderTraversal(root);
        System.out.println();
        binaryTree.postOrderTraversal(root);
        System.out.println();
        binaryTree.getSize1(root);
        System.out.println(BinaryTree.size);
        System.out.println(binaryTree.getSize2(root));
        System.out.println(binaryTree.getLeafSize2(root));
        binaryTree.getLeafSize1(root);
        System.out.println(BinaryTree.leafSize);
        System.out.println(binaryTree.getKLevelSize(root,3));
        System.out.println("================");
        System.out.println(binaryTree.getHeight(root));
        System.out.println(binaryTree.find(root, 'B').val);
        binaryTree.levelOrderTraversal(root);
        System.out.println();
    }
}
