package cn.yangtengfei.base.dataStruct.binaryTree;

/**
 * Created by admin on 2018/3/21.
 */
public class CompleteBinaryTree<E> extends BinaryTree<E> {

    public BinaryNode<E> create(E[] levelorder, int i){
        BinaryNode<E> p = null;
        if(i<levelorder.length){
            p = new BinaryNode<E>(levelorder[i]);
            p.left = create(levelorder,2*i+1);
            p.right = create(levelorder,2*i+2);
        }
        return p;
    }
}
