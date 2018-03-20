package cn.yangtengfei.base.dataStruct.binaryTree;

public class BinaryTree<E> {

    public void preOrder() {
        System.out.println("先根序列：");
    }

    public void preOrder(BinaryNode<E> p) {
        if (p != null) {
            System.out.print(p.data + "\t");
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    public void inOrder(BinaryNode<E> p) {
        if (p != null) {
            inOrder(p.left);
            System.out.print(p.data + "\t");
            inOrder(p.right);
        }
    }

    public void postOrder(BinaryNode<E> p) {
        if (p != null) {
            postOrder(p.left);
            postOrder(p.right);
            System.out.print(p.data + "\t");
        }
    }

    public int count(BinaryNode<E> p) {
        if (p != null) {
            return 1 + count(p.left) + count(p.right);
        }
        return 0;
    }

    public int height(BinaryNode<E> p) {
        if (p != null) {
            int ld = height(p.left);
            int rd = height(p.right);
            if (ld > rd) {
                return ld + 1;
            } else {
                return rd + 1;
            }
        }
        return 0;
    }
}
