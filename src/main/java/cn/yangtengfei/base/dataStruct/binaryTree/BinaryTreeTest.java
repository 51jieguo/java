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


        System.out.println("");
        BinaryNode<String> stringBinaryNode = binaryNodeBinaryTree.search(binaryNodeA,"C");
        System.out.println(stringBinaryNode.toString());

        System.out.println("");
        stringBinaryNode = binaryNodeBinaryTree.searchParentNode(binaryNodeA,binaryNodeG);
        System.out.println(stringBinaryNode.toString());

        System.out.println("----------通过先根数组生成二叉树----------------");
        String [] preOrder = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F",null,"H"};
        BinaryNode<String> root = binaryNodeBinaryTree.creatBinaryTree(preOrder);
        binaryNodeBinaryTree.preOrder(root);

        //二叉树插入操作
        System.out.println("");
        System.out.println("----------二叉树插入操作----------------");
        System.out.println("");
        root = binaryNodeBinaryTree.insertOneNode(root,"S",true);

        root = binaryNodeBinaryTree.insertOneNode(root,"T",false);
        binaryNodeBinaryTree.preOrder(root);
        System.out.println("");
        binaryNodeBinaryTree.inOrder(root);
        System.out.println("");
        binaryNodeBinaryTree.postOrder(root);
        System.out.println("");

        //完全二叉树生成
        System.out.println("----------完全二叉树生成----------------");
        String [] levelOrder = {"A","B","C","D","E","F","G","H"};
        CompleteBinaryTree<String> completeBinaryTree = new CompleteBinaryTree<>();
        root = completeBinaryTree.create(levelOrder,0);
        binaryNodeBinaryTree.preOrder(root);

    }
}
