import java.util.ArrayList;

/**
 * 通过前序遍历的序列来实现二叉树的创建
 *         A
 *     B        C
 * D      E         F
 * 前序ABD##E##C#F##
 */
public class BinaryTree<T extends Comparable<T>> {
    public class TreeNode{
        public T e;
        public TreeNode left,right;
        public TreeNode(T e){
            this.e=e;
            left=null;
            right=null;
        }
    }
    private TreeNode root;
    private int size;
    public void createBinaryTreePre(int index,ArrayList<T>data){
        binaryTreePre(data.size(),data);
    }

    private TreeNode binaryTreePre(int size, ArrayList<T> data) {
        if(data.size()==0){
            return null;
        }
        T d=data.get(0);
        TreeNode node=new TreeNode(d);
        int index=size-data.size();
        if(d.equals("#")){
            node=null;
            data.remove(0);
            return node;
        }
        if(index==0){
            root=node;
            data.remove(0);
        }
        else{
            data.remove(0);
            node.left=binaryTreePre(size,data);
            node.right=binaryTreePre(size,data);
        }
        return node;
    }
}
