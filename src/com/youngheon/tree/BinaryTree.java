package com.youngheon.tree;

import com.youngheon.queue.LLQueue;
import com.youngheon.stack.LLStack;

/**
 * Created by Young-heon on 2016. 5. 7..
 */
class BinaryTreeNode{
    int data;
    class BinaryTreeNode left; //*left by book
    class BinaryTreeNode right; //*right by book
}

public class BinaryTree {

    void PreOrder(BinaryTreeNode root){
        if(root !=null){
            System.out.println(root.getData());
            PreOrder(root.getLeft());
            PreOrder(root.getRight());
        }
    }

    void PreOrderNonRecursive(BinaryTreeNode root){
        if(root == null) return null;
        LLStack S = new LLStack();
        while(true){
            while(root !=null){
                System.out.println(root.getData());
                S.push(root);
                root = root.getLeft();
            }
            if(S.isEmpty())
                break;
            root = (BinaryTreeNode) S.pop();
            root = root.getRight();
        }
        return;
    }

    void InOrder(BinaryTreeNode root){
        if(root != null){
            InOrder(root.getLeft());
            System.out.println(root.getData());
            InOrder(root.getRight);
        }
    }

    void InOrderNonRecursive(BinaryTreeNode root){
        if(root==null) return null;
        LLStack S = new LLStack();
        while(true){
            while(root != null){
                S.push(root);
                root = root.getLeft();
            }
            if(S.isEmpty()) // stack.isEmpty by Book.
                break;
            root = (BinaryTreeNode) S.pop();
            System.out.println(root.getData());
            root = root.getRight();
        }
        return;
    }

    void PostOrder(BinaryTreeNode root){
        if(root){
            PostOrder(root.getLeft());
            PostOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    void PostOrderNonRecursive(BinaryTreeNode root){
        LLStack S = new LLStack();
        while(true){  // while(1) by book;;
            if(root !=null){
                S.push(root);
                root = root.getLeft();
            }
            else{
                if(S.isEmpty()){
                    System.out.println("Stack is Empty");
                    return;
                }
                else{
                    if(S.top().getRight() == null){
                        root = S.pop();
                        System.out.println(root.getData());
                        while(!S.isEmpty() && root == S.top().getRight()){
                            root = S.pop();
                            System.out.println(root.getData());
                        }
                    }
                    if(!S.isEmpty())
                        root = S.top().getRight();
                    else
                        root = null;
                }
            }
            S.deleteStack();
        }
    }
    void LevelOrder(BinaryTreeNode root){
        BinaryTreeNode temp;
        LLQueue Q = new LLQueue();
        if(!root){
            return;
        }
        Q.enQueue(root);
        while(!Q.deQueue()){
            temp = Q.deQueue();
            System.out.println(temp.getData());
            if(temp.getLeft())
                Q.enQueue(temp.getLeft());
            if(temp.getRight())
                Q.enQueue(temp.getRight());
        }
        Q.deleteQueue();
    }

}

