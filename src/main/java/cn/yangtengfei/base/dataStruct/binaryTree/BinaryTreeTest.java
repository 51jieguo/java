package cn.yangtengfei.base.dataStruct.binaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        //BinaryNode<String> binaryTree = new BinaryNode<String>("A");

        BinaryNode<String> binaryNodeG = new BinaryNode<String>("G");
        BinaryNode<String> binaryNodeH = new BinaryNode<String>("H");
        BinaryNode<String> binaryNodeD = new BinaryNode<String>("D",null,binaryNodeG);
        BinaryNode<String> binaryNodeE = new BinaryNode<String>("E");
        BinaryNode<String> binaryNodeF = new BinaryNode<String>("F",binaryNodeH,null);
        BinaryNode<String> binaryNodeB = new BinaryNode<String>("B",binaryNodeD,null);
        BinaryNode<String> binaryNodeC = new BinaryNode<String>("C",binaryNodeE,binaryNodeF);
        BinaryNode<String> binaryNodeA = new BinaryNode<String>("A",binaryNodeB,binaryNodeC);
        BinaryTree<String> binaryNodeBinaryTree = new BinaryTree<String>();


        binaryNodeBinaryTree.preOrder(binaryNodeA);

        System.out.println("");

        binaryNodeBinaryTree.inOrder(binaryNodeA);

        System.out.println("");

        binaryNodeBinaryTree.postOrder(binaryNodeA);

        System.out.println("");
        int count = binaryNodeBinaryTree.count(binaryNodeA);
        System.out.print("count:"+count);

        System.out.println("");
        int height = binaryNodeBinaryTree.height(binaryNodeA);
        System.out.print("count:"+height);


    }
}