package cn.yangtengfei.base.dataStruct.binaryTree;

public class BinaryNode<E> {

    public E data;
    public BinaryNode<E> left,right;

    public BinaryNode(E data) {
        this(data,null,null);
    }

    public BinaryNode(E data, BinaryNode<E> left, BinaryNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf(){
        return this.left==null && this.right == null;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
