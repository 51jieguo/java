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

    public BinaryNode<E> search(BinaryNode<E> p,E value){
        BinaryNode<E> binaryNodeTemp = null;
        if(p!=null && value!=null){
            if(p.data.equals(value)){
                binaryNodeTemp=p;
            }else{
                binaryNodeTemp = search(p.left,value);
                if(binaryNodeTemp==null){
                    binaryNodeTemp = search(p.right,value);
                }
            }
        }
        return binaryNodeTemp;
    }

    public BinaryNode<E> searchParentNode(BinaryNode<E> p,BinaryNode<E> searchNode){
        BinaryNode<E> binaryNodeTemp = null;
        if(p!=null){
            if(p.left==searchNode || p.right==searchNode){
                binaryNodeTemp = p;
            }else{
                binaryNodeTemp = searchParentNode(p.left,searchNode);
                if(binaryNodeTemp==null){
                    binaryNodeTemp = searchParentNode(p.right,searchNode);
                }
            }
        }
        return binaryNodeTemp;
    }
    private int i=0;
    public BinaryNode<E> creatBinaryTree(E[] preOrder){
        BinaryNode<E> p = null;
        if(i<preOrder.length){
            E element = preOrder[i];
            i++;
            if(element!=null){
                p = new BinaryNode<E>(element);
                p.left = creatBinaryTree(preOrder);
                p.right = creatBinaryTree(preOrder);
            }
        }
        return p;
    }

    /**
     * 二叉树插入操作
     * @param p
     * @param element
     * @param isLeft
     * @return
     */
    public BinaryNode<E> insertOneNode(BinaryNode<E> p,E element, boolean isLeft){
        if(p!=null){
            if(isLeft){
                p.left =  new BinaryNode<E>(element,p.left,null);
            }else{
                p.right =  new BinaryNode<E>(element,null,p.right);
            }
        }
        return p;
    }
}
